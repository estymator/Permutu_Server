package unitTests;


import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import permutu.Models.User;
import permutu.Repositories.UserRepository;

@RunWith(SpringRunner.class)
public class UserTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByLoginTest()
    {
        User u = new User();
        u.setLogin("Andrzej");
        entityManager.persist(u);
        entityManager.flush();

        User found = userRepository.findUserByLogin(u.getLogin());

        assertThat(found.getLogin()).isEqualTo(u.getLogin());

    }
}
