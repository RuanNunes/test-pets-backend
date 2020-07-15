package com.ruannunes.repository;

import com.ruannunes.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ruan nunes
 * @date 12/07/2020
 * @description repository de cliente, interface responsavel por implementar recursos do Spring Data
 *              e fazer toda manipulação e connection entre aplicação e banco de dados
 */

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Transactional(readOnly = true)
    @Query(value = "select * from costumer c" +
            " where c.name like %?1%", nativeQuery = true)
    Page<Customer> findCustomers(String name, Pageable page);

    @Transactional(readOnly = true)
    Customer findByEmail(String email);
}
