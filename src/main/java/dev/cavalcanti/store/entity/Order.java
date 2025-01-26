package dev.cavalcanti.store.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "`ORDER`")
public class Order {

    public Order() {
    }

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    private Customer customer;

    public Order(Product product, Customer customer) {
        this.product = product;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
