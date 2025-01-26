package dev.cavalcanti.store.service;

import dev.cavalcanti.store.entity.Customer;
import dev.cavalcanti.store.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService_SpringDataJpa implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService_SpringDataJpa(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> whoBought(String productCode) {
        return this.customerRepository.findAllByActiveAndOrders_Product_Code(true, productCode);
    }
}
