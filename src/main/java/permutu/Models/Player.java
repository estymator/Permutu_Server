package permutu.Models;

import java.util.ArrayList;

public class Player extends User {

    private BlockCollection blocksInHand;

    private String roomName;

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    Player(){
        super();
        this.blocksInHand = new BlockCollection(this.getLogin());
    }

    Player(User user){
        super();
        this.setUserId(user.getUserId());
        this.setLogin(user.getLogin());
        this.setEmail(user.getEmail());
        this.setUserRoleId(getUserRoleId());
        this.blocksInHand = new BlockCollection(user.getLogin());
    }

    private void setUserId(Integer userId) {
    }

    public BlockCollection getBlocksInHand() {
        return blocksInHand;
    }

    public void setBlocksInHand(BlockCollection blocksInHand) {
        this.blocksInHand = blocksInHand;
    }

}
