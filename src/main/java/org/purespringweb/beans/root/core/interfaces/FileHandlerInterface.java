/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.purespringweb.beans.root.core.interfaces;

import java.util.Set;

/**
 *
 * @author dnikiforov
 */
public interface FileHandlerInterface {
	Set<String> namesOfFiles(String folder, String type);
}
