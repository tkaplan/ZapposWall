package com.taylor.wall.config;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {JPAConfiguration.class,RESTConfiguration.class,WebConfiguration.class} )
public class WebDomainIntegrationTest {
	private MockMvc mockMvc;

	@Autowired
	WebApplicationContext webApplicationContext;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testRequestMappingOnControlls() throws Exception {
		
		// Check that we can get home page
		mockMvc.perform(get("/"))
			   .andExpect(status().isOk());

		// Check that mapping works
		mockMvc.perform(get("/login/"))
			   .andExpect(status().isOk());
	}
}