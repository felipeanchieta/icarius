package br.edu.ufabc.icarius.controller;

import br.edu.ufabc.icarius.controller.forms.AdvancedSearchForm;
import br.edu.ufabc.icarius.controller.forms.SearchForm;
import br.edu.ufabc.icarius.model.BooksRepository;
import br.edu.ufabc.icarius.model.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by fcosta on 15/07/16.
 */
@Controller
public class SearchController {
    @Autowired
    private BooksRepository booksRepository;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public List<Book> search(@ModelAttribute @Valid SearchForm form, BindingResult result) {
        if (!result.hasErrors()) {
            // add error
        }

        return booksRepository.findByTitle(form.getSearchExpression());
    }

    @RequestMapping(value = "/adv-search-form", method = RequestMethod.GET)
    @ResponseBody
    public String advSearchForm() {
        return "";
    }

    @RequestMapping(value = "/adv-search", method = RequestMethod.GET)
    @ResponseBody
    public List<Book> advSearchResults(AdvancedSearchForm form) {
        Set<Book> results = new TreeSet<>();

        if (form.getIsbn() != null) results.addAll(booksRepository.findByIsbn(form.getIsbn()));
        if (form.getAuthorList() != null) results.addAll(booksRepository.findByAuthorList(form.getAuthorList()));
        if (form.getPress() != null) results.addAll(booksRepository.findByPress(form.getPress()));
        if (form.getLocation() != null) results.addAll(booksRepository.findByLocation(form.getLocation()));
        if (form.getYear() != null) results.addAll(booksRepository.findByYear(form.getYear()));

        return new ArrayList<>(results);
    }
}
