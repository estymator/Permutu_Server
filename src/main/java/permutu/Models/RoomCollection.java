package permutu.Models;

import java.util.ArrayList;

public class RoomCollection {

    private ArrayList<Room> rooms;

    public RoomCollection() {
        this.rooms = new ArrayList<>();
        rooms.add(new Room("Room_1", new Permutu()));
        rooms.add(new Room("Room_2", new Permutu()));
        rooms.add(new Room("Room_4", new Permutu()));
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




}
