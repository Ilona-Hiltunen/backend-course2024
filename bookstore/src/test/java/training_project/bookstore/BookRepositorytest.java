package training_project.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import training_project.bookstore.domain.Book;
import training_project.bookstore.domain.BookRepository;
import training_project.bookstore.domain.Category;
import training_project.bookstore.domain.CategoryRepository;

@SpringBootTest(classes = BookstoreApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositorytest {

    @Autowired
    private BookRepository repository;

    @Autowired 
    private CategoryRepository cRepository;

    @Test
    public void findBook() {
        List<Book> books = repository.findByTitle("Humiseva harju");
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle().equalsIgnoreCase("humiseva harju"));
    }
    
    @Test
    public void createBook(){
        Category category = new Category("Kauhu");
        cRepository.save(category);
        Book book = new Book("kauhukirja", "erkki esimerkki", "12356", 2006, 24.95, category);
        repository.save(book);
        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void deleteBook(){
        List<Book> books = repository.findByTitle("Humiseva harju");
        Book book = books.get(0);
        repository.delete(book);
        assertThat(repository.findByTitle("Humiseva harju")).hasSize(0);
    }
    
}