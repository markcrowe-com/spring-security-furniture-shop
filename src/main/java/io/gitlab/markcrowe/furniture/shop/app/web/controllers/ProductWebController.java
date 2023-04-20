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

    @GetMapping("add")
    public ModelAndView getInsertProduct()
    {
        var modelAndView = new ModelAndView("product-insert");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @RequestMapping("add")
    public String getInsertProduct(@Valid Product product, BindingResult bindingResult, ModelAndView model)
    {
        if(bindingResult.hasErrors())
            return "product-insert";

        productService.addAProduct(product);

        return "redirect:/products";
    }
}
