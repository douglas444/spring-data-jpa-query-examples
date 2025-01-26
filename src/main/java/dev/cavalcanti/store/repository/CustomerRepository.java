package dev.cavalcanti.store.repository;

import dev.cavalcanti.store.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {

    List<Customer> findAllByOrders_Product_Code(String code);

    @Query(value = """
        SELECT
            DISTINCT(c.*)
        FROM
            `customer` c
            JOIN `order` o ON o.customer_id = c.id
            JOIN `product` p ON o.product_id = p.id
        WHERE
            p.code = :productCode
    """, nativeQuery = true)
    List<Customer> findWhoBoughtProductByCode(@Param("productCode") String productCode);

}
