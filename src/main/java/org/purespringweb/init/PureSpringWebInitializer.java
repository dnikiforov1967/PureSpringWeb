/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.purespringweb.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.purespringweb.config.RootConfig;
import org.purespringweb.config.WebAppConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author dnikiforov
 */
public class PureSpringWebInitializer implements WebApplicationInitializer {

	private WebApplicationContext createRootApplicationContext() {
		final AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(RootConfig.class);
		rootContext.refresh();
		return rootContext;
	}	
	
	private WebApplicationContext createWebApplicationContext() {
		final AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.register(WebAppConfig.class);
		final WebApplicationContext root = createRootApplicationContext();
		webContext.setParent(root);
		//DO NOT DO REFRESH - it's DispatcherServlet responsibility
		return webContext;
	}
	
	@Override
	public void onStartup(ServletContext sc) throws ServletException {

		//WebApplicationContext root = createRootApplicationContext();
		//This in fact sets root context as the parameter in ServletContext
		//when context is being loaded
		//sc.addListener(new ContextLoaderListener(root));
		
		//We can set up Root context explicitly due to internal logic of
		//DispatcherServlet initialization
		//In this case we do not needed ContextLoaderListener - as we do not required
		WebApplicationContext web = createWebApplicationContext();
		
        ServletRegistration.Dynamic appServlet = 
          sc.addServlet("mvc", new DispatcherServlet(web));
		appServlet.addMapping("/app/*");
        appServlet.setLoadOnStartup(1);

	}
	
}
