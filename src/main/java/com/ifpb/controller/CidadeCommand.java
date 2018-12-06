package com.ifpb.controller;

import com.ifpb.dao.CidadeDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CidadeCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CidadeDaoImpl dao = new CidadeDaoImpl();

        try {
            List<String> estados = dao.buscarEstado();
            request.setAttribute("estados", estados );
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("saida.jsp").forward(request,response);
    }
}
