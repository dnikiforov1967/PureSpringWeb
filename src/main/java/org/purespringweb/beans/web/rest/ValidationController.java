/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.purespringweb.beans.web.rest;

import javax.validation.Valid;
import org.purespringweb.pojo.impl.Promo;
import org.purespringweb.validator.PromoValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author dnikiforov
 */
@Controller
@RequestMapping("/validation")
public class ValidationController {
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(new PromoValidator());
	}
	
	@PostMapping
	@ResponseBody
	public String proceedValue(@RequestBody @Valid Promo promo,BindingResult result) {
		if (result.hasErrors()) {
			return "Fail";
		}
		return promo.getName();
	}
	
}
