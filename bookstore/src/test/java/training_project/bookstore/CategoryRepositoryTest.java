package training_project.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import training_project.bookstore.domain.Category;
import training_project.bookstore.domain.CategoryRepository;

@SpringBootTest(classes = BookstoreApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository repository;

    @Test
    @Order(1)
    public void findCategory () {
        List<Category> categories = repository.findByName("Kaunokirjallisuus");
        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getName().equalsIgnoreCase("kaunokirjallisuus"));
    }

    @Test
    @Order(2)
    public void createCategory(){
        Category category = new Category("kauhu");
        repository.save(category);
        assertThat(category.getCategoryid()).isNotNull();
    }

    @Test
    @Order(3)
    public void deleteCategory() {
        List<Category> categories = repository.findByName("Kaunokirjallisuus");
        Category category = categories.get(0);
        repository.delete(category);
        assertThat(repository.findByName("Kaunokirjallisuus")).hasSize(0);
    }
}
