package com.ruannunes.contract.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author ruan nunes
 * @date 12/07/2020
 * @description class dto para representar uma criação de cliente e suas validações d
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private  Long id;
	@NotNull
	private String email;
	@NotNull
	private String name;
	@NotNull
	private String password;
	@NotNull
	private  String cpf;

}
