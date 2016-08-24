package br.edu.ufabc.icarius.model;

import br.edu.ufabc.icarius.model.entities.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface BooksRepository extends CrudRepository<Book, Long> {
    Set<Book> findByIsbn(String isbn);

    Set<Book> findByTitle(String title);

    Set<Book> findByAuthor(String author);
    Set<Book> findByPress(String press);
    Set<Book> findByLocation(String location);
    Set<Book> findByYear(int year);
}
