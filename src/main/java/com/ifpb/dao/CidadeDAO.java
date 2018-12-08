package com.ifpb.dao;

import java.sql.SQLException;
import java.util.List;

public interface CidadeDAO {

    List<String> buscarEstado() throws SQLException, ClassNotFoundException;
    List<String> buscarCidadeDoEstado(String estado);
}
