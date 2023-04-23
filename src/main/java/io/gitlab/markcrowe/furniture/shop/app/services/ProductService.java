package io.gitlab.markcrowe.furniture.shop.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import io.gitlab.markcrowe.furniture.shop.app.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    static ArrayList<Product> products = new ArrayList<>();

    static {
        products.add(new Product("XG809", "Contemporary Office Desk", "Concentrating on the job is a lot easier when everyone has a place that's comfortable to work at.", 25.00, 69.00, 18));
        products.add(new Product("BG565", "Bed Frame With Storage", "With the comfort and quality you get from our sturdy single beds, you'll wake up refreshed and ready to roll. ", 139.00, 175.00, 5));
        products.add(new Product("PO262", "TV Stand", "Our TV stands and TV cabinets are there to cut the clutter and get things organized.", 69.99, 89.99, 120));
        products.add(new Product("MC342", "Kitchen Unit", "They make the most of your wall by giving you extra storage, and the right kitchen shelf can boost the style of your decor too", 23.00, 65.99, 89));
        products.add(new Product("WS341", "Folding Chair", "You can fold the chair, so it takes less space when you're not using it.", 12.00, 35.99, 30));
        products.add(new Product("TF875", "Beant Kitchen", "Express yourself in the place where all of life's daily activities take place.in our stylish, yet personalized kitchen..", 8900.00, 12200.99, 4));
    }

    public boolean addProduct(Product product) {
        return products.add(product);
    }

    public boolean deleteProductByCode(String code) {
        var theProduct = getProductByCode(code);

        if (theProduct == null)
            throw new NoSuchElementException(String.format("No product matches code '%s'", code));

        return products.remove(theProduct);
    }

    public Product getProductByCode(String code) {
        for (Product product : products) {
            if (product.getCode().equalsIgnoreCase(code))
                return product;
        }
        return null;
    }

    public List<Product> getProducts() {
        return products;
    }
}
