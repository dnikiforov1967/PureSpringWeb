/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.purespringweb.beans.web.rest;

import java.util.Set;
import org.purespringweb.beans.root.core.interfaces.FileHandlerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author dnikiforov
 */
@Controller
@RequestMapping("/hello")
public class WelcomeController {
	
	@Autowired
	private FileHandlerInterface fileHandler;
	
	@RequestMapping(method = RequestMethod.GET)
	public String makeHelloResponse(ModelMap model) {
		final Set<String> namesOfFiles = fileHandler.namesOfFiles("/root", "zoo");
		final String name = namesOfFiles.iterator().next();
		model.addAttribute("nameOfResponder", name);
		return "welcome";
	}
}
