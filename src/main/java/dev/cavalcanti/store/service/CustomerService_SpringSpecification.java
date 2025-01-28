package dev.cavalcanti.store.service;

import dev.cavalcanti.store.entity.Customer;
import dev.cavalcanti.store.entity.Order;
import dev.cavalcanti.store.repository.CustomerRepository;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService_SpringSpecification implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService_SpringSpecification(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> whoBought(String productCode) {

        Specification<Customer> specification = Specification
                .where(containsOrderWithProductCode(productCode))
                .and(isActive());

        return this.customerRepository.findAll(specification);
    }

    private Specification<Customer> isActive() {
        return (root, query, builder) -> builder.equal(root.get("active"), true);
    }

    private Specification<Customer> containsOrderWithProductCode(String productCode) {
        return (root, query, builder) -> {
            Join<Customer, Order> join = root.join("orders");
            return builder.equal(join.get("product").get("code"), productCode);
        };
    }

}
