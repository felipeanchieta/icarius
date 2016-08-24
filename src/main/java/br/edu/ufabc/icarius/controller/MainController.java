package br.edu.ufabc.icarius.controller;

import br.edu.ufabc.icarius.controller.forms.NewUserForm;
import br.edu.ufabc.icarius.model.UsersRepository;
import br.edu.ufabc.icarius.model.entities.User;
import br.edu.ufabc.icarius.util.AuthenticationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class MainController {

    @Autowired
    private UsersRepository users;

    @Autowired
    private AuthenticationUtils authenticationUtils;

    @RequestMapping(value = {"/", "/home", "/index"})
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/new_user", method = RequestMethod.GET)
    public String newUserPage() {
        return "new_user";
    }

    @RequestMapping(value = "/new_user", method = RequestMethod.POST)
    public String newUserProcess(@Valid @ModelAttribute NewUserForm form, BindingResult result) {
        if (result.hasErrors() || !form.getPassword().equals(form.getPasswordRepeat())) {
            return "";
        }

        User user = new User();
        user.setName(form.getName());
        user.setUsername(form.getUsername());
        user.setCpf(form.getCpf());

        try {
            user.setBirthDate((new SimpleDateFormat("yyyy-MM-dd")).parse(form.getBirthDate()));
        } catch (ParseException e) {
            user.setBirthDate(new Date());
        }

        form.setPasswordRepeat(null);
        user.setPassword(authenticationUtils.generateSha256(form.getPassword()));
        form.setPassword(null);

        users.save(user);

        return "redirect:/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public void logout() {

    }
}
