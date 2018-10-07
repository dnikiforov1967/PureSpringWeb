/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.purespringweb.converter;

import org.purespringweb.pojo.impl.ComplexAccount;
import org.springframework.core.convert.converter.Converter;

/**
 *
 * @author dima
 */
public class ComplexAccountConverter implements Converter<String, ComplexAccount> {

    @Override
    public ComplexAccount convert(String s) {
        final String a = s.substring(0, 3);
        final String b = s.substring(4, 7);
        final ComplexAccount acc = new ComplexAccount();
        acc.setSubId(a);
        acc.setPostId(b);
        return acc;
    }
    
}
