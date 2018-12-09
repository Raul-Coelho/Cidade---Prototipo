package com.ifpb.dao;

import com.ifpb.conexao.ConnectionFactory;
import com.ifpb.model.Cidade;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CidadeDaoImpl implements CidadeDAO {

    public ConnectionFactory factory;
    public WKTReader reader;

    public CidadeDaoImpl(){
        factory = new ConnectionFactory();
        reader = new WKTReader();
    }

    @Override
    public List<String> buscarEstado() throws SQLException, ClassNotFoundException {
        List<String> estados = new ArrayList<>();
        try(Connection connection = factory.getConnection()){
            PreparedStatement st = connection.prepareStatement(
                            "SELECT nome " +
                            "FROM estados");

            ResultSet resultSet = st.executeQuery();

            if (resultSet!= null){
                while (resultSet.next()){
                    estados.add(resultSet.getString(1));
                }
                return estados;
            }
        }
        return null;
    }

    @Override
    public List<String> buscarCidadesDoEstado(String estado) throws ClassNotFoundException, SQLException {
        List<String> cidades = new ArrayList<>();
        try(Connection connection = factory.getConnection()){
            PreparedStatement st = connection.prepareStatement(
                            "SELECT c.nome " +
                            "FROM cidade c, estados e " +
                            "WHERE c.estado_id = e.id and e.nome ilike ? "+
                            "ORDER BY c.nome");
            st.setString(1, estado);

            ResultSet resultSet = st.executeQuery();

            if(resultSet!= null) {
                while(resultSet.next()) {
                    cidades.add(resultSet.getString(1));
                }
                return cidades;
            }
        }
        return null;
    }

    @Override
    public String getViewBox(Cidade cidade1, Cidade cidade2) throws SQLException, ClassNotFoundException {
        try(Connection connection = factory.getConnection()){

            PreparedStatement stmt = connection.prepareStatement
                    ("SELECT getViewBox(?,?,?,?)");
            stmt.setString(1, cidade1.getNome());
            stmt.setString(2,cidade2.getNome());
            stmt.setInt(3,cidade1.getEstado_id());
            stmt.setInt(4,cidade2.getEstado_id());

            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next()){
                return resultSet.getString(1);
            }
        }
        return null;
    }

    @Override
    public Cidade buscarCidadeEstado(String cidadeParam, String estadoParam) throws SQLException, ClassNotFoundException, ParseException {
        try (Connection connection = factory.getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement("SELECT c.nome, c.populacao_2010, c.area, ST_AsText(ST_AsEWKT(c.geom)),ST_AsSVG(geom), c.estado_id " +
                                            "FROM cidade c JOIN estados e ON c.estado_id = e.id " +
                                            "WHERE c.nome ilike ? and e.nome ilike ?");
            statement.setString(1, cidadeParam);
            statement.setString(2, estadoParam);

            ResultSet resultado = statement.executeQuery();
            Cidade cidade = new Cidade();

            if(resultado.next()) {
                cidade.setNome(resultado.getString(1));
                cidade.setPopulacao(resultado.getInt(2));
                cidade.setArea(resultado.getFloat(3));
                cidade.setGeom(reader.read(resultado.getString(4)));
                cidade.setSvg(resultado.getString(5));
                cidade.setEstado_id(resultado.getInt(6));
                return cidade;
            }
        }
        return null;
    }
}
