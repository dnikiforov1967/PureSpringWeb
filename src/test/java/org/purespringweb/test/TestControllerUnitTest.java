package org.purespringweb.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.servlet.ServletContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.purespringweb.config.RootConfig;
import org.purespringweb.config.WebAppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

/**
 *
 * @author dnikiforov
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({
	@ContextConfiguration(classes = RootConfig.class)
	,
	@ContextConfiguration(classes = WebAppConfig.class)
})
public class TestControllerUnitTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	private void verifyRootWacSupport() {

		ApplicationContext parent = wac.getParent();
		assertNotNull(parent);
		assertTrue(parent instanceof WebApplicationContext);
		WebApplicationContext root = (WebApplicationContext) parent;

		ServletContext childServletContext = wac.getServletContext();
		assertNotNull(childServletContext);
		ServletContext rootServletContext = root.getServletContext();
		assertNotNull(rootServletContext);
		assertSame(childServletContext, rootServletContext);

		assertSame(root, rootServletContext.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE));
		assertSame(root, childServletContext.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE));
	}

	public TestControllerUnitTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		verifyRootWacSupport();
	}

	@After
	public void tearDown() {
	}
	
	@Test
	public void dogTest() throws Exception {
		this.mockMvc.perform(post("/test/create/dog").accept(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isCreated())
			.andExpect(content().string("{\"type\":\"Canis\"}"));		
	}
        
	@Test
	public void catTest() throws Exception {
		this.mockMvc.perform(post("/test/create/cat").accept(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isNotFound())
			.andExpect(forwardedUrl("/WEB-INF/views/specialError.jsp"));		
	}        

}
