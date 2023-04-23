package io.gitlab.markcrowe.furniture.shop.app.web.controllers;

import io.gitlab.markcrowe.furniture.shop.app.model.Product;
import io.gitlab.markcrowe.furniture.shop.app.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductWebController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ModelAndView getProducts()
    {
        var modelAndView = new ModelAndView("products");
        modelAndView.addObject("productList", productService.getProducts());
        return modelAndView;
    }

    @GetMapping("/products/add")
    public ModelAndView getInsertProduct()
    {
        var modelAndView = new ModelAndView("product-insert");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/products/add")
    public String getInsertProduct(@Valid Product product, BindingResult bindingResult, ModelAndView model)
    {
        if(bindingResult.hasErrors())
            return "product-insert";

        productService.addProduct(product);

        return "redirect:/products";
    }

    @GetMapping("/products/{code}/delete")
    public String deleteProductByCode(@PathVariable("code") String code)
    {
        productService.deleteProductByCode(code);
        return "redirect:/products";
    }
}
