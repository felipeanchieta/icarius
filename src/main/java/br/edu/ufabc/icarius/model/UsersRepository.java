package br.edu.ufabc.icarius.model;

import br.edu.ufabc.icarius.model.entities.Book;
import br.edu.ufabc.icarius.model.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by fcosta on 16/07/16.
 */
public interface UsersRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    Long countByUsernameAndPassword(String username, String password);
}
