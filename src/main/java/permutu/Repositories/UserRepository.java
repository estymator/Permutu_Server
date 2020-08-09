package permutu.Repositories;

import org.springframework.data.repository.CrudRepository;
import permutu.Models.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    Iterable<User> findByLogin(String login);
}
