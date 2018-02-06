package top.kou.biz.product;

import top.kou.biz.sequence.Sequencer;

import java.util.Objects;

public class Product {
    private Integer id;
    private String name;
    private double cost;
    private double price;

    public Product() {
        this.id = Sequencer.getNextSequence();
    }

    public Product(String name, double cost, double price) {
        this.id = Sequencer.getNextSequence();
        this.name = name;
        this.cost = cost;
        this.price = price;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id) + Objects.hashCode(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        return Objects.equals(id, ((Product) obj).id) || Objects.equals(name, ((Product) obj).name);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
