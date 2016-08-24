package br.edu.ufabc.icarius.model;

import br.edu.ufabc.icarius.model.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

    Long countByUsernameAndPassword(String username, byte[] password);
}
