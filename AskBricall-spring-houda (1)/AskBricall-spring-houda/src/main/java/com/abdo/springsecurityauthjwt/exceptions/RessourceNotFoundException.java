package com.abdo.springsecurityauthjwt.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RessourceNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ressourceName;
	private String fieldNamae;
	private Object fieldValue;
	
	public RessourceNotFoundException(String ressourceName, String fieldNamae, Object fieldValue) {
		super(String.format("%s not found with %s : '%s'", ressourceName, fieldNamae, fieldValue));
		this.ressourceName = ressourceName;
		this.fieldNamae = fieldNamae;
		this.fieldValue = fieldValue;
	}

	public String getRessourceName() {
		return ressourceName;
	}

	public void setRessourceName(String ressourceName) {
		this.ressourceName = ressourceName;
	}

	public String getFieldNamae() {
		return fieldNamae;
	}

	public void setFieldNamae(String fieldNamae) {
		this.fieldNamae = fieldNamae;
	}

	public Object getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(Object fieldValue) {
		this.fieldValue = fieldValue;
	}
	
	
	
}