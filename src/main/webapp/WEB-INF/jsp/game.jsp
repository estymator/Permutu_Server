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
    <link rel="stylesheet" href="/resources/styles/pilestyle.css">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="https://kit.fontawesome.com/c43499c33d.js" crossorigin="anonymous"></script>
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/sockjs-client/sockjs.min.js"></script>
    <script src="/webjars/stomp-websocket/stomp.min.js"></script>
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
            <a class="nav-item nav-link" href="/home">Home</a>
            <a class="nav-item nav-link" href="/score">Wyniki</a>
            <a class="nav-item nav-link" href="/settings">Ustawienia</a>
            <a class="nav-item nav-link" href="/logout">Wyloguj się</a>
        </div>
    </div>
</nav>



<% SingletonRooms rooms = SingletonRooms.getInstance();
    String roomName = (String)  request.getSession().getAttribute("room");
    System.out.println("game.jsp - "+roomName);

    Room room = rooms.getRoom(roomName);
    for (User u: room.getPlayers()) {
        out.print("-"+u.getLogin());
    }%>

<div id="login" class="hidden">
    ${pageContext.request.userPrincipal.name}
</div>

<form class="form-inline">
    <div class="form-group">
        <label for="connect">WebSocket connection:</label>
        <button id="connect" class="btn btn-default" type="submit">Connect</button>
        <button id="disconnect" class="btn btn-default" type="submit" disabled="disabled">Disconnect</button>
        <button id="send" class="btn btn-default" type="submit">Send</button>
        <button id="reset" class="btn btn-default" type="submit" disabled="disabled">Reset Game</br>(Only when you are alone in the room)</button>
    </div>
</form>

<input type="hidden" id="roomName" value='<%=roomName%>'>


    <section id="main-board" class="main-board rounded">
    </section>

    <section class="players-block d-flex container" id="players-block">
    </section>



<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" 
crossorigin="anonymous"></script>
</body>

</html>