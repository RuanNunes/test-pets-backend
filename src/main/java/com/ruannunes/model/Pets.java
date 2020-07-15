package com.ruannunes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author ruan nunes
 * @date 12/07/2020
 * @description Entidade relacional de pets utilisando hibernate para abstratir mundo relacional banco de dados e mundo orientado a objetos java
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Entity
@SequenceGenerator(name = "sequence_generator", sequenceName = "SEQ_PETS", allocationSize = 1)
@Table(name = "pets", indexes = {@Index(name = "idx_name_pets", columnList = "name", unique = false),})
public class Pets extends  PersistentEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull
    @Column(length = 80)
    private String name;

    @NotNull
    @Column(length = 80)
    private String raca;

    @NotNull
    @Column(length = 80)
    private String cor;

    @NotNull
    @Column(length = 250)
    private String description;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
