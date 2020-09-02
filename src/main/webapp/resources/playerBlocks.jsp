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
    boolean playerIsHost=false;
    Room room = rooms.getRoom((String )request.getSession().getAttribute("room"));
    System.out.println((String )request.getSession().getAttribute("room"));
    String playerLogin = (String) request.getSession().getAttribute("player");
    BlockCollection blocks = room.getPlayer(playerLogin).getBlocksInHand();
    Integer score = room.getPlayer(playerLogin).getPoints();
    String hostOutput = "<section class=\"player-blocks d-flex container border\" id=\"main-player\" >";
    hostOutput += "<div id=\"hostBlock\" class=\"flexed-row\"><div class=\"in-hand\" >";
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

    hostOutput += "</div></div><h1>SCORE: "+score+" </h1></br> <div id=\"timeHost\" class=\"flexed-row\" >  </div> </section>";


    out.print(hostOutput);



    int counter=0;
    for (Player p : room.getPlayers()){
        if(p!=room.getPlayer(playerLogin)){

            BlockCollection blocks1 = p.getBlocksInHand();
             String output = "<section class=\"player-blocks d-flex container border\" id=\"player-"+counter+"\" >";
             output += "<h1>"+p.getLogin()+"</h1><div class=\"flexed-row\"><div class=\"in-hand\" >";
            if(!blocks1.getBlocks().isEmpty()) {

                for (int i = 0; i < blocks1.size()-1; i++) {
                    if (blocks1.getBlock(i).thisSameSign(blocks1.getBlock(i + 1))) {
                        output += blocks1.getBlock(i).genereteHTMLDisabledBlock();
                    } else {
                        output += blocks1.getBlock(i).genereteHTMLDisabledBlock();
                        output += "</div>";
                        output += "<div class=\"in-hand in-hand-player"+counter+"\" >";
                    }

                }
                output += blocks1.getBlock(blocks1.size()-1).genereteHTMLDisabledBlock();

            }
            output += "</div></div><h1>SCORE: "+p.getPoints()+" </h1> </br> <div id=\"timePlayer"+counter+"\" class=\"flexed-row\" >  </div> </section>";
            out.print(output);

            playerIsHost=false;
        }else
        {
            playerIsHost=true;
        }
        // kod odpowiedzialny za wyświetlanie timera

        if(room.getOrder().getLast().equals(p.getId()) &&room.getPlayers().size()==room.getMaxNumberOfPlayers()) {
            %>
            <script>
                flag=0
                playerID=<%=p.getId()%>;
                playerIsHost=<%=playerIsHost%>;
                if(playerIsHost)
                {
                    divId="timeHost";
                }else
                {
                    divId="timePlayer"+<%=counter%>;
                }
                console.log("test, przypadek dla odliczania-"+divId);
                if(document.getElementById(divId)==null)
                {
                    console.log("nullllllllllllll");
                }
                for(i=0; i< timers.length;i++)
                {
                    console.log("sprawdzam case");
                    t=timers[i];
                    if(t.userId==playerID)
                    {
                        console.log("znaleziono case");
                        flag=1;
                        t.toggleTimer(5,false, divId);
                        break;
                    }
                }
                if(flag==0)
                {
                    console.log("nie znaleziono case");
                    timer = new Timer(playerID);
                    timer.toggleTimer(5,false, divId);
                    timers[timers.length]=timer;
                }
            </script>
            <%
        }else
        {
        %>
             <script>
                console.log("")
                flag=0
                playerID=<%=p.getId()%>;
                playerIsHost=<%=playerIsHost%>;
                if(playerIsHost)
                {
                    divId="timeHost";
                }else
                {
                    divId="timePlayer"+<%=counter%>;
                }
                console.log("test, przypadek dla pauzy - "+divId);

                if(document.getElementById(divId)==null)
                {
                    console.log("nullllllllllllll");
                }
                for(i=0; i< timers.length;i++)
                {
                    console.log("sprawdzam case");
                    t=timers[i];
                    if(t.userId==playerID)
                    {
                        console.log("znaleziono case");
                        flag=1;
                        t.toggleTimer(5,true, divId);
                        break;
                    }
                }
                if(flag==0)
                {
                    console.log("nie znaleziono case");
                    timer = new Timer(playerID);
                    timer.toggleTimer(5,true, divId);
                    timers[timers.length]=timer;
                }
            </script>
        <%
        }
        counter++;
    }
%>


