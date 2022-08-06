package com.customerApp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customerApp.dao.Customer;
import com.customerApp.dao.CustomerDao;
import com.customerApp.exception.CustomerNotFoundException;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	CustomerDao customerDao;
	
	@Autowired
	public CustomerServiceImpl(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public List<Customer> getAllCust() {
		return customerDao.findAll();
	}

	@Override
	public Customer getCustById(int id) {
		Customer customer = customerDao.findById(id).orElseThrow(() -> new CustomerNotFoundException());
		return customer;
	}

	@Override
	public Customer deleteCust(int id) {
		Customer customer = getCustById(id);
		customerDao.delete(customer);
		return customer;
	}

	@Override
	public List<Customer> findCustByName(String name) {
		return null;
	}

	@Override
	public Customer addCust(Customer cust) {
		return customerDao.save(cust);
	}

	@Override
	public Customer updateCustById(int id, Customer cust) {
		Customer customer = getCustById(id);
		customer.setCust_address(cust.getCust_address());
		customer.setCust_gender(cust.getCust_gender());
		customer.setCust_martial_status(cust.getCust_martial_status());
		customer.setCust_name(cust.getCust_name());
		customerDao.save(customer);
		return customer;
	}

	

}
