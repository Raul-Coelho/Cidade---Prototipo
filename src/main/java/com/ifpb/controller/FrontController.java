package com.ifpb.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/action")
public class FrontController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {



    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request,response);
    }
}
