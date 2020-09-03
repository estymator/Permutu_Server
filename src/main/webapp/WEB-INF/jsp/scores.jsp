<%@ page import="org.springframework.beans.factory.annotation.Autowired" %>
<%@ page import="permutu.Repositories.UserRepository" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="permutu.Models.User" %>
<%@ page import="permutu.Controllers.HomeController" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 30.08.2020
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Scores</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" href="/resources/styles/homePagestyle.css">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-dark">
    <a class="navbar-brand text-danger" href="#">Permutu        Witaj ${pageContext.request.userPrincipal.name}</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-item nav-link text-danger" href="/home">Home <span class="sr-only">(current)</span></a>
            <a class="nav-item nav-link font-weight-bold text-danger" href="/score">Wyniki <span class="sr-only">(current)</span></a>
            <a class="nav-item nav-link text-danger" href="/history">Historia Twoich gier</a>
            <a class="nav-item nav-link text-danger" href="/settings">Ustawienia</a>
            <a class="nav-item nav-link text-danger" href="/samouczek">Samouczek</a>
            <a class="nav-item nav-link text-danger" href="/logout">Wyloguj się</a>
        </div>
    </div>
</nav>

<%
    ArrayList<User> users = (ArrayList<User>) request.getSession().getAttribute("users");
%>
<div class="container">
    <h1 class="text-center">Tablica wyników</h1>
    <table class="table table-sm">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Nazwa użytkownika</th>
            <th scope="col">Rozegrane gry</th>
            <th scope="col">Wygrane</th>
            <th scope="col">Współczynnik wygranych gier</th>
        </tr>
        </thead>
        <tbody>
        <%
            int counter = 1;
            for(User u : users){
                out.print(u.genereteHTMLtrForUser(counter));
                counter++;
            }
        %>
        </tbody>
    </table>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</body>
</html>