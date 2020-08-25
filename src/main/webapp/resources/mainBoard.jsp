<%@ page import="permutu.Models.Block" %>
<%@ page import="permutu.Models.User" %>
<%@ page import="permutu.Models.SingletonRooms" %>
<%@ page import="permutu.Models.Permutu" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<% SingletonRooms rooms = SingletonRooms.getInstance();
    String roomName = (String)  request.getSession().getAttribute("room");
    System.out.println(roomName + "mb");
    Permutu game = rooms.getRoom(roomName).getGame();
    %>
<div class="container block-row red-block d-flex flex-nowrap">

    <%
        for (Block b : game.getRedPile().getBlocks()) {
            out.print(b.genereteHTMLBlock());
        }
    %>
</div>

<div class="container block-row black-block d-flex flex-nowrap">

    <%
        for (Block b : game.getBlackPile().getBlocks()) {
            out.print(b.genereteHTMLBlock());
        }
    %>
</div>

<div class="container block-row green-block d-flex flex-nowrap">

    <%
        for (Block b : game.getGreenPile().getBlocks()) {
            out.print(b.genereteHTMLBlock());
        }
    %>
</div>
