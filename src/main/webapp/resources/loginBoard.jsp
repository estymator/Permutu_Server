<%@ page import="java.util.ArrayList" %>
<%@ page import="permutu.Models.*" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
Gracze w pokoju :
<%
    SingletonRooms rooms = SingletonRooms.getInstance();
    String roomName = (String)  request.getSession().getAttribute("room");
    System.out.println("game.jsp - "+roomName);

    Room room = rooms.getRoom(roomName);
    for (User u: room.getPlayers()) {
        out.print(" - "+u.getLogin());
    }
    out.println(""); //next line
    if(room.getPlayers().size()==room.getMaxNumberOfPlayers())
    {
    %>
        <script>     $("#send").prop("disabled", false); </script>
    <%
    }else
    {
        out.println("Poczekaj aż pokój się zapełni");
    }
    %>