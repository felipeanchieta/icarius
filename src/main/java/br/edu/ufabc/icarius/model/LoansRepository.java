package br.edu.ufabc.icarius.model;

import br.edu.ufabc.icarius.model.entities.Loan;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface LoansRepository extends CrudRepository<Loan, Integer> {
    Set<Loan> findByCpf(String cpf);

    Set<Loan> findByIsbn(String isbn);
}
