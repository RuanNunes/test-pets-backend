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
 * @description class dto para representar um retorno e update padão de cliente
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCustomerDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String email;
	private String name;
	private  String cpf;
}
