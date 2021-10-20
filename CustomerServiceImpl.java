package com.example.customer.services;

//import java.awt.print.Pageable;
//import java.util.ArrayList;
//import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.customer.dao.CustomerDao;
import com.example.customer.entities.Customer;
@Service
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	private CustomerDao customerDao;
	
	
	public CustomerServiceImpl() 
	{

	}


	public Page<Customer>getCustomers(Pageable page) {

		
		return customerDao.findAll(page);
		
	}


	@Override
	public Customer getCustomer(long customerId) {
		
	
		return customerDao.getById(customerId);
	}




	@Override
	public Customer addCustomer(Customer customer) {
		
		
		customerDao.save(customer);
		return customer;
	}




	@Override
	public Customer updateCustomer(Customer customer) {
		
		customerDao.save(customer);
		return customer;
	}


    
	@Override
	public void deleteCustomer(long parseLong) {
	
		Customer entity = customerDao.getById(parseLong);
		customerDao.delete(entity);
	}



}
