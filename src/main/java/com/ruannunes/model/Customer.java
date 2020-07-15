package com.ruannunes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author ruan nunes
 * @date 12/07/2020
 * @description Entidade relacional de cliente utilisando hibernate para abstratir mundo relacional banco de dados e mundo orientado a objetos java
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Entity
@SequenceGenerator(name = "sequence_generator", sequenceName = "SEQ_CUSTOMER", allocationSize = 1)
@Table(name = "customer", indexes = {@Index(name = "idx_name", columnList = "name", unique = false),
										@Index(name = "idx_email", columnList = "email", unique = false) })
public class Customer extends PersistentEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	@NotNull
	@Column(length = 80)
	private String name;

	@NotNull
	@Column(length = 100)
	private String email;

	@NotNull
	private String password;

	@NotNull
	@Column(length = 14)
	private String cpf;

	@OneToMany(mappedBy = "customer")
	private List<Pets> pests;
}
