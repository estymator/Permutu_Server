<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="permutu.Models.*" %>
<%@ page import="permutu.Helpers.StaticRooms" %>
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

<%Permutu testPermutu = new Permutu();%>

<% RoomCollection rooms = StaticRooms.getRooms();
    for (User u: rooms.getRoom("Room_1").getPlayers().getPlayers()) {
        out.print(u.getLogin());
    }%>



<section class="main-board rounded">
    <div class="container block-row red-block">

        <%
            for (Block b : testPermutu.getRedPile().getBlocks()) {
                out.print(b.genereteHTMLBlock());
            }
        %>
    </div>

    <div class="container block-row black-block">

        <%
            for (Block b : testPermutu.getBlackPile().getBlocks()) {
                out.print(b.genereteHTMLBlock());
            }
        %>
    </div>

    <div class="container block-row green-block">

        <%
            for (Block b : testPermutu.getGreenPile().getBlocks()) {
                out.print(b.genereteHTMLBlock());
            }
        %>
    </div>

    </section>

    <section class="player-one-blocks" >


    </section>

    <section class="player-two-blocks" >

    </section>

    <section class="player-three-blocks" >

    </section>

    <section class="player-four-blocks" >

    </section>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" 
crossorigin="anonymous"></script>
</body>

</html>