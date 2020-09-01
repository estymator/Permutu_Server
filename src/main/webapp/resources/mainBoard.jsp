<%@ page import="permutu.Models.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    SingletonRooms rooms = SingletonRooms.getInstance();
    String roomName = (String)  request.getSession().getAttribute("room");
    Room room = rooms.getRoom(roomName);
    Permutu game = room.getGame();
%>

<%
    String playerLogin = (String) request.getSession().getAttribute("player");
    if(room.getPlayer(playerLogin)!=null && room.getOrder().getLast()!=null){
        Integer playerID = room.getPlayer(playerLogin).getId();
        if(room.getOrder().getLast().equals(playerID)) {
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

<% } else { %>
<div class="container block-row red-block d-flex flex-nowrap">

    <%
        for (Block b : game.getRedPile().getBlocks()) {
            out.print(b.genereteHTMLDisabledBlock());
        }
    %>
</div>

<div class="container block-row black-block d-flex flex-nowrap">

    <%
        for (Block b : game.getBlackPile().getBlocks()) {
            out.print(b.genereteHTMLDisabledBlock());
        }
    %>
</div>

<div class="container block-row green-block d-flex flex-nowrap">

    <%
        for (Block b : game.getGreenPile().getBlocks()) {
            out.print(b.genereteHTMLDisabledBlock());
        }
    %>
</div>
<%  }
   }
%>