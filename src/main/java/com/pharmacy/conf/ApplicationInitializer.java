package com.pharmacy.conf;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ApplicationInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException 
	{
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(RootContextConfiguration.class);
		
		servletContext.addListener(new ContextLoaderListener(rootContext));
		
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(ServletContextConfiguration.class);
		
		DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
		
		ServletRegistration.Dynamic register = servletContext.addServlet("springDispatcher", dispatcherServlet);
		register.addMapping("/");
		register.setLoadOnStartup(1);
	}

}
