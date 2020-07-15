package com.ruannunes.service;

import com.google.common.collect.ImmutableMap;
import com.ruannunes.contract.dto.CustomerPetsDTO;
import com.ruannunes.contract.dto.UpdateCustomerDTO;
import com.ruannunes.contract.dto.CustomerDTO;
import com.ruannunes.contract.dto.PaginatedResourceDTO;
import com.ruannunes.contract.dto.filters.CustomerFilterDTO;
import com.ruannunes.contract.dto.filters.enuns.BaseSortDTO;
import com.ruannunes.mapper.CustomerMapper;
import com.ruannunes.mapper.CustomerPetsMapper;
import com.ruannunes.model.Customer;
import com.ruannunes.repository.CustomerRepository;
import com.ruannunes.repository.PetsRepository;
import com.ruannunes.service.exception.DataIntegrityException;
import com.ruannunes.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author ruan nunes
 * @date 12/07/2020
 * @description service de cliente,  responsavel por implementar regras de negocio.
 */

@Service
public class CustomerService implements GenericService<CustomerDTO, UpdateCustomerDTO, CustomerFilterDTO>{
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerMapper mapper;

	@Autowired
	private CustomerPetsMapper customerPetsMapper;

	@Override
	public CustomerDTO save(final CustomerDTO dto) {
		final Customer entity = mapper.toEntity(dto);
		final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		entity.setPassword(encoder.encode(entity.getPassword()));
		return mapper.toDto(customerRepository.save(entity));
	}

	@Override
	public List<CustomerDTO> findAll(){
		final var custumers = customerRepository.findAll();
		if(custumers.isEmpty())
			new ResourceNotFoundException("Não existe clientes cadastrados");
		
		return mapper.toDto(custumers);
	}
	
	@Override
	public CustomerDTO find(Long id) {
		final Optional<Customer> obj = customerRepository.findById(id);
		return mapper.toDto(obj.orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado! Id: "+id+", Tipo: "+ Customer.class.getName())));
	}

	@Override
	public CustomerDTO update(final UpdateCustomerDTO dto, final Long id) {
		final Customer entity = customerRepository.findById(id)
												  .orElseThrow(ResourceNotFoundException.supply());
		final Customer updateEntity = mapper.updateEntity(entity, CustomerDTO.builder()
																	.name(dto.getName() != null ? dto.getName() : null)
																	.email(dto.getEmail() != null ? dto.getEmail() : null)
																	.build());
		final Customer updatedEntity = customerRepository.save(updateEntity);
		return mapper.toDto(updatedEntity);
	}

	@Override
	public void delete(Long id) {
		final var customer = customerRepository.findById(id)
							.orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado! Id: "+id+", Tipo: "+ Customer.class.getName()));
		if(customer.getPests().size() > 0)
			throw new DataIntegrityException("Customer não pode ser excluido pois possui pets cadastrados");

		customerRepository.deleteById(id);
	}

	@Override
	public PaginatedResourceDTO<CustomerDTO> findPaginate(CustomerFilterDTO filter) {
		final var sortMapping = ImmutableMap.<BaseSortDTO, Sort>builder()
				.put(BaseSortDTO.MOST_RECENT, Sort.by("created_date").descending())
				.put(BaseSortDTO.LEAST_RECENT, Sort.by("created_date").ascending())
				.build();

		final Sort sort = sortMapping.get(filter.getSorter());
		final PageRequest pageRequest = PageRequest.of(filter.getPage(), filter.getLimit(), sort);

		final var costumers = customerRepository.findCustomers(filter.getName(), pageRequest);
		return mapper.toDto(costumers);
	}

	public PaginatedResourceDTO<CustomerPetsDTO> findCustomerForPets(CustomerFilterDTO filter) {
		final var sortMapping = ImmutableMap.<BaseSortDTO, Sort>builder()
				.put(BaseSortDTO.MOST_RECENT, Sort.by("created_date").descending())
				.put(BaseSortDTO.LEAST_RECENT, Sort.by("created_date").ascending())
				.build();

		final Sort sort = sortMapping.get(filter.getSorter());
		final PageRequest pageRequest = PageRequest.of(filter.getPage(), filter.getLimit(), sort);

		final var costumers = customerRepository.findCustomers(filter.getName(), pageRequest);
		return customerPetsMapper.toDto(costumers);
	}

}
