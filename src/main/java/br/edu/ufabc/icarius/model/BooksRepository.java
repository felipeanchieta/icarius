package br.edu.ufabc.icarius.model;

import br.edu.ufabc.icarius.model.entities.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by fcosta on 15/07/16.
 */
public interface BooksRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);
}
