/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.purespringweb.config;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.purespringweb.converter.ComplexAccountConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author dnikiforov
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"org.purespringweb.beans.web"})
public class WebAppConfig implements WebMvcConfigurer {

    private final static Logger LOG = Logger.getLogger(WebAppConfig.class.getName());

    @Bean
    public ViewResolver viewResolver() {
        LOG.log(Level.INFO, "ViewResolver to instantiate");
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        //Interface has default implementation
        WebMvcConfigurer.super.addFormatters(registry);
        registry.addConverter(new ComplexAccountConverter());
    }

    @Bean(name = "simpleMappingExceptionResolver")
    public SimpleMappingExceptionResolver
            createSimpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver r
                = new SimpleMappingExceptionResolver();

        Properties exceptionsToViews = new Properties();
        exceptionsToViews.setProperty("NotFoundSuchTypeException", "specialError");
        r.setExceptionMappings(exceptionsToViews);  // None by default
        
        Properties viewsToStatus = new Properties();
        viewsToStatus.setProperty("specialError",String.valueOf(HttpStatus.NOT_FOUND.value()));        
        r.setStatusCodes(viewsToStatus);
        r.setDefaultErrorView("error");    // No default
        r.setExceptionAttribute("ex");     // Default is "exception"
        return r;
    }

}
