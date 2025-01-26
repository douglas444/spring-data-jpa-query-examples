package dev.cavalcanti.store.service;

import dev.cavalcanti.store.entity.Customer;
import dev.cavalcanti.store.repository.CustomerRepository;
import dev.cavalcanti.store.specification.CustomerSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService_SpringSpecification implements CustomerService {

    private final CustomerSpecification customerSpecification;
    private final CustomerRepository customerRepository;

    public CustomerService_SpringSpecification(CustomerSpecification customerSpecification,
                                               CustomerRepository customerRepository) {
        this.customerSpecification = customerSpecification;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> whoBought(String productCode) {

        Specification<Customer> specification = Specification
                .where(this.customerSpecification.containsOrderWithProductCode(productCode))
                .and(this.customerSpecification.isActive());

        return this.customerRepository.findAll(specification);
    }
}
