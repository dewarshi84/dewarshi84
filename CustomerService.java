package com.example.customer.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.customer.entities.Customer;

public interface CustomerService {
	
	public Page<Customer> getCustomers(Pageable page);

	public Customer getCustomer(long customerId);

	public Customer addCustomer(Customer customer);

	public Customer updateCustomer(Customer customer);

	public void deleteCustomer(long parseLong);





	

	




}
