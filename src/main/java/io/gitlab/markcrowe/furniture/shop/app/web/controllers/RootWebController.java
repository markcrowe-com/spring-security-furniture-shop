package io.gitlab.markcrowe.furniture.shop.app.web.controllers;

import io.gitlab.markcrowe.furniture.shop.app.model.Product;
import io.gitlab.markcrowe.furniture.shop.app.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class RootWebController {

    @GetMapping
    public ModelAndView getHomePage()
    {
        return new ModelAndView("home-page");
    }
}
