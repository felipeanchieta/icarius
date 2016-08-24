package br.edu.ufabc.icarius;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class IcariusApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(IcariusApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(IcariusApplication.class);
    }

/*    @Bean
    public CommandLineRunner demo(BooksRepository booksRepository, UsersRepository usersRepository) {
        return (args) -> {
            booksRepository.save(new Book("46894", "Algum título"));
            booksRepository.save(new Book("464646", "Outro título"));

            usersRepository.save(new User(43111027805L, "Felipe Anchieta Santos Costa",
                "felipe.anchieta", new Byte[]{0, 1}));
            //felipe = 2bd2d3a31934d76198acc030caca4c31965474fe5fa48f35fef79d0fd74ee1b2
        };
    }*/
}
