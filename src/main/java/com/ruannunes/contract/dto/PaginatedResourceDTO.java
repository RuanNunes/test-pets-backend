package com.ruannunes.contract.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author ruan nunes
 * @date 12/07/2020
 * @description class dto para representar uma rerialização json e objeto java para uma pesquisa paginada
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PaginatedResourceDTO<T> implements Serializable {
	private int thisPage;
	private int lastPage;
	private long totalRecords;
	private List<T> records;
	public Stream<T> stream() {
		return records.stream();
	}
}
