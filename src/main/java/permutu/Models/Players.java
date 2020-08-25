package permutu.Models;

import java.util.ArrayList;

public class Players extends User {
    /**
     * List of players.
     */
    protected ArrayList<Player> players;
    /**
     * Create list of players
     * @param name new player
     */
    public Players(String name) {
        this.players = new ArrayList<Player>();
    }

    public Players() {
        this.players = new ArrayList<Player>();
    }
    /**
     * Add new player  to list
     * @param player who will be add to list
     */
    public void addPlayer(Player player) {
        players.add(player);
    }

    public void addPlayer(User user){
        players.add(new Player(user));
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

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}
