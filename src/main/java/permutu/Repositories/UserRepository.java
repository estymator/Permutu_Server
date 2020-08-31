package permutu.Repositories;

import org.springframework.data.repository.CrudRepository;
import permutu.Models.User;

import java.util.ArrayList;

public interface UserRepository extends CrudRepository<User, Integer> {
    Iterable<User> findByLogin(String login);
    Iterable<User> findByEmail(String email);
    User findUserByLogin(String login);
    ArrayList<User> findAll();
}
