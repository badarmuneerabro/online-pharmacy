package com.pharmacy.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = {"com.pharmacy.services", "com.pharmacy.repos"})
public class RootContextConfiguration 
{
	@Bean
	public ViewResolver getViewResolver()
	{
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/view/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}
}
