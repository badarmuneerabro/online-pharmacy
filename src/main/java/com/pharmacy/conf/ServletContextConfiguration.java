package com.pharmacy.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.pharmacy.controllers")
public class ServletContextConfiguration implements WebMvcConfigurer
{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) 
	{
		System.out.println("Resource handler called..");
		registry.addResourceHandler("/images/**").addResourceLocations("WEB-INF/images/");
	}
}
