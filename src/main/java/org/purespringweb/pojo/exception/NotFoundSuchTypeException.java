/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.purespringweb.pojo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author dnikiforov
 */
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Type")
public class NotFoundSuchTypeException extends RuntimeException {
	
}
