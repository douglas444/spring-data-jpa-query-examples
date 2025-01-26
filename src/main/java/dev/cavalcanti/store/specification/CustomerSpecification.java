package dev.cavalcanti.store.specification;

import dev.cavalcanti.store.entity.Customer;
import dev.cavalcanti.store.entity.Order;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class CustomerSpecification {

    public Specification<Customer> isActive() {
        return (root, query, builder) -> builder.equal(root.get("active"), true);
    }

    public Specification<Customer> containsOrderWithProductCode(String productCode) {

        return (root, query, builder) -> {
            Join<Customer, Order> join = root.join("orders");
            return builder.equal(join.get("product").get("code"), productCode);
        };

    }

}
