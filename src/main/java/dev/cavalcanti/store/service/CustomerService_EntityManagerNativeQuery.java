package dev.cavalcanti.store.service;

import dev.cavalcanti.store.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService_EntityManagerNativeQuery implements CustomerService {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public List<Customer> whoBought(String productCode) {

        String query = """
            SELECT
                DISTINCT(c.*)
            FROM
                `customer` c
                JOIN `order` o ON o.customer_id = c.id
                JOIN `product` p ON o.product_id = p.id
            WHERE
                p.code = :productCode
                AND c.active = TRUE
            """;

        return this.entityManager.createNativeQuery(query, Customer.class)
                .setParameter("productCode", productCode)
                .getResultList();

    }
}
