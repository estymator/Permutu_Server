package permutu.Models;

import java.util.ArrayList;
import java.util.Arrays;

public class Player extends User {

    private BlockCollection blocksInHand;

    private  Integer id;

    private String roomName;

    private Integer points = 0;

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
        this.id = user.getUserId();
        this.setLogin(user.getLogin());
        this.setEmail(user.getEmail());
        this.setUserRoleId(getUserRoleId());
        this.blocksInHand = new BlockCollection(user.getLogin());
    }

    private void setUserId(Integer userId) {
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public BlockCollection getBlocksInHand() {
        return blocksInHand;
    }

    public void setBlocksInHand(BlockCollection blocksInHand) {
        this.blocksInHand = blocksInHand;
    }

    public void countPoints(){
        points = 0;

        int[] signs = new int[26];
        Arrays.fill(signs,0);

        for(Block b: blocksInHand.getBlocks()){
            signs[b.getSign()]++;
        }

        for(int i : signs){
            if(i == 2) points += 1;
            else if(i == 3) points += 3;
        }

    }

    void resetPlayer(){
        this.blocksInHand = new BlockCollection(this.getLogin());
        points=0;
    }

    public Integer getId() {
        return id;
    }
}
