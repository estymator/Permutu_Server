<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="permutu.Models.*" %>


<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Permutu - Play</title>
    <script src="/webjars/jquery/jquery.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="/resources/styles/style.css">
    <link rel="stylesheet" href="/resources/styles/pilestyle.css">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="https://kit.fontawesome.com/c43499c33d.js" crossorigin="anonymous"></script>

    <script src="/webjars/sockjs-client/sockjs.min.js"></script>
    <script src="/webjars/stomp-websocket/stomp.min.js"></script>
    <script src="../../resources/js/script.js"></script>
    <script src="../../resources/js/timer.js"></script>
    <script type="text/javascript">
        window.onload = function(){
            let button = document.getElementById('connect');
            button.click();
        }


    </script>
</head>

<script>
    //deklaracja tablicy timerów dla kazdego gracza
    timers=[];
</script>

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
            <a class="nav-item nav-link active" href="/history">Historia Twoich gier <span class="sr-only">(current)</span></a>
            <a class="nav-item nav-link" href="/settings">Ustawienia</a>
            <a class="nav-item nav-link" href="/samouczek">Samouczek</a>
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
<div class="container" id="control-panel">
    <form class="form-inline">
        <div class="form-group">
            <label for="connect">Panel Sterowania:</label>
            <button id="connect" class="d-none btn btn-warning m-2" type="submit">Zacznij</button>
            <button id="disconnect" class="btn btn-dark m-2" type="submit" disabled="disabled">Wyjdź z Gry</button>
            <button id="send" class="btn btn-success m-2" type="submit">Potwierdź ruch</button>
            <button id="reset" class="btn btn-danger m-2" type="submit" disabled="disabled">Reset Gry</br>(Tylko wtedy gdy w pokoju jesteś sam)</button>
            <button onclick="redirectToHistory()" class="btn btn-dark m-2" >Obejrzyj powtórkę</button>
        </div>
    </form>
</div>
<input type="hidden" id="roomName" value='<%=roomName%>'>


    <section id="main-board" class="main-board rounded">
    </section>

    <section class="players-block d-flex container" id="players-block">
    </section>

<div class="container" id="buttons-replay" style="display: none">
    <form class="form-inline">
        <div class="form-group">
            <label for="connect">Panel Sterowania:</label>
            <button class="btn btn-dark m-2" onclick="stepminus()">Poprzedni ruch</button>
            <button class="btn btn-success m-2" onclick="stepplus()">Następny ruch</button>
            <button class="btn btn-danger m-2" onclick="redirectH()">Zakończ</button>
        </div>
    </form>
</div>
<section style="display: flex; align-items: flex-end" id="history-section">
</section>

<script>
    function redirectH() {
        disconnect()
        window.location.replace("home");
    }
    function stepplus() {
        sendHistoryD("plus");
        $('#history-section').load('../resources/history.jsp');
    }
    function stepminus() {
        sendHistoryD("minus");
        $('#history-section').load('../resources/history.jsp');
    }
</script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" 
crossorigin="anonymous"></script>
</body>

</html>