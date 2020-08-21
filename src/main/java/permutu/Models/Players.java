package permutu.Models;

import java.util.ArrayList;

public class Players extends User {
    /**
     * List of players.
     */
    protected ArrayList<User> players;
    /**
     * Create list of players
     * @param name new player
     */
    public Players(String name) {
        this.players = new ArrayList<User>();
    }

    public Players() {
        this.players = new ArrayList<User>();
    }
    /**
     * Add new player  to list
     * @param player who will be add to list
     */
    public void addPlayer(User player) {
        players.add(player);
    }
    /**
     * Getter returned player which index is <code>i</code>
     * @param i - index of player in list
     * @return player from list
     */
    public User getPlayer(int i) {
        return players.get(i);
    }
    /**
     *
     * @return number of players
     */
    public int size() {
        return players.size();
    }

    public boolean equals(User player) {
        return this.getLogin().equals(player.getLogin());
    }

    public int getIndex(User player) {
        for(int i = 0; i < size(); ++i) {
            if(player.equals(players.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<User> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<User> players) {
        this.players = players;
    }
}
