package com.ecommerce.domain;

import com.ecommerce.domain.strategy.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;

    public String description;

    public Double price;

    public Integer stock;

    public String image;

    @ManyToOne
    public Category category;

    public Product() {
    }

    public Product(String name, String description, Double price, Integer stock, String image,Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.image = image;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }

    public Double getPrice() {
        return category.discount(this.price);
    }
}
