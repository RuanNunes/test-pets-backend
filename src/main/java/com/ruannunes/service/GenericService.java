package com.ruannunes.service;

import com.ruannunes.contract.dto.PaginatedResourceDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

/** @author ruannunes
 * Date 12/07/2020
 *
 * @param <CREATED> Create DTO recebe tipo de classe para criar um recurso/entity
 * @param <UPDATE>  Update DTO recebe tipo de classe para alterar um recurso/entity
 * @param <FILTER>  Filter DTO recebe tipo de classe para filtra e ordenar um recurso/entity
 */
public interface GenericService<CREATED, UPDATE, FILTER> {
	public CREATED save(final CREATED dto);
	public List<CREATED> findAll();
	public CREATED find(final Long id);
	public CREATED update(final UPDATE dto,final Long id);
	public void delete (Long id);
	public PaginatedResourceDTO<CREATED> findPaginate(final FILTER filter);
}
