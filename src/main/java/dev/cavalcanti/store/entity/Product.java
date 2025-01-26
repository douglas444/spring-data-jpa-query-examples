package dev.cavalcanti.store.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Product {

    public Product() {
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Double price;

    @Column
    private String title;

    @Column(unique = true)
    private String code;

    public Product(String title, Double price, String code) {
        this.price = price;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
