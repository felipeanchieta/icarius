package br.edu.ufabc.icarius.controller;

import br.edu.ufabc.icarius.model.BooksRepository;
import br.edu.ufabc.icarius.model.UsersRepository;
import br.edu.ufabc.icarius.model.entities.Book;
import br.edu.ufabc.icarius.model.entities.Loan;
import br.edu.ufabc.icarius.model.entities.Reservation;
import br.edu.ufabc.icarius.model.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.security.core.context.SecurityContextHolder.getContext;

@Controller
public class UserController {

    @Autowired
    private UsersRepository users;

    @Autowired
    private BooksRepository books;

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public ModelAndView getDetails() {
        String username = getContext().getAuthentication().getName();
        User user = users.findByUsername(username);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        return new ModelAndView("status")
            .addObject("username", username)
            .addObject("name", user.getName())
            .addObject("birthDate", sdf.format(user.getBirthDate()))
            .addObject("loans", user.getLoanBooks().size())
            .addObject("reservations", user.getReservations().size());
    }

    @RequestMapping(value = "/loans", method = RequestMethod.GET)
    public ModelAndView getLoans() {
        String username = getContext().getAuthentication().getName();
        List<Loan> loanBooks = users.findByUsername(username).getLoanBooks();
        Set<Book> books = new HashSet<>(loanBooks.size());

        /* FIXME: improve JOIN */
        for (Loan loanBook : loanBooks) {
            books.addAll(this.books.findByIsbn(loanBook.getIsbn()));
        }

        return new ModelAndView("loans")
            .addObject("bookList", books);
    }

    @RequestMapping(value = "/reservations", method = RequestMethod.GET)
    public ModelAndView getReservations() {
        String username = getContext().getAuthentication().getName();
        List<Reservation> reservations = users.findByUsername(username).getReservations();
        Set<Book> books = new HashSet<>(reservations.size());

        /* FIXME: improve JOIN */
        for (Reservation reservation : reservations)
            books.addAll(this.books.findByIsbn(reservation.getIsbn()));

        return new ModelAndView("reservations")
            .addObject("bookList", books);
    }
}
