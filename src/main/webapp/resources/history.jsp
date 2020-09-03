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
    for (String i : history){
        out.print("LOADING");
        out.print(i);
    }

%>
