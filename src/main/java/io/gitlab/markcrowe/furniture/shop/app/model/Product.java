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