package com.ifpb.controller;

import com.ifpb.dao.CidadeDaoImpl;
import com.ifpb.model.Cidade;
import com.vividsolutions.jts.io.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/action")
public class FrontController extends HttpServlet {

    public static String estadoAnterior1 = "";
    public static String estadoAnterior2 = "";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CidadeDaoImpl dao = new CidadeDaoImpl();

        try {
            List<String> estados = dao.buscarEstado();

            request.setAttribute("estados", estados);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CidadeDaoImpl dao = new CidadeDaoImpl();

        String estado1 = request.getParameter("estado1");
        String estado2 = request.getParameter("estado2");

        String cidade1 = request.getParameter("cidade1");
        String cidade2 = request.getParameter("cidade2");

        request.setAttribute("estado1",estado1);
        request.setAttribute("estado2",estado2);

        Cidade primeiraCidade = null;
        Cidade segundaCidade = null;

        if (!estado1.equals("NENHUM")){
            try {

                List<String> cidades1 = dao.buscarCidadesDoEstado(estado1);
                request.setAttribute("cidadesNome1",cidades1);

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            if (!cidade1.equals("NENHUMA") && estadoAnterior1.equals(estado1)){
                try {

                    primeiraCidade = dao.buscarInfoCidade(cidade1,estado1);
                    request.setAttribute("primeiraCidade",cidade1);

                }catch (ClassNotFoundException | SQLException | ParseException e) {
                    e.printStackTrace();
                }

                request.setAttribute("cidade1",cidade1);
            }

            estadoAnterior1 = estado1;
        }
        if (!estado2.equals("NENHUM")){

            try {

                List<String> cidades2 = dao.buscarCidadesDoEstado(estado2);
                request.setAttribute("cidadesNome2", cidades2);

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            if (!cidade2.equals("NENHUMA") && estadoAnterior2.equals(estado2)){

                try {

                    segundaCidade = dao.buscarInfoCidade(cidade2,estado2);
                    request.setAttribute("segundaCidade",cidade2);

                } catch (SQLException | ClassNotFoundException | ParseException e) {
                    e.printStackTrace();
                }
                request.setAttribute("cidade2",cidade2);
            }
            estadoAnterior2 = estado2;
        }

        if( cidade1!= null && cidade2!= null ) {
            Float distancia = (float) (primeiraCidade.getGeom().getCentroid().distance(segundaCidade.getGeom().getCentroid()) * (40075/360));
            try {
                request.setAttribute("viewBox", dao.getViewBox(primeiraCidade, segundaCidade));
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            request.setAttribute("distanciaaproximada", distancia);
        }

        try {

            List<String> estados = dao.buscarEstado();
            request.setAttribute("estados", estados);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
