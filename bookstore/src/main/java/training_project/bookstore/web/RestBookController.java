package training_project.bookstore.web;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import training_project.bookstore.domain.Book;
import training_project.bookstore.domain.BookRepository;
import training_project.bookstore.domain.CategoryRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class RestBookController {

    @Autowired
    private BookRepository repository;

    @Autowired
    private CategoryRepository cRepository;

    @GetMapping("/books")
    public Iterable<Book> getBooks() {
        return repository.findAll();
    }

    @GetMapping("/book/{id}")
    public Optional<Book> getBook(@PathVariable("id") Long id) {
        return repository.findById(id);
    }

    @PostMapping("/newbook")
    Book newbook (@RequestBody Book newbook) {
        return repository.save(newbook);
    }

    @PutMapping("/book/{id}")
    Book editbook (@PathVariable Long id, @RequestBody Book editbook) {
        editbook.setId(id);
        return repository.save(editbook);
    }

    @DeleteMapping("/removebook/{id}")
    public void deletebook(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
