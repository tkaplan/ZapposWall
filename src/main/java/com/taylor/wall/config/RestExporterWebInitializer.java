package com.taylor.wall.config;

import javax.servlet.*;
import org.springframework.*;

public class RestExporterWebInitializer implements WebApplicationInitializer {
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
	    AnnotationConfigWebApplicationContext rootCtx = new AnnotationConfigWebApplicationContext();
	    rootCtx.register(
	        JPAConfiguration.class // Include JPA entities, Repositories
	    );
	    servletContext.addListener(new ContextLoaderListener(rootCtx));

	    AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
	    webCtx.register(WebConfiguration.class);

	    DispatcherServlet dispatcherServlet = new DispatcherServlet(webCtx);
	    ServletRegistration.Dynamic reg = servletContext.addServlet("rest-exporter", dispatcherServlet);
	    reg.setLoadOnStartup(1);
	    reg.addMapping("/*");
	}

}
