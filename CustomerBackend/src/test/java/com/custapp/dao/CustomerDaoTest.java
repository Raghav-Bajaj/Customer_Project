package com.custapp.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.customerApp.dao.Customer;
import com.customerApp.dao.CustomerDao;

@DataJpaTest
class CustomerDaoTest {

	@Autowired
	private CustomerDao customerDao;

	// -------add emp ------------
	
	@DisplayName("Dao layer test for insert operation")
	@Test
	void givenCustomerObject_whenSave_thenReturnSavedObject() {
		Customer c1 = new Customer( "raj","male","sinle","noida","apcdefshnfhg.jpg");

		Customer savedCustomer = customerDao.save(c1);

		assertThat(savedCustomer).isNotNull();
		assertThat(savedCustomer.getCust_id()).isGreaterThan(0);

	}

	// -------add emp ------------
	@DisplayName("Dao layer test for getAll operation")
	@Test
	void givenCustomerList_whenFindAll_thenReturnCustomerList() {
		 Customer c1 = new Customer("raj","male","sinle","noida","apcdefshnfhg.jpg");
		 Customer c2 = new Customer("raj","male","sinle","noida","apcdefshnfhg.jpg");
		
		 customerDao.save(c1);
		 customerDao.save(c2);
		
		List<Customer> c3=customerDao.findAll();
//		
//		List<Employee> employees=new ArrayList<Employee>();
//		employees.add(employee2);
//		employees.add(employee);
//		

		assertThat(c3).isNotNull();
		assertThat(c3.size()).isEqualTo(2);

	}

	@DisplayName("Dao layer test for delete operation")
	@Test
	void givenEmployeeObject_whenDeleated_thenRemovedFromDb() {
		Customer customer = new Customer("raj","male","sinle","noida","apcdefshnfhg.jpg");

		Customer savedCustomer = customerDao.save(customer);

		customerDao.deleteById(savedCustomer.getCust_id());
		//now i want to hit db to find that emp should not be thre
		Optional<Customer> optCust= customerDao.findById(savedCustomer.getCust_id());
		
		assertThat(optCust).isEmpty();
		
	}
}
