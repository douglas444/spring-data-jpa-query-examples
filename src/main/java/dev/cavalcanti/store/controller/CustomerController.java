package dev.cavalcanti.store.controller;

import dev.cavalcanti.store.entity.Customer;
import dev.cavalcanti.store.service.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService_EntityManagerJpaCriteria customerService_EntityManager_jpaCriteria;
    private final CustomerService_SpringDataJpa customerService_springDataJpa;
    private final CustomerService_SpringDataJpaQuery customerService_springDataJpaQuery;
    private final CustomerService_SpringSpecification customerService_springSpecification;
    private final CustomerService_EntityManagerNativeQuery customerService_entityManagerNativeQuery;

    public CustomerController(CustomerService_EntityManagerJpaCriteria customerServiceJpaCriteria,
                              CustomerService_SpringDataJpa customerServiceSpringDataJpa,
                              CustomerService_SpringDataJpaQuery customerServiceSpringDataJpaQuery,
                              CustomerService_SpringSpecification customerServiceSpringSpecification,
                              CustomerService_EntityManagerNativeQuery customerServiceEntityManagerNativeQuery) {
        customerService_EntityManager_jpaCriteria = customerServiceJpaCriteria;
        customerService_springDataJpa = customerServiceSpringDataJpa;
        customerService_springDataJpaQuery = customerServiceSpringDataJpaQuery;
        customerService_springSpecification = customerServiceSpringSpecification;
        customerService_entityManagerNativeQuery = customerServiceEntityManagerNativeQuery;
    }

    @GetMapping("/entity-manager-jpa-criteria/who-bought")
    public List<Customer> jpaCriteria(String productCode) {
        return this.customerService_EntityManager_jpaCriteria.whoBought(productCode);
    }

    @GetMapping("/entity-manager-native-query/who-bought")
    public List<Customer> nativeQuery(String productCode) {
        return this.customerService_entityManagerNativeQuery.whoBought(productCode);
    }

    @GetMapping("/spring-data-jpa/who-bought")
    public List<Customer> springDataJpa(String productCode) {
        return this.customerService_springDataJpa.whoBought(productCode);
    }

    @GetMapping("/spring-data-jpa-criteria/who-bought")
    public List<Customer> springDataJpaQuery(String productCode) {
        return this.customerService_springDataJpaQuery.whoBought(productCode);
    }

    @GetMapping("/spring-specification/who-bought")
    public List<Customer> springSpecification(String productCode) {
        return this.customerService_springSpecification.whoBought(productCode);
    }

}
