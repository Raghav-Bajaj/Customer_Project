package com.custapp.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.customerApp.dao.Customer;
import com.customerApp.dao.CustomerDao;
import com.customerApp.service.CustomerServiceImpl;
@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {


	private CustomerDao customerDao;
	
	@InjectMocks
	private CustomerServiceImpl customerService;
	
	private Customer customer;
	@BeforeEach
	void setUp() throws Exception {
		customer=new Customer(9,"raj","male","sinle","noida","apcdefshnfhg.jpg");
	}

	@DisplayName("service layer test for insert operation")
	@Test
	void givenCustomerObject_whenSaved_thenGetSavedObject() {
		when(customerDao.save(customer)).thenReturn(customer);
		
		Customer savedCust= customerService.addCust(customer);
		
		assertThat(savedCust).isNotNull();
		
	}

	@DisplayName("service layer test for insert operation")
	@Test
	void givenCustomerList_whenGetAllCustomer_thenGetCustomerList() {
		
		Customer c1 = new Customer("raj","male","sinle","noida","apcdefshnfhg.jpg");
		 Customer c2 = new Customer("raj","male","sinle","noida","apcdefshnfhg.jpg");
		List<Customer> customers=new ArrayList<Customer>();
		customers.add(c1);
		customers.add(c2);
		
		when(customerDao.findAll()).thenReturn(customers);
		
		
		
		List<Customer> cust2=customerService.getAllCust();
		
	
		
		assertThat(cust2).isNotNull();
		assertThat(cust2.size()).isEqualTo(2);
		
		
	}
	
	@AfterEach
	void tearDown() throws Exception {
		customer=null;
	}


}
