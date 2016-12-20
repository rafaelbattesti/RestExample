package com.rafaelbattesti.testcontroller;
import com.rafaelbattesti.controller.GreetingController;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * This class runs as a JUnit test using the Mockito runner
 * @author rafaelbattesti
 */
@RunWith(MockitoJUnitRunner.class)
public class GreetingControllerTest {
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		GreetingController gc = new GreetingController();
		mockMvc = MockMvcBuilders.standaloneSetup(gc).build();
	}
	
	@Test
	public void testRest200() {
		String route = "/greeting";
		try {
			mockMvc.perform(get(route)).andExpect(status().isOk());
		} catch (Exception e) {
			assertTrue(false);
		}
	}
	
	@Test
	public void testRest404() {
		String route = "/";
		try {
			mockMvc.perform(get(route)).andExpect(status().isNotFound());
		} catch (Exception e) {
			assertTrue(false);
		}
	}
	
	@Test
	public void testMediaType() {
		String route = "/greeting";
		String type = "application/json;charset=UTF-8";
		try {
			mockMvc.perform(get(route)).andExpect(content().contentType(type));
		} catch (Exception e) {
			assertTrue(false);
		}
	}
}
