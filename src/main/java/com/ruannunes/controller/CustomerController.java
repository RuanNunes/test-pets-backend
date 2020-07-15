package com.ruannunes.controller;

import com.ruannunes.contract.CustomerApi;
import com.ruannunes.contract.dto.CustomerPetsDTO;
import com.ruannunes.contract.dto.UpdateCustomerDTO;
import com.ruannunes.contract.dto.CustomerDTO;
import com.ruannunes.contract.dto.PaginatedResourceDTO;
import com.ruannunes.contract.dto.filters.CustomerFilterDTO;
import com.ruannunes.service.CustomerService;
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
public class CustomerController implements CustomerApi {

	@Autowired
	private CustomerService service;

	@Override
	public ResponseEntity<Void> save(@Valid @RequestBody CustomerDTO customer) {
		final var obj = service.save(customer);
		//retorna url com novo registro inserido
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		// Não está retornando a URI no corpo da response
		return ResponseEntity.created(uri).build();
	}

	@Override
	public ResponseEntity<CustomerDTO> find(Long id) {
		return ResponseEntity.ok().body(service.find(id));
	}

	@Override
	public ResponseEntity<List<CustomerDTO>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@Override
	public ResponseEntity<CustomerDTO> update(UpdateCustomerDTO dto, Long id) {
		return ResponseEntity.ok().body(service.update(dto, id));
	}

	@Override
	public ResponseEntity<Void> delete(Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@Override
	public ResponseEntity<PaginatedResourceDTO<CustomerDTO>> findPaginate(@Valid CustomerFilterDTO filters) {
		return ResponseEntity.ok().body(service.findPaginate(filters));
	}

	@Override
	public ResponseEntity<PaginatedResourceDTO<CustomerPetsDTO>> findCustomerForPets(@Valid CustomerFilterDTO filters) {
		return ResponseEntity.ok().body(service.findCustomerForPets(filters));
	}
}

