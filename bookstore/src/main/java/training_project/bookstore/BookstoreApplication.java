package training_project.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import training_project.bookstore.domain.Book;
import training_project.bookstore.domain.BookRepository;
import training_project.bookstore.domain.Category;
import training_project.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository cRepository) {
		//Mallia kirjoihin otettu Suomalaisen kirjakaupan sivustolta https://www.suomalainen.com/
		return (args) -> {
			System.out.println("Save books");

			cRepository.save(new Category("Harrastekirjat"));
			cRepository.save(new Category("Scifi"));
			cRepository.save(new Category("Kaunokirjallisuus"));

			repository.save(new Book(0, "Muumit Juhlakirja", "Paula Nivukoski", "9789511394884", 2021, 27.95, cRepository.findByName("Harrastekirjat").get(0)));
			repository.save(new Book(0, "Vuonna 1984", "George Orwell", "9789510404478", 2014, 11.95, cRepository.findByName("Scifi").get(0)));
			repository.save(new Book(0, "Humiseva harju", "Emily Brontë", "9789511231516", 2008, 12.95, cRepository.findByName("Kaunokirjallisuus").get(0)));

			System.out.println("Fetch books");
			for (Book book : repository.findAll()) {
				System.out.println(book.toString());
			}
		};
	}

}
