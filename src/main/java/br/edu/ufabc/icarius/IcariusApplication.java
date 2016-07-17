package br.edu.ufabc.icarius;

import br.edu.ufabc.icarius.model.BooksRepository;
import br.edu.ufabc.icarius.model.UsersRepository;
import br.edu.ufabc.icarius.model.entities.Book;
import br.edu.ufabc.icarius.model.entities.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class IcariusApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(IcariusApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(IcariusApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BooksRepository booksRepository, UsersRepository usersRepository) {
        return (args) -> {
            booksRepository.save(new Book("46894", "Algum título"));
            booksRepository.save(new Book("464646", "Outro título"));

            usersRepository.save(new User(43111027805L, "Felipe Anchieta Santos Costa", "felipe.anchieta", "felipe"));
        };
    }
}
