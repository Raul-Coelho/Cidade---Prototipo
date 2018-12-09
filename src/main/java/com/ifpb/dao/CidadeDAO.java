package com.ifpb.dao;

import com.ifpb.model.Cidade;
import com.vividsolutions.jts.io.ParseException;

import java.sql.SQLException;
import java.util.List;

public interface CidadeDAO {

    List<String> buscarEstado() throws SQLException, ClassNotFoundException;
    List<String> buscarCidadesDoEstado(String estado) throws ClassNotFoundException, SQLException;
    String getViewBox(Cidade cidade1, Cidade cidade2) throws SQLException, ClassNotFoundException;
    Cidade buscarInfoCidade(String cidade, String estado) throws SQLException, ClassNotFoundException, ParseException;
}
