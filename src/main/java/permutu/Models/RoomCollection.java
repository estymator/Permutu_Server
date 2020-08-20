package permutu.Models;

import java.util.ArrayList;

public class RoomCollection {

    private ArrayList<Room> rooms;

    public RoomCollection() {
        this.rooms = new ArrayList<>();
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



}
