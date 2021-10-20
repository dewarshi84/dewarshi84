package com.example.customer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.entities.Customer;
import com.example.customer.services.CustomerService;

@RestController
public class CustomerController 
{
	@Autowired
     CustomerService customerSerivice;
	
	@GetMapping("/home")
	public String home() 
	{
		return "Welcome to Customer Application.";
		
	}
	
	//Get the Customers
	
	@GetMapping("/customers")
	    Page<Customer> getCustomers(Pageable page)
	{
		return customerSerivice.getCustomers(page);
		
	}
	
	

	@GetMapping("/ordered-customers")
	    Page<Customer> getOrderedCustomers(@PageableDefault(sort = "id",direction = Direction.DESC, size = 5) Pageable page)
	{
		return customerSerivice.getCustomers(page);
		
	}
	
	//Get Single Customer
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable String customerId)
	{
		return customerSerivice.getCustomer(Long.parseLong(customerId));
		
	}
	
	// Add Customer
	
	@PostMapping("/customers")
	public Customer addCustomer(@Valid@RequestBody Customer customer)
	{
		return customerSerivice.addCustomer(customer);
		
	}
	
	//Update Customer Using PUT Method
	
	@PutMapping("/customers")
	public Customer updateCustomer(@Valid@RequestBody Customer customer)
	{
		return customerSerivice.updateCustomer(customer);
	}
	
	
	//Delete the Customers
	
	@DeleteMapping("/customers/{customerId}")
	public ResponseEntity<HttpStatus>deleteCustomer(@PathVariable String customerId)
	{
		try {
			   customerSerivice.deleteCustomer(Long.parseLong(customerId));
			return new ResponseEntity<>(HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
