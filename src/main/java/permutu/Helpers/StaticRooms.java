package permutu.Helpers;

import permutu.Models.RoomCollection;

public class StaticRooms {
    private static RoomCollection rooms = new RoomCollection();

    public static RoomCollection getRooms() {
        return rooms;
    }

    public static void setRooms(RoomCollection rooms) {
        StaticRooms.rooms = rooms;
    }
}
