package br.edu.ufabc.icarius.model;

import br.edu.ufabc.icarius.model.entities.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ReservationsRepository extends CrudRepository<Reservation, Integer> {
    Set<Reservation> findByCpf(String cpf);

    Set<Reservation> findByIsbn(String isbn);
}
