package edu.aubg.reflection.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("register");
    }

    @GetMapping("/services")
    public ModelAndView services() {
        return new ModelAndView("services");
    }

    @GetMapping("/about")
    public ModelAndView about() {
        return new ModelAndView("about");
    }
}
