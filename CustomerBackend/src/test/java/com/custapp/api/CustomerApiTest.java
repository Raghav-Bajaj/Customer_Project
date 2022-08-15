package com.custapp.api;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.customerApp.api.CustomerApi;
import com.customerApp.dao.Customer;
import com.customerApp.dao.CustomerDao;
import com.customerApp.service.CustomerService;

@WebMvcTest(controllers = CustomerApi.class)
class CustomerApiTest {

	@Autowired
	private MockMvc mockMvc;
	
	//service layer
	@MockBean //add mock to spring app context 
	private CustomerService customerService;
	
	@MockBean //add mock to spring app context 
	private CustomerDao customerDao;
	
	
	@Test
	void givenListOfCustomer_whenGetAllCustomer_thenRetunListOfCustomer() throws Exception {
		Customer c1 = new Customer("raj","male","sinle","noida","apcdefshnfhg.jpg");
		Customer c2 = new Customer("raj2","male","sinle","noida","apcdefshnfhg.jpg");
		List<Customer> customers=new ArrayList<Customer>();
		customers.add(c1);
		customers.add(c2);
		
		when(customerService.getAllCust()).thenReturn(customers);
		
		ResultActions resultAction = mockMvc.perform(get("/api/customers"));
		
//		resultAction.andExpect(status().isOk()).andDo(print());
		
		resultAction.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.size()", is(customers.size())));
		
	}



}










