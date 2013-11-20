package com.taylor.wall.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.webmvc.RepositoryRestMvcConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Import({ RepositoryRestMvcConfiguration.class })
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.taylor.wall.web.controller"} )
public class WebConfiguration {
	
}