package com.ruannunes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.persistence.Version;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author ruan nunes
 * @date 12/07/2020
 * @description Entidade relacional generica para outras entidades extender e manter uma padronização de campos padrões
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@MappedSuperclass
public class PersistentEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator")
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@CreationTimestamp
	@CreatedDate
	@Column(name = "created_date", updatable = false, nullable = false)
	private LocalDateTime createdDate;

	@UpdateTimestamp
	@LastModifiedDate
	@Column(name = "last_modified_date", nullable = false)
	private LocalDateTime lastModifiedDate;

	@Version
	@Column(name = "version", nullable = false)
	private Integer version;

	@Transient
	public boolean isPersisted() {
		return this.getId() != null;
	}

}
