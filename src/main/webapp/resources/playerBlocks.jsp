<%@ page import="permutu.Models.Block" %>
<%@ page import="permutu.Models.SingletonRooms" %>
<%@ page import="permutu.Models.BlockCollection" %>
<%@ page import="permutu.Models.Room" %><%--
  Created by IntelliJ IDEA.
  User: Karolina
  Date: 22.08.2020
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% SingletonRooms rooms = SingletonRooms.getInstance();%>
<%
    Room room = rooms.getRoom((String )request.getSession().getAttribute("room"));
    System.out.println((String )request.getSession().getAttribute("room"));
    String playerLogin = (String) request.getSession().getAttribute("player");
    BlockCollection blocks = room.getPlayer(playerLogin).getBlocksInHand();
    if(!blocks.getBlocks().isEmpty()){
        for (Block b : blocks.getBlocks()) {
            out.print(b.genereteHTMLBlock());
        }
    }

%>