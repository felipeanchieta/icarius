package br.edu.ufabc.icarius.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by fcosta on 15/07/16.
 */
@Controller
public class UserController {
    @RequestMapping(value = "/details", method = RequestMethod.GET)
    String details() {
        return "details";
    }
}
