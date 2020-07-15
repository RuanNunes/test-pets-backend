package com.ruannunes.contract;
import com.ruannunes.contract.dto.CustomerPetsDTO;
import com.ruannunes.contract.dto.UpdateCustomerDTO;
import com.ruannunes.contract.dto.CustomerDTO;
import com.ruannunes.contract.dto.PaginatedResourceDTO;
import com.ruannunes.contract.dto.filters.CustomerFilterDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;
import java.util.List;

/**
 * @author ruan nunes
 * @date 12/07/2020
 * @description interface para representar api Rest De Clientes e Documentação utilizando Swagger
 */

@RequestMapping("/customers")
public interface CustomerApi extends GenericApi<CustomerDTO, UpdateCustomerDTO, CustomerFilterDTO> {


	@ApiOperation(value="Inclusão de custumer")
	@PostMapping()
	public ResponseEntity<Void> save(@Valid @RequestBody CustomerDTO dto);

	@Override
	@ApiOperation(value="Busca por custumer-id") 
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "custumer não encontrado") })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<CustomerDTO> find(@PathVariable Long id);
	
	@Override
	@ApiOperation(value="Busca todos costumer")
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "nenhum costumer encontrado") })
	@GetMapping
	public ResponseEntity<List<CustomerDTO>> findAll();

	@Override
	@ApiOperation(value="Alterar por costumer-id")
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "custumer não encontrado") })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<CustomerDTO> update(final @Valid @RequestBody UpdateCustomerDTO dto, @PathVariable Long id);

	@Override
	@ApiOperation(value="deleta por costumer-id")
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "custumer não encontrado") })
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id);

	@ApiOperation(value="Busca De Costumers Paginada")
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "nenhum cliente encontrado") })
	@GetMapping("/paginate")
	ResponseEntity<PaginatedResourceDTO<CustomerDTO>> findPaginate(@SpringQueryMap @Valid final CustomerFilterDTO filters);

	@ApiOperation(value="Busca De cliente e seus pets")
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "nenhum cliente encontrado") })
	@GetMapping("/pets")
	ResponseEntity<PaginatedResourceDTO<CustomerPetsDTO>> findCustomerForPets(@SpringQueryMap @Valid final CustomerFilterDTO filters);
}
