package com.ruannunes.controller;

import com.ruannunes.contract.PetsApi;
import com.ruannunes.contract.dto.*;
import com.ruannunes.contract.dto.filters.PetsFilterDTO;
import com.ruannunes.service.PetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/**
 * @author ruan nunes
 * @date 12/07/2020
 * @description class controller, onde faz o redirecionamente da chamada rest para camada service
 */

@Valid
@RestController
public class PetsController implements PetsApi {

	@Autowired
	private PetsService service;

	@Override
	public ResponseEntity<Void> save(@Valid @RequestBody PetsDTO dto) {
		final var obj = service.save(dto);
		//retorna url com novo registro inserido
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		// Não está retornando a URI no corpo da response
		return ResponseEntity.created(uri).build();
	}

	@Override
	public ResponseEntity<PetsDTO> find(Long id) {
		return ResponseEntity.ok().body(service.find(id));
	}

	@Override
	public ResponseEntity<List<PetsDTO>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@Override
	public ResponseEntity<PetsDTO> update(UpdatePetsDTO dto, Long id) {
		return ResponseEntity.ok().body(service.update(dto, id));
	}

	@Override
	public ResponseEntity<Void> delete(Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@Override
	public ResponseEntity<PaginatedResourceDTO<PetsDTO>> findPaginate(@Valid PetsFilterDTO filters) {
		return ResponseEntity.ok().body(service.findPaginate(filters));
	}

}

