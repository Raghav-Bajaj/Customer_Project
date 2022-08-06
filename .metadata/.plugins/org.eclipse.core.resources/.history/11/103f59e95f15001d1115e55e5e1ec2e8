package com.customerApp.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customerApp.dao.Customer;
import com.customerApp.service.CustomerService;

@RestController
@RequestMapping(path = "api")
@CrossOrigin()
public class CustomerApi {
	CustomerService customerService;

	@Autowired
	public CustomerApi(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping(path = "customers")
	public List<Customer> getAllCust() {
		return customerService.getAllCust();
	}

	@GetMapping(path = "customers/{id}")
	public Customer getCustByID(@PathVariable(value = "id") int id) {
		return customerService.getCustById(id);
	}

	@PostMapping(path = "customers")
	public ResponseEntity<Customer> addCust(@Valid @RequestBody Customer customer) {
		Customer cust = customerService.addCust(customer);
		return ResponseEntity.status(HttpStatus.CREATED).body(cust);
	}

	@PutMapping(path = "customers/{id}")
	public ResponseEntity<Customer> updateCust(@PathVariable(name = "id") int id,
			@Valid @RequestBody Customer customer) {
		Customer cust = customerService.updateCustById(id, customer);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(cust);
	}
	
	@DeleteMapping(path = "customers/{id}")
	public ResponseEntity<Customer> deleteCust(@PathVariable(name="id") int id){
		customerService.deleteCust(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}

}
