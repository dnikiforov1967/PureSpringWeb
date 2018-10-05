/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.purespringweb.beans.root.core.impl;

import java.util.HashSet;
import java.util.Set;
import org.purespringweb.beans.root.core.interfaces.FileHandlerInterface;
import org.springframework.stereotype.Component;

/**
 *
 * @author dnikiforov
 */
@Component
public class FileHandler implements FileHandlerInterface {

	@Override
	public Set<String> namesOfFiles(String folder, String type) {
		final HashSet<String> hashSet = new HashSet<String>();
		hashSet.add("Cheburashka");
		hashSet.add("Gena Krokodil");
		return hashSet;
	}

}
