package com.ruannunes.service;

import com.google.common.collect.ImmutableMap;
import com.ruannunes.contract.dto.PaginatedResourceDTO;
import com.ruannunes.contract.dto.PetsDTO;
import com.ruannunes.contract.dto.UpdatePetsDTO;
import com.ruannunes.contract.dto.filters.PetsFilterDTO;
import com.ruannunes.contract.dto.filters.enuns.BaseSortDTO;
import com.ruannunes.mapper.PetsMapper;
import com.ruannunes.model.Customer;
import com.ruannunes.model.Pets;
import com.ruannunes.repository.CustomerRepository;
import com.ruannunes.repository.PetsRepository;
import com.ruannunes.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author ruan nunes
 * @date 12/07/2020
 * @description service de pets,  responsavel por implementar regras de negocio.
 */

@Service
public class PetsService implements GenericService<PetsDTO,UpdatePetsDTO, PetsFilterDTO> {
    @Autowired
    private PetsRepository petsRepository;
    @Autowired
    private CustomerRepository costumerRepository;
    @Autowired
    private PetsMapper mapper;

    @Override
    public PetsDTO save(PetsDTO dto) {
        if((dto.getId() != null))
            dto.setId(null);

        final Pets entity = mapper.toEntity(dto);
        final Optional<Customer> costumer = costumerRepository.findById(dto.getCustomerId());
        entity.setCustomer(costumer.orElseThrow( ()->  new ResourceNotFoundException("Costumer-id " + dto.getCustomerId() + "não encontrado")));
        return mapper.toDto(petsRepository.save(entity));
    }

    @Override
    public List<PetsDTO> findAll() {
        final var Pets = petsRepository.findAll();

        if(Pets.isEmpty())
            new ResourceNotFoundException("Não existe pets cadastrados");

        return mapper.toDto(Pets);
    }

    @Override
    public PetsDTO find(Long id) {
        final Optional<Pets> obj = petsRepository.findById(id);
        return mapper.toDto(obj.orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado! Id: "+id+", Tipo: "+ Pets.class.getName())));
    }

    @Override
    public PetsDTO update(UpdatePetsDTO dto, Long id) {
        if(dto.getCor() == null){

        }
        final Pets entity = petsRepository.findById(id)
                .orElseThrow(ResourceNotFoundException.supply());
        final Pets updateEntity = mapper.updateEntity(entity, PetsDTO.builder()
                                                                    .cor(dto.getCor() != null ? dto.getCor() : null)
                                                                    .name(dto.getName() != null ? dto.getName() : null)
                                                                    .description(dto.getDescription() != null ? dto.getDescription() : null)
                                                                    .raca(dto.getRaca() != null ? dto.getRaca() : null)
                                                                    .build());
        final Pets updatedEntity = petsRepository.save(updateEntity);
        return mapper.toDto(updatedEntity);
    }

    @Override
    public PaginatedResourceDTO<PetsDTO> findPaginate(PetsFilterDTO filter) {
        final var sortMapping = ImmutableMap.<BaseSortDTO, Sort>builder()
                .put(BaseSortDTO.MOST_RECENT, Sort.by("created_date").descending())
                .put(BaseSortDTO.LEAST_RECENT, Sort.by("created_date").ascending())
                .build();

        final Sort sort = sortMapping.get(filter.getSorter());
        final PageRequest pageRequest = PageRequest.of(filter.getPage(), filter.getLimit(), sort);

        final var pets = petsRepository.findPetsForName(filter.getName(), pageRequest);
        return mapper.toDto(pets);
    }

    public void delete(final Long id) {
        petsRepository.deleteById(id);
    }
}
