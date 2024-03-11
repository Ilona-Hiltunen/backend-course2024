package training_project.bookstore;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import training_project.bookstore.domain.AppUser;
import training_project.bookstore.domain.AppUserRepository;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(classes = BookstoreApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AppUserTest {

    @Autowired
    private AppUserRepository repository;

    @Test
    @Order(1)
    public void findAppUser() {
        AppUser appuser = repository.findByUsername("user");
        assertThat(appuser.getUsername().equalsIgnoreCase("user"));
    }

    @Test 
    @Order(2)
    public void createAppUser() {
        AppUser appuser = new AppUser("user1", "$2a$10$mfyLs3laQX00O0oyW//jHuB5hHv0GvKwDYBZpnVYHxHK.NfsfI2XC", "moikka@123.com", "USER");
        repository.save(appuser);
        assertThat(appuser.getId()).isNotNull();
    }

   @Test
   @Order(3)
    public void deleteAppUser() {
        AppUser appuser = repository.findByUsername("user1");
        repository.delete(appuser);
        assertThat(repository.findByUsername("user1")).isNull();
    } 

}