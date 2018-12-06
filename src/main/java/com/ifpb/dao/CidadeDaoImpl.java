package com.ifpb.dao;

import com.ifpb.conexao.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CidadeDaoImpl implements CidadeDAO {

    public ConnectionFactory factory;


    public CidadeDaoImpl(){
        factory = new ConnectionFactory();
    }
    @Override
    public List<String> buscarEstado() throws SQLException, ClassNotFoundException {
        List<String> estados = new ArrayList<>();
        try(Connection connection = factory.getConnection()){
            PreparedStatement st = connection.prepareStatement("SELECT nome FROM estados");

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
}