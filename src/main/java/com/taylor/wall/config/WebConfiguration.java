package com.taylor.wall.config;

import org.springframework.*;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.taylor.wall.web.controller"} )
public class WebConfiguration {
	
}