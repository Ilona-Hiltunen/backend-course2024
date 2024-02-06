package training_project.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import training_project.bookstore.domain.Book;
import training_project.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		//Mallia kirjoihin otettu Suomalaisen kirjakaupan sivustolta https://www.suomalainen.com/
		return (args) -> {
			System.out.println("Save books");
			repository.save(new Book("Muumit Juhlakirja", "Paula Nivukoski", "9789511394884", 2021, 27.95));
			repository.save(new Book("Vuonna 1984", "George Orwell", "9789510404478", 2014, 11.95));
			repository.save(new Book("Humiseva harju", "Emily Brontë", "9789511231516", 2008, 12.95));

			System.out.println("Fetch books");
			for (Book book : repository.findAll()) {
				System.out.println(book.toString());
			}
		};
	}

}
