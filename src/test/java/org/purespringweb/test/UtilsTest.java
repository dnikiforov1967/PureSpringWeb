/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.purespringweb.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.test.util.ReflectionTestUtils;

/**
 *
 * @author dima
 */
public class UtilsTest {
    
    private static class TestClass {
        private Integer i = 0;

        public Integer getI() {
            return i;
        }
        
        public void mess(Long l) {
            System.out.println("Long");
        }
        
        public void mess(Object l) {
            System.out.println("Object");
        }        
        
    }
    
    public UtilsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {
        TestClass tc = new TestClass();
        assertEquals(new Integer(0), tc.getI());
        ReflectionTestUtils.setField(tc, "i", 10);
        assertEquals(new Integer(10), tc.getI());
        int x = 3;
        tc.mess(x);
    }
}
