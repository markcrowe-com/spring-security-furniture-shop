package io.gitlab.markcrowe.furniture.shop.app.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RootWebController {

    @GetMapping("/")
    public ModelAndView getHomePage()
    {
        return new ModelAndView("home-page");
    }
}
