package com.ruannunes.mapper;

import com.ruannunes.contract.dto.PetsDTO;
import com.ruannunes.model.Pets;
import org.springframework.stereotype.Component;
/**
 * @author ruan nunes
 * @date 12/07/2020
 * @description componente para mapear de maneira automatica o mapeamento de Entity e DTO de pets
 */
@Component
public class PetsMapper extends GenericMapper<Pets, PetsDTO>{

    @Override
    public Pets updateEntity(Pets pets, PetsDTO petsDTO) {
        if (petsDTO.getId() == null || petsDTO.getId() == 0)
            petsDTO.setId(pets.getId());

        return super.updateEntity(pets, petsDTO);
    }

    @Override
    public PetsDTO toDto(Pets pets){
        final var dto = super.toDto(pets);
        if(dto.getCustomerId() == null)
            dto.setCustomerId(pets.getCustomer().getId());
        return dto;
    }
}


