package top.kou.product.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class ProductCreateBo {
    @NotNull(message = "Product's Name Cannot By Empty")
    private String name;

    @Digits(integer = 2, fraction = 2, message = "Product's Cost Not Illegal")
    private Double cost;

    @Digits(integer = 2, fraction = 2, message = "Product's Price Not Illegal")
    private Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
