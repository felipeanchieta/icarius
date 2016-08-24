package br.edu.ufabc.icarius.controller;

import br.edu.ufabc.icarius.controller.forms.SearchForm;
import br.edu.ufabc.icarius.model.BooksRepository;
import br.edu.ufabc.icarius.model.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Set;

@Controller
public class SearchController {

    @Autowired
    private BooksRepository booksRepository;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView search(@ModelAttribute @Valid SearchForm form, BindingResult result) {
        if (result.hasErrors()) return null;

        if (form.getSearchExpression().isEmpty()) {
            return new ModelAndView("search-results")
                .addObject("bookList", booksRepository.findAll());
        }

        Set<Book> searchResults = booksRepository.findByTitle(form.getSearchExpression());
        searchResults.addAll(booksRepository.findByIsbn(form.getSearchExpression()));
        searchResults.addAll(booksRepository.findByAuthor(form.getSearchExpression()));
        searchResults.addAll(booksRepository.findByPress(form.getSearchExpression()));
        searchResults.addAll(booksRepository.findByLocation(form.getSearchExpression()));
        try {
            searchResults.addAll(booksRepository.findByYear(Integer.parseInt(form.getSearchExpression())));
        } catch (NumberFormatException ignored) {
        }

        ModelAndView modelAndView = new ModelAndView("search-results");
        modelAndView.addObject("bookList", searchResults);
        return modelAndView;
    }
}