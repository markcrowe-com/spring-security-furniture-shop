package io.gitlab.markcrowe.furniture.shop.app.web.controllers;

import io.gitlab.markcrowe.furniture.shop.app.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("products")
public class ProductWebController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ModelAndView getProducts()
    {
        var modelAndView = new ModelAndView("products");
        modelAndView.addObject("productList", productService.getAllProducts());
        return modelAndView;
    }
}
