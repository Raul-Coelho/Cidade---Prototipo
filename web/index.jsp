<%--
  Created by IntelliJ IDEA.
  User: Raul Coelho
  Date: 06/12/2018
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="style.css"/>
</head>
<body>
    <div>
        <form action="formInicio" method="post">
            <div class="cidades">
                <h2>Cidade 1</h2>
                <label>Estado
                    <select name="estado1">
                        <option>NENHUM</option>
                        <c:forEach var="estado" items="${estados}">
                            <option ${estado1==estado?'selected':''}>${estado}</option>
                        </c:forEach>
                    </select>
                </label><br><br>
                <label>Cidade
                    <select name="cidade1">
                        <option>NENHUMA</option>
                        <c:forEach var="cidade" items="${cidades1}">
                            <option ${cidade1 == cidade?'selected':''}>${cidade}</option>
                        </c:forEach>
                    </select>
                </label><br><br>
                <label class="lab1">População: </label><br>
                <label class="lab2">Densidade Demografica: </label><br>
                <label class="lab3">Area: </label><br>
                <label class="lab4">Perimetro: </label><br>
            </div>

            <div class="cidades">
                <h2>Cidade 2</h2>
                <label>Estado
                    <select name="estado2">
                        <option>NENHUM</option>
                        <c:forEach var="estado" items="${estados}">
                            <option ${estado2 == estado?'selected':''}>${estado}</option>
                        </c:forEach>
                    </select>
                </label><br><br>
                <label>Cidade
                    <select name="cidade2">
                        <option>NENHUMA</option>
                        <c:forEach var="cidade" items="${cidades1}">
                            <option ${cidade2 == cidade?'selected':''}>${cidade}</option>
                        </c:forEach>
                    </select>
                </label><br><br>
                <label class="lab1">População: </label><br>
                <label class="lab2">Densidade Demografica: </label><br>
                <label class="lab3">Area: </label><br>
                <label class="lab4">Perimetro: </label><br>
            </div>

        </form>
    </div>
</body>
</html>
