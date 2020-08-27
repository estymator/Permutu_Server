<%@ page import="java.util.ArrayList" %>
<%@ page import="permutu.Models.*" %><%--
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
    if(!blocks.getBlocks().isEmpty()) {
        String output = "<section class=\"player-blocks d-flex container\" id=\"main-player\" >";
        output += "<div class=\"in-hand\" >";
        for (int i = 0; i < blocks.size()-1; i++) {
            if (blocks.getBlock(i).thisSameSign(blocks.getBlock(i + 1))) {
                output += blocks.getBlock(i).genereteHTMLBlock();
            } else {
                output += blocks.getBlock(i).genereteHTMLBlock();
                output += "</div>";
                output += "<div class=\"in-hand\" >";
            }
            System.out.println("OUTPUT "+i+" "+output);
        }
        output += blocks.getBlock(blocks.size()-1).genereteHTMLBlock();
        output += "</div></section>";

        System.out.println(output);
        out.print(output);
    }
    int counter=0;
    for (Player p : room.getPlayers()){
        if(p!=room.getPlayer(playerLogin)){
            BlockCollection blocks1 = p.getBlocksInHand();
            if(!blocks1.getBlocks().isEmpty()) {
                String output = "<section class=\"player-blocks d-flex container\" id=\"player-"+counter+"\" >";
                output += "<div class=\"in-hand-player"+counter+"\" >";
                for (int i = 0; i < blocks1.size()-1; i++) {
                    if (blocks1.getBlock(i).thisSameSign(blocks1.getBlock(i + 1))) {
                        output += blocks1.getBlock(i).genereteHTMLBlock();
                    } else {
                        output += blocks1.getBlock(i).genereteHTMLBlock();
                        output += "</div>";
                        output += "<div class=\"in-hand-player"+counter+"\" >";
                    }
                    System.out.println("OUTPUT "+i+" "+output);
                }
                output += blocks1.getBlock(blocks1.size()-1).genereteHTMLBlock();
                output += "</div></section>";

                System.out.println(output);
                out.print(output);
            }
        }
        counter++;
    }
%>

<%--
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
--%>