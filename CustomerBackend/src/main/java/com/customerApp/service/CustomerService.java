package com.customerApp.service;

import java.util.List;

import com.customerApp.dao.Customer;

public interface CustomerService {
	public List<Customer> getAllCust();

	public Customer getCustById(int id);

	public Customer deleteCust(int id);

	public List<Customer> findCustByName(String name);

	public Customer addCust(Customer cust);

	public Customer updateCustById(int id, Customer customer);
}
