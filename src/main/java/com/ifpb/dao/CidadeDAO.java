package com.ifpb.dao;

import com.ifpb.model.Cidade;
import org.apache.catalina.LifecycleState;

import java.sql.SQLException;
import java.util.List;

public interface CidadeDAO {

    List<String> buscarEstado() throws SQLException, ClassNotFoundException;
}
