package com.custapp.integration;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.customerApp.dao.Customer;
import com.customerApp.dao.CustomerDao;
import com.customerApp.service.CustomerService;

import com.fasterxml.jackson.databind.ObjectMapper;
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class CustomerAppIntegrationTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
//	private CustomerService customerService;
	
//	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private ObjectMapper objectMapper;// it is used to convert java object to json
	
	
	@BeforeEach
	void setUp() throws Exception {
		customerDao.deleteAll();
	}

	@DisplayName("Integration test test for insert operation")
	@Test
	void givenCustomerObject_whenCreateCustomer_thenReturnSavedObject() throws Exception {
		Customer c1 = new Customer("raj2","male","sinle","noida","apcdefshnfhg.jpg");
		
		ResultActions response = mockMvc.perform(post("/api/customers")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(c1)));
		
		response.andDo(print())
		.andExpect((status().isCreated()))
		.andExpect(jsonPath("$.name", is(c1.getCust_name())));
		
				
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}


}
