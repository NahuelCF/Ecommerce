package com.ecommerce.domain;

import com.ecommerce.domain.strategy.Category;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;

@Entity
@Getter
@Setter
@SQLDelete(sql = "UPDATE product SET active = false WHERE id = ?")
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

    public boolean active;

    public Product() {
    }

    public Product(String name, String description, Double price, Integer stock, String image,Category category, boolean active) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.image = image;
        this.category = category;
        this.active = active;
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
