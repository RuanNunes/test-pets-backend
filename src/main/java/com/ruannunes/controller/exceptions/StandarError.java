package com.ruannunes.controller.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ruan nunes
 * @date 12/07/2020
 * @description modelo de dados para representar field padrões retornado pela exception do java e serializa como json
 */

@Data
@AllArgsConstructor
public class StandarError implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer status;
	private String msg;
	private Long timeStamp;
}
