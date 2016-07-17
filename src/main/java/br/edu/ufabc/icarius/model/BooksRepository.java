package br.edu.ufabc.icarius.model;

import br.edu.ufabc.icarius.model.entities.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

/**
 * Created by fcosta on 15/07/16.
 */
public interface BooksRepository extends CrudRepository<Book, Long> {
    Set<Book> findByIsbn(String isbn);
    List<Book> findByTitle(String title);
    Set<Book> findByAuthorList(String... authorList);
    Set<Book> findByPress(String press);
    Set<Book> findByLocation(String location);
    Set<Book> findByYear(int year);
}
