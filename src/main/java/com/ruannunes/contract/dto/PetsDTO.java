package com.ruannunes.contract.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author ruan nunes
 * @date 12/07/2020
 * @description class dto para representar Criação de pets e validações de campos
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PetsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    @NotNull
    private  Long customerId;
    @NotNull
    private String raca;
    @NotNull
    private String name;
    @NotNull
    private String cor;
    private String description;
}
