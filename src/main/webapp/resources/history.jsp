<%@ page import="permutu.Models.SingletonRooms" %>
<%@ page import="permutu.Models.Room" %>
<%@ page import="permutu.Models.Permutu" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    SingletonRooms rooms = SingletonRooms.getInstance();
    String roomName = (String)  request.getSession().getAttribute("room");
    Room room = rooms.getRoom(roomName);
    Permutu game = room.getGame();
    ArrayList<String> history = game.getHistory();
    int i = 0;
    if (history != null && !history.isEmpty()) {
        i=history.size()-1;
    }
    out.print("<section style=\"display: flex; flex-direction: column; text-align: center;\">");
    out.print("<h1>RUCH "+game.getStep()+" Z  "+i+"</h1>");
    out.print(history.get(game.getStep()));
    out.print("</section>");
%>
