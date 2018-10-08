/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.purespringweb.beans.web.rest;

import javax.servlet.http.HttpServletRequest;
import org.purespringweb.pojo.exception.NotFoundSuchTypeException;
import org.purespringweb.pojo.impl.Account;
import org.purespringweb.pojo.impl.ComplexAccount;
import org.purespringweb.pojo.impl.Dog;
import org.purespringweb.pojo.interfaces.Animal;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

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
	@GetMapping(path = "/welcome")
	public String makeHelloResponse(ModelMap model) {
		model.addAttribute("nameOfResponder", "Stranger");
		return "welcome";
	}

	@GetMapping(path = "/toparrot")
	public String makeRedirectToParrot() {
		return "redirect:/parrot.jsp";
	}

	@GetMapping(path = "/welcomeWMA/{name}")
	public String makeHelloResponseWMA(@ModelAttribute("name") String name, ModelMap model) {
		model.addAttribute("nameOfResponder", name);
		return "welcome";
	}

	@GetMapping(path = "/welcomeWMA2")
	public String makeHelloResponseWMA2(@ModelAttribute("name") String name, ModelMap model) {
		model.addAttribute("nameOfResponder", name);
		return "welcome";
	}

	@GetMapping(path = "/account/{account}")
	@ResponseBody
	public Account makeAccountResponse(@ModelAttribute("account") Account account) {
		return account;
	}

	@GetMapping(path = "/complexaccount/{account}")
	//@ResponseBody
	public String makeComplexAccountResponse(@ModelAttribute("account") ComplexAccount account) {
		return "showaccount";
	}

	@PostMapping(path = "/accept")
	public ModelAndView makeAcceptResponse(
			@RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname
	) {
		final ModelAndView model = new ModelAndView();
		model.setViewName("acceptuser");
		model.addObject("firstname", firstname);
		model.addObject("lastname", lastname);
		return model;
	}

	@GetMapping(path = "/acceptQuery")
	public ModelAndView makeAcceptQueryResponse(
			@RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname
	) {
		final ModelAndView model = new ModelAndView();
		model.setViewName("acceptuser");
		model.addObject("firstname", firstname);
		model.addObject("lastname", lastname);
		return model;
	}

	@PostMapping(path = "/create/{type}")
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public Animal createAnimal(@PathVariable("type") String type) {
		if ("dog".equals(type)) {
			return new Dog();
		} else {
			throw new NotFoundSuchTypeException("This type of animal not found");
		}
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleError(HttpServletRequest req, Exception ex) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", ex);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("error");
		if (ex instanceof NotFoundSuchTypeException) {
			mav.setStatus(HttpStatus.NOT_FOUND);
		} else {
			mav.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		}	
		return mav;
	}

}
