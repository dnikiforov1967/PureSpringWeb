/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.purespringweb.validator;

import org.purespringweb.pojo.impl.Promo;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author dnikiforov
 */
public class PromoValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Promo.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		Promo obj = (Promo) target;
		if (obj.getName().equals("cat")) {
			errors.rejectValue("name", "no.cat");
		}
	}
	
}
