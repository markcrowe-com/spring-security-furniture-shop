
# Snippets

- [POM Dependencies](#pom-dependencies)
- [Product.java](#productjava)
- [ProductService.java](#productservicejava)
- [products.html](#productshtml)
- [product-insert.html](#product-inserthtml)
- [messages.properties](#messagesproperties)

## POM Dependencies

```xml
<dependencies>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
  </dependency>
  <dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
  </dependency>
  <dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-test</artifactId>
    <scope>test</scope>
  </dependency>
  <dependency>
    <groupId>org.thymeleaf.extras</groupId>
    <artifactId>thymeleaf-extras-springsecurity6</artifactId>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <optional>true</optional>
  </dependency>
</dependencies>
```

> See [pom.xml](../pom.xml)

## Product.java

```java
package io.gitlab.markcrowe.furniture.shop.app.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    @NotBlank
    @Size(min=5, max = 5)
    private String code;
    @NotBlank
    @Size(max = 50)
    private String name;
    @NotBlank
    private String description;
    private double buyPrice;
    private double sellPrice;
    private int quantityInStock;
}
```

> See [Product.java](../src/main/java/io/gitlab/markcrowe/furniture/shop/app/model/Product.java)

## ProductService.java

```java
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
/* ... import the product class*/
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
```

> See [ProductService.java](../src/main/java/io/gitlab/markcrowe/furniture/shop/app/services/ProductService.java)

## products.html

```html
<!DOCTYPE html>
<html lang="en" xmlns:sec="http://www.w3.org/1999/xhtml">
<head>
    <title>Products</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>
</head>
<body>
<header>
    <h1>Product Catalog (Java Web 8)</h1>
    <p>Welcome Guest, <a>Login</a></p>
    <p>Welcome User, <a>Logout</a></p>
    </div>
</header>
<main>
    <h2 id="table-header"
        class="table-header text-center"
        th:text="#{website.nav.products}"></h2>
    <a class="btn btn-primary">Insert Product</a>
    <table aria-describedby="table-header" class="table table-striped">
        <thead>
        <tr>
            <th class="text-nowrap" scope="col" th:text="#{product.labels.code}">Code</th>
            <th class="text-nowrap" scope="col" th:text="#{product.labels.name}">Name</th>
            <th class="text-nowrap" scope="col" th:text="#{product.labels.description}">Description</th>
            <th class="text-nowrap" scope="col" th:text="#{product.labels.buyPrice}">Buy Price</th>
            <th class="text-nowrap" scope="col" th:text="#{product.labels.sellPrice}">Sell Price</th>
            <th class="text-nowrap" scope="col" th:text="#{product.labels.qty}">Qty</th>
            <th scope="col">&nbsp;</th>
        </tr>
        </thead>
        <tbody>
        <tr th:each="product: ${productList}">
            <td th:text="${product.code}"></td>
            <td th:text="${product.name}"></td>
            <td th:text="${product.description}"></td>
            <td class="text-end" th:text="${product.buyPrice}"></td>
            <td class="text-end" th:text="${product.sellPrice}"></td>
            <td class="text-end" th:text="${product.quantityInStock}"></td>
            <td><a class="btn btn-danger" th:text="#{record.labels.delete}">Delete</a></td>
        </tr>
        </tbody>
    </table>
</main>
<footer>
    <p>© 2021 Mark Crowe</p>
</footer>
</body>
```

> See [products.html](../src/main/resources/templates/products.html)

## product-insert.html

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Add a Product</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>
</head>
<body>

<a th:href="@{/products}">Back to Products</a>
<form th:object="${product}" method="post">
    <h2 id="table-header"
        class="table-header text-center"
        th:text="#{website.nav.insertProduct}"></h2>
    <table aria-describedby="table-header" class="table table-striped">
        <tr>
            <th scope="row"><label for="code">Code</label></th>
            <td><input type="text" class="form-control" th:field="*{code}" id="code"/></td>
            <td class="text-danger"><span th:if="${#fields.hasErrors('code')}" th:errors="*{code}"></span></td>
        </tr>
        <tr>
            <th scope="row"><label for="name">Name</label></th>
            <td><input type="text" class="form-control" th:field="*{name}" id="name"/></td>
            <td class="text-danger"><span th:if="${#fields.hasErrors('name')}" th:errors="*{name}"></span></td>
        </tr>
        <tr>
            <th scope="row"><label for="description">Description</label></th>
            <td><input type="text" class="form-control" th:field="*{description}" id="description"/></td>
            <td class="text-danger"><span th:if="${#fields.hasErrors('description')}" th:errors="*{description}"></span>
            </td>
        </tr>
        <tr>
            <th scope="row"><label for="buy-price">Buy Price</label></th>
            <td><input type="number" class="form-control" th:field="*{buyPrice}" id="buy-price"/></td>
            <td class="text-danger"><span th:if="${#fields.hasErrors('buyPrice')}" th:errors="*{buyPrice}"></span></td>
        </tr>
        <tr>
            <th scope="row"><label for="sell-price">Sell Price</label></th>
            <td><input type="number" class="form-control" th:field="*{sellPrice}" id="sell-price"/></td>
            <td class="text-danger"><span th:if="${#fields.hasErrors('sellPrice')}" th:errors="*{sellPrice}"></span>
            </td>
        </tr>
        <tr>
            <th scope="row"><label for="quantity-in-stock">Quantity In Stock</label></th>
            <td><input type="number" class="form-control" th:field="*{quantityInStock}" id="quantity-in-stock"/></td>
            <td class="text-danger"><span th:if="${#fields.hasErrors('quantityInStock')}"
                                          th:errors="*{quantityInStock}"></span></td>
        </tr>
        <tr>
            <td>
                <button type="submit"
                        class="btn btn-primary"
                        th:text="#{record.buttons.save}">Save
                </button>
                <button type="reset"
                        class="btn btn-secondary"
                        th:text="#{record.buttons.reset}">Reset
                </button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
```

> See [product-insert.html](../src/main/resources/templates/product-insert.html)

## messages.properties

```properties
#Product
product.labels.buyPrice=Buy Price
product.labels.code=Code
product.labels.description=Description
product.labels.name=Name
product.labels.qty=Qty
product.labels.quantityInStock=Quantity In Stock
product.labels.sellPrice=Sell Price
#Record
record.labels.details=Details
record.labels.edit=Edit
record.labels.delete=Delete
record.buttons.editDetails=Edit Details
#Website
website.title=Furniture Shop
#WebsiteNavigation
website.nav.products=Products
website.nav.insertProduct=Insert Product
record.buttons.save=Add Product
record.buttons.reset=Reset
```

> See [messages.properties](../src/main/resources/messages.properties)