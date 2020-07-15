package com.ruannunes.contract.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;

/**
 * @author ruan nunes
 * @date 12/07/2020
 * @description class para representar uma serialização json com cosumer e seus pets
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerPetsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String email;
    private String name;
    private  String cpf;
    private List<UpdatePetsDTO> pets;
}
