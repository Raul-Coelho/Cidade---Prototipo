package com.ifpb.dao;

import com.ifpb.model.Cidade;

import java.sql.SQLException;
import java.util.List;

public interface CidadeDAO {

    List<String> buscarEstado() throws SQLException, ClassNotFoundException;
    List<String> buscarCidadesDoEstado(String estado) throws ClassNotFoundException, SQLException;
    String getViewBox(Cidade cidade1, Cidade cidade2) throws SQLException, ClassNotFoundException;
}
