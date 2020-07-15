package com.ruannunes.controller.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * @author ruan nunes
 * @date 12/07/2020
 * @description modelo de dados para representar field de exceptions para serializar como json
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldMessage implements Serializable{
	private static final long serialVersionUID = 1L;
	private String fieldName;
	private String message;
}
