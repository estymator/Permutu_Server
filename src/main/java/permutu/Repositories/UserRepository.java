package permutu.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import permutu.Models.User;

import java.util.ArrayList;

public interface UserRepository extends JpaRepository<User, Integer> {
    Iterable<User> findByLogin(String login);
    Iterable<User> findByEmail(String email);
    User findUserByLogin(String login);
    User findByUserId(Integer id);
    ArrayList<User> findAll();


}
