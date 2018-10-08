/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.purespringweb.pojo.exception;

/**
 *
 * @author dnikiforov
 */
public class NotFoundSuchTypeException extends RuntimeException {

	public NotFoundSuchTypeException() {
	}

	public NotFoundSuchTypeException(String msg) {
		super(msg);
	}
	
}
