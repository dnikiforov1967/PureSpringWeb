/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.purespringweb.beans.web.rest;

import org.purespringweb.pojo.exception.NotFoundSuchTypeException;
import org.purespringweb.pojo.impl.Dog;
import org.purespringweb.pojo.interfaces.Animal;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author dnikiforov
 */
@Controller
@RequestMapping("/secondtest")
public class SecondTestController {

	@PostMapping(path = "/create/{type}")
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public Animal createAnimal(@PathVariable("type") String type) {
		if ("dog".equals(type)) {
			return new Dog();
		} else {
			throw new NotFoundSuchTypeException();
		}
	}

}
