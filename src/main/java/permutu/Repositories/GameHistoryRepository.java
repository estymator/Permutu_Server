package permutu.Repositories;

import org.springframework.data.repository.CrudRepository;
import permutu.Models.GameHistory;
import permutu.Models.User;

import java.util.ArrayList;

public interface GameHistoryRepository extends CrudRepository<GameHistory, Integer> {
    Iterable<GameHistory> findAll();

    ArrayList<GameHistory> findByUserId(Integer userId);
    ArrayList<GameHistory> findByGameId(Integer gameId);
}
