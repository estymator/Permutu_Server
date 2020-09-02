package permutu.Models;

import org.springframework.beans.factory.annotation.Autowired;
import permutu.Repositories.GameHistoryRepository;



import java.util.ArrayList;

public class SingletonRooms {

    private ArrayList<Room> rooms;



    private SingletonRooms(){
        if(Holder.INSTANCE != null){
            throw new IllegalStateException("Rooms already constructed");
        }
        else{
            this.rooms = new ArrayList<>();

            rooms.add(new Room("Room_1", new Permutu()));

            rooms.add(new Room("Room_2", new Permutu()));

            rooms.add(new Room("Room_4", new Permutu()));

        }
    }

    public static SingletonRooms getInstance(){
        return Holder.INSTANCE;
    }
    private static class Holder{
        private static final SingletonRooms INSTANCE = new SingletonRooms();
    }


    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    public int size(){
        return rooms.size();
    }

    public boolean isEmpty(){
        return rooms.isEmpty();
    }

    public Room getRoom(String roomName){
        for(Room r : rooms){
            if(r.getRoomName().equals(roomName)) return r;
        }
        return null;
    }

    public Room getPlayerRoom(String playerName){
        for(Room r : rooms){
            if(r.isPlayer(playerName)) return r;
        }
        return null;
    }




}
