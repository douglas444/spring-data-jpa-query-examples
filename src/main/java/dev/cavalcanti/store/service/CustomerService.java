package dev.cavalcanti.store.service;

import dev.cavalcanti.store.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> whoBought(String productCode);

}
