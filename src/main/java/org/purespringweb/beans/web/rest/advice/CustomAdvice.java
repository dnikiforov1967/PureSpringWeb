/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.purespringweb.beans.web.rest.advice;

import org.purespringweb.pojo.annotation.AdviceOnException;
import org.purespringweb.pojo.exception.NotFoundSuchTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author dnikiforov
 */
@ControllerAdvice()
public class CustomAdvice {
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason = "Data have not been found")
	@ExceptionHandler(NotFoundSuchTypeException.class)
	public void handleException() {
		
	}
	
}
