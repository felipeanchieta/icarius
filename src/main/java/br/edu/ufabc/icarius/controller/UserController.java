package br.edu.ufabc.icarius.controller;

import br.edu.ufabc.icarius.model.UsersRepository;
import br.edu.ufabc.icarius.model.entities.Book;
import br.edu.ufabc.icarius.model.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.springframework.security.core.context.SecurityContextHolder.getContext;

/**
 * Created by fcosta on 15/07/16.
 */
@Controller
public class UserController {
    @Autowired
    private UsersRepository usersRepository;

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    @ResponseBody
    public User getDetails() {
        String username = getContext().getAuthentication().getName();
        return usersRepository.findOne(usersRepository.findByUsername(username).getCpf());
    }

    @RequestMapping(value = "/loans", method = RequestMethod.GET)
    @ResponseBody
    public List<Book> getLoans() {
        String username = getContext().getAuthentication().getName();
        return usersRepository.findByUsername(username).getLoanBooks();
    }

    @RequestMapping(value = "/reserves", method = RequestMethod.GET)
    @ResponseBody
    public List<Book> getReserves() {
        String username = getContext().getAuthentication().getName();
        return usersRepository.findByUsername(username).getReserves();
    }
}
