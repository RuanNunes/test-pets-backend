package com.ruannunes.controller.exceptions;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ruan nunes
 * @date 12/07/2020
 * @description modelo de dados para representar object de exception do java e serializa como json
 */
@Getter
public class ValidationError extends StandarError{
	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> errors = new ArrayList<>();
	
	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
	}

	public void addError(String fieldName, String messagem) {
		this.errors.add(new FieldMessage(fieldName, messagem));
	}
}
