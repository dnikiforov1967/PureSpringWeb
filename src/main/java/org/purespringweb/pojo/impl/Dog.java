/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.purespringweb.pojo.impl;

import org.purespringweb.pojo.interfaces.Animal;

/**
 *
 * @author dnikiforov
 */
public class Dog implements Animal {

	@Override
	public String getType() {
		return "Canis";
	}
	
}
