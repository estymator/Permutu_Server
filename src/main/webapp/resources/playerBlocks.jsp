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
    Integer score = room.getPlayer(playerLogin).getPoints();
    String hostOutput = "<section class=\"player-blocks d-flex container border\" id=\"main-player\" >";
    hostOutput += "<div class=\"flexed-row\"><div class=\"in-hand\" >";
    if(!blocks.getBlocks().isEmpty()) {

        for (int i = 0; i < blocks.size()-1; i++) {
            if (blocks.getBlock(i).thisSameSign(blocks.getBlock(i + 1))) {
                hostOutput += blocks.getBlock(i).genereteHTMLDisabledBlock();
            } else {
                hostOutput += blocks.getBlock(i).genereteHTMLDisabledBlock();
                hostOutput += "</div>";
                hostOutput += "<div class=\"in-hand\" >";
            }
        }
        hostOutput += blocks.getBlock(blocks.size()-1).genereteHTMLDisabledBlock();
    }

    hostOutput += "</div></div><h1>SCORE: "+score+" </h1></section>";

    System.out.println(hostOutput);
    out.print(hostOutput);
    int counter=0;
    for (Player p : room.getPlayers()){
        if(p!=room.getPlayer(playerLogin)){
            BlockCollection blocks1 = p.getBlocksInHand();
            if(!blocks1.getBlocks().isEmpty()) {
                String output = "<section class=\"player-blocks d-flex container border\" id=\"player-"+counter+"\" >";
                output += "<h1>"+p.getLogin()+"</h1><div class=\"flexed-row\"><div class=\"in-hand\" >";

                for (int i = 0; i < blocks1.size()-1; i++) {
                    if (blocks1.getBlock(i).thisSameSign(blocks1.getBlock(i + 1))) {
                        output += blocks1.getBlock(i).genereteHTMLDisabledBlock();
                    } else {
                        output += blocks1.getBlock(i).genereteHTMLDisabledBlock();
                        output += "</div>";
                        output += "<div class=\"in-hand in-hand-player"+counter+"\" >";
                    }
                    System.out.println("OUTPUT "+i+" "+output);
                }
                output += blocks1.getBlock(blocks1.size()-1).genereteHTMLDisabledBlock();
                output += "</div></div><h1>SCORE: "+p.getPoints()+" </h1></section>";

                System.out.println(output);
                out.print(output);
            }
        }
        counter++;
    }
%>


