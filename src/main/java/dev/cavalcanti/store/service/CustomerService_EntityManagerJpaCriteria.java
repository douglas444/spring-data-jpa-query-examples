package dev.cavalcanti.store.service;

import dev.cavalcanti.store.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService_EntityManagerJpaCriteria implements CustomerService {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Customer> whoBought(String productCode) {

        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
        Root<Customer> root = query.from(Customer.class);

        Predicate isActive = builder.equal(root.get("active"), true);
        Predicate orderedProductWithId = builder.equal(root.join("orders").get("product").get("code"), productCode);
        query.where(isActive, orderedProductWithId);

        return this.entityManager.createQuery(query).getResultList();

    }
}
