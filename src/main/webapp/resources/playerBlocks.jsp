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
    int counter1 = 1;
    int score = 0;
    if(!blocks.getBlocks().isEmpty()) {
        String output = "<section class=\"player-blocks d-flex container\" id=\"main-player\" >";
        output += "<div class=\"in-hand\" >";
        for (int i = 0; i < blocks.size()-1; i++) {
            if (blocks.getBlock(i).thisSameSign(blocks.getBlock(i + 1))) {
                output += blocks.getBlock(i).genereteHTMLBlock();
                counter1++;
            } else {
                if (counter1==1 || counter1==2){
                    score++;
                } else {
                    score+=3;
                }
                counter1=1;
                output += blocks.getBlock(i).genereteHTMLBlock();
                output += "</div>";
                output += "<div class=\"in-hand\" >";
            }
        }
        if (counter1==1 || counter1==2){
            score++;
        } else {
            score+=3;
        }
        output += blocks.getBlock(blocks.size()-1).genereteHTMLBlock();
        output += "<h1>SCORE: "+score+" </h1>";
        output += "</div></section>";

        System.out.println(output);
        out.print(output);
    }
    int counter=0;
    for (Player p : room.getPlayers()){
        int counter2 = 1;
        int score1 = 0;
        if(p!=room.getPlayer(playerLogin)){
            BlockCollection blocks1 = p.getBlocksInHand();
            if(!blocks1.getBlocks().isEmpty()) {
                String output = "<section class=\"player-blocks d-flex container\" id=\"player-"+counter+"\" >";
                output += "<div class=\"in-hand-player"+counter+"\" >";
                output += "<h1>PLAYER"+counter+"</h1>";
                for (int i = 0; i < blocks1.size()-1; i++) {
                    if (blocks1.getBlock(i).thisSameSign(blocks1.getBlock(i + 1))) {
                        output += blocks1.getBlock(i).genereteHTMLBlock();
                        counter2++;
                    } else {
                        if (counter2==1 || counter2==2){
                            score1++;
                        } else {
                            score1+=3;
                        }
                        counter2=1;
                        output += blocks1.getBlock(i).genereteHTMLBlock();
                        output += "</div>";
                        output += "<div class=\"in-hand-player"+counter+"\" >";
                    }
                    System.out.println("OUTPUT "+i+" "+output);
                }
                if (counter2==1 || counter2==2){
                    score1++;
                } else {
                    score1+=3;
                }
                output += blocks1.getBlock(blocks1.size()-1).genereteHTMLBlock();
                output += "<br><h1>SCORE: "+score1+" </h1>";
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