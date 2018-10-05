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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/test")
public class TestController {

	/**
	 * Method handles normal welcome request
	 * 
	 * @param model
	 * @return 
	 */
	@GetMapping(path="/welcome")
	public String makeHelloResponse(ModelMap model) {
		model.addAttribute("nameOfResponder", "Stranger");
		return "welcome";
	}	
	
	@PostMapping(path="/create/{type}")
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
