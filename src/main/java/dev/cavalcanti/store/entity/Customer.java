package dev.cavalcanti.store.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Customer {

    public Customer() {
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    private boolean active;

    public Customer(String email) {
        this.email = email;
        this.active = true;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
