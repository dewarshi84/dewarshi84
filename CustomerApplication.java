package com.example.customer;

import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.example.customer.dao.CustomerDao;
import com.example.customer.entities.Customer;

@SpringBootApplication
public class CustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}
	
	@Profile("trace")
	@Bean
	CommandLineRunner run(CustomerDao customerDao) 
	{
		return new CommandLineRunner() 
		{

			@Override
			public void run(String... args) throws Exception 
			{
				IntStream.rangeClosed(1, 5).forEach(i->{
					Customer customer = new Customer();
					customer.setCustomerName("customerName"+i);
					customer.setCustomerEmail("customerEmail"+i+"@gmail.com");
					customer.setCustomerMobile("customerMobile"+i);
					customer.setCustomerAddress("customerAddress");
					customerDao.save(customer);
				});
				
			}
			
		};
		
	}

}
