package br.edu.ufabc.icarius.controller;

import br.edu.ufabc.icarius.controller.forms.ReturnBooksForm;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by fcosta on 15/07/16.
 */
public class AdminController {


    @RequestMapping(value = "/insert-user", method = RequestMethod.POST)
    String insertUser() {
        return "";
    }

    @RequestMapping(value = "/return", method = RequestMethod.POST)
    String returnBooks(@ModelAttribute @Valid ReturnBooksForm returnForm) {
        return "return-successful";
    }

    @RequestMapping(value = "/ban", method = RequestMethod.POST)
    String banUser() {
        return "";
    }

}
