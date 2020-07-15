package com.ruannunes.contract.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
/**
 * @author ruan nunes
 * @date 12/07/2020
 * @description class dto para representar um retorno e update de pets
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePetsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String raca;
    private String name;
    private String cor;
    private String description;
}
