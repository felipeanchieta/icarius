package br.edu.ufabc.icarius.controller;

import br.edu.ufabc.icarius.model.BooksRepository;
import br.edu.ufabc.icarius.model.LoansRepository;
import br.edu.ufabc.icarius.model.ReservationsRepository;
import br.edu.ufabc.icarius.model.UsersRepository;
import br.edu.ufabc.icarius.model.entities.Loan;
import br.edu.ufabc.icarius.model.entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

import static org.springframework.security.core.context.SecurityContextHolder.getContext;

@Controller
public class OperationsController {
    @Autowired
    private UsersRepository users;

    @Autowired
    private BooksRepository books;

    @Autowired
    private LoansRepository loans;

    @Autowired
    private ReservationsRepository reservations;

    @RequestMapping(value = "/doLoan", method = RequestMethod.POST)
    public String doLoan(@RequestParam(value = "isbn") String isbn) {
        Loan loan = new Loan();

        /* needs to check if the ISBN does exist */
        if (books.findByIsbn(isbn).isEmpty()) return "";

        loan.setCpf(users.findByUsername(getContext().getAuthentication().getName()).getCpf());
        loan.setIsbn(isbn);
        loan.setLoanDate(new Date());
        loan.setReturnDate(Date.from(LocalDateTime.from(new Date().toInstant()).plusDays(7).toInstant(ZoneOffset.UTC)));

        loans.save(loan);
        return "redirect:/loans";
    }

    @RequestMapping(value = "/doReservation", method = RequestMethod.POST)
    public String doReservation(@RequestParam(value = "isbn") String isbn) {
        Reservation reservation = new Reservation();

        /* needs to check if the ISBN does exist */
        if (books.findByIsbn(isbn).isEmpty()) return "";

        reservation.setCpf(users.findByUsername(getContext().getAuthentication().getName()).getCpf());
        reservation.setIsbn(isbn);
        reservation.setReservationDate(new Date());

        reservations.save(reservation);
        return "redirect:/reservations";
    }

    @RequestMapping(value = "/returnBook", method = RequestMethod.GET)
    public String returnBook(@RequestParam(value = "isbn") String isbn) {
        AtomicReference<String> username = new AtomicReference<>(getContext().getAuthentication().getName());
        Set<Loan> set = loans.findByCpf(users.findByUsername(username.get()).getCpf());
        set.retainAll(loans.findByIsbn(isbn));

        for (Loan loan : set) {
            loans.delete(loan);
        }

        return "redirect:/loans";
    }

    @RequestMapping(value = "/cancelReservation", method = RequestMethod.GET)
    public String cancelReservation(@RequestParam(value = "isbn") String isbn) {
        AtomicReference<String> username = new AtomicReference<>(getContext().getAuthentication().getName());
        Set<Reservation> set = reservations.findByCpf(users.findByUsername(username.get()).getCpf());
        set.retainAll(reservations.findByIsbn(isbn));

        for (Reservation reservation : set) {
            reservations.delete(reservation);
        }

        return "redirect:/reservations";
    }
}
