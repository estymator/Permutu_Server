<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="permutu.Models.*" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Permutu - Play</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="/resources/styles/style.css">

    <script src="https://kit.fontawesome.com/c43499c33d.js" crossorigin="anonymous"></script>
    <script src="../../resources/js/script.js"></script>
</head>
<body class="bg-light">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Permutu        Witaj ${pageContext.request.userPrincipal.name}</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-item nav-link active" href="/home">Home <span class="sr-only">(current)</span></a>
            <a class="nav-item nav-link" href="/score">Wyniki</a>
            <a class="nav-item nav-link" href="/history">Historia Twoich gier</a>
            <a class="nav-item nav-link" href="/settings">Ustawienia</a>
            <a class="nav-item nav-link" href="/logout">Wyloguj się</a>
        </div>
    </div>
</nav>

<div class="container">
    <% SingletonRooms rooms = (SingletonRooms) request.getAttribute("rooms");%>


        <table class="table table-sm">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Room Name</th>
                <th scope="col">Number of Players in Room</th>
                <th scope="col">Max Number of Players in room</th>
                <th scope="col">Time for One Player</th>
                <th scope="col">Number of Symbols</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>

            <%
            for(Room r : rooms.getRooms()){
            %>
            <form action="/join" method="get">
            <%
                out.print(r.genereteHTMLtrForRoom());
            %>
             </form>
            <%
            }
            %>
            </tbody>
        </table>


</div>

<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>
</body>

</html>