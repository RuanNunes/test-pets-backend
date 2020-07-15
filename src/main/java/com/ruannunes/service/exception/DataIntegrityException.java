package com.ruannunes.service.exception;
/**
 * @author ruan nunes
 * @date 12/07/2020
 * @description Exception tratada para tipos de erros de banco
 */
public class DataIntegrityException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DataIntegrityException(String msg) {
		super(msg);
	}
	
	public DataIntegrityException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
