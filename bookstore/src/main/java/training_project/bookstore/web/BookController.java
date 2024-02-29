package training_project.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import training_project.bookstore.domain.Book;
import training_project.bookstore.domain.BookRepository;
import training_project.bookstore.domain.CategoryRepository;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {
    @Autowired
    private BookRepository repository;

    @Autowired
    private CategoryRepository cRepository;

    @GetMapping("index")
    public String showMainPage () {
        return "index";
    }

    @GetMapping("/booklist")
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/addbook")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", cRepository.findAll());
        return "addbook";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/savebook")
    public String saveBook(@ModelAttribute("book") Book book) {
        repository.save(book);
        return "redirect:/booklist";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/deletebook/{id}")
    public String deleteBook(@PathVariable("id") Long id, Model model) {
        repository.deleteById(id);
        return "redirect:/booklist";
    }
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/editbook/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", repository.findById(id));
        model.addAttribute("categories", cRepository.findAll());
        return "editbook";
    }
    
    
    
    
    
}
