package br.edu.ufabc.icarius.controller;

import br.edu.ufabc.icarius.controller.forms.SearchForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by fcosta on 15/07/16.
 */
@Controller
public class SearchController {
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    String search(@ModelAttribute @Valid SearchForm form, BindingResult result) {
        if (!result.hasErrors()) {
            // add error
        }

        return "search-results";
    }
}
