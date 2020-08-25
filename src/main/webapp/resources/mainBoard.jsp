<%@ page import="permutu.Models.Block" %>
<%@ page import="permutu.Models.User" %>
<%@ page import="permutu.Models.SingletonRooms" %>
<%@ page import="permutu.Models.Permutu" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<% SingletonRooms rooms = SingletonRooms.getInstance();
    Permutu game = rooms.getRoom("Room_1").getGame();
    for (User u: rooms.getRoom("Room_1").getPlayers()) {
        out.print(u.getLogin());
    }%>
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
