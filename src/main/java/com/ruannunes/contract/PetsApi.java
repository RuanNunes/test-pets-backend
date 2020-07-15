package com.ruannunes.contract;

import com.ruannunes.contract.dto.*;
import com.ruannunes.contract.dto.filters.PetsFilterDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
/**
 * @author ruan nunes
 * @date 12/07/2020
 * @description interface para representar api Rest De Pets e Documentação utilizando Swagger
 */
@RequestMapping("/pets")
public interface PetsApi extends GenericApi<PetsDTO,UpdatePetsDTO, PetsFilterDTO> {


	@ApiOperation(value="Inclusão de Pets")
	@PostMapping()
	public ResponseEntity<Void> save(@Valid @RequestBody PetsDTO dto);

	@Override
	@ApiOperation(value="Busca por pets-id")
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "pet não encontrado") })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<PetsDTO> find(@PathVariable Long id);
	
	@Override
	@ApiOperation(value="Busca  todos pets")
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "nenhum pets encontrado") })
	@GetMapping
	public ResponseEntity<List<PetsDTO>> findAll();

	@Override
	@ApiOperation(value="Alterar por pets-id")
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "pet não encontrado") })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<PetsDTO> update(final @Valid @RequestBody UpdatePetsDTO dto, @PathVariable Long id);

	@Override
	@ApiOperation(value="deleta por pets-id")
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "pet não encontrado") })
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id);

	@ApiOperation(value="Busca De pets Paginada")
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "nenhum pet encontrado") })
	@GetMapping("/paginate")
	ResponseEntity<PaginatedResourceDTO<PetsDTO>> findPaginate(@SpringQueryMap @Valid final PetsFilterDTO filters);
}
