<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 01.09.2020
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Settings</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="../../resources/js/script.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Permutu        Witaj ${pageContext.request.userPrincipal.name}</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-item nav-link" href="/home">Home <span class="sr-only">(current)</span></a>
            <a class="nav-item nav-link" href="/score">Wyniki</a>
            <a class="nav-item nav-link" href="/history">Historia Twoich gier</a>
            <a class="nav-item nav-link active" href="/settings">Ustawienia<span class="sr-only">(current)</span></a>
            <a class="nav-item nav-link" href="/logout">Wyloguj się</a>
        </div>
    </div>
</nav>

<section class="forms">
    <div class="container">
    <form action="/change" method="post" >
        <div class="form-group col-md-6">
            <label for="inputLogin">Login</label>
            <input type="text" class="form-control" id="inputLogin" placeholder=${pageContext.request.userPrincipal.name}>
        </div>

        <div class="form-group col-md-6">
            <label for="inputPassword4">Hasło</label>
            <input type="password" class="form-control" id="inputPassword4">
        </div>

        <div class="form-group col-md-6">
            <label for="inputPassword24">Potwierdź hasło</label>
            <input type="password" class="form-control" id="inputPassword24">
        </div>
        <div class="form-group col-md-6">
            <label for="inputEmail4">Email</label>
            <input type="email" class="form-control" id="inputEmail4">
        </div>
        <input type="hidden" id="currentLogin" value="${pageContext.request.userPrincipal.name}">

        <button type="submit" id="change" class="btn btn-primary float-left">Zapisz</button>
    </form>
    </div>
</section>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</body>
</html>
