package permutu.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import permutu.Models.GameModel;



import java.util.Optional;

public interface GameModelRepository extends JpaRepository<GameModel,Integer> {
    Optional<GameModel> findById(Integer id);

    GameModel findTopByOrderByIdDesc();
}
