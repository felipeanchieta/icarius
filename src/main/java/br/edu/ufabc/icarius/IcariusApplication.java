package br.edu.ufabc.icarius;

import br.edu.ufabc.icarius.model.BooksRepository;
import br.edu.ufabc.icarius.model.entities.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IcariusApplication {

    public static void main(String[] args) {
        SpringApplication.run(IcariusApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BooksRepository repository) {
        return (args) -> {
            repository.save(new Book("46894", "Algum título"));
            repository.save(new Book("464646", "Outro título"));
        };
    }
}
