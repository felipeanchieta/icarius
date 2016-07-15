package br.edu.ufabc.icarius.controller;

import br.edu.ufabc.icarius.controller.forms.LendForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by fcosta on 15/07/16.
 */
@Controller
public class OperationsController {
    @RequestMapping(value = "/lend", method = RequestMethod.POST)
    String doLend(@ModelAttribute @Valid LendForm lendForm) {
        return "lend-successful";
    }


}
