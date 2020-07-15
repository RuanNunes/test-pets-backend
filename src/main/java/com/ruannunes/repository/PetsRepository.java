package com.ruannunes.repository;

import com.ruannunes.model.Pets;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ruan nunes
 * @date 12/07/2020
 * @description repository de pets, interface responsavel por implementar recursos do Spring Data
 *              e fazer toda manipulação e connection entre aplicação e banco de dados
 */

@Repository
public interface PetsRepository extends JpaRepository<Pets, Long> {
    @Transactional(readOnly = true)
    @Query(value = "select * from pets p" +
            " where p.name like %?1%", nativeQuery = true)
    Page<Pets> findPetsForName(String name, Pageable page);

    @Transactional(readOnly = true)
    List<Pets> findByCustomer(Long costumerId);

}
