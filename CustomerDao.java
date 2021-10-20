package com.example.customer.dao;


//import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.customer.entities.Customer;

public interface CustomerDao extends JpaRepository<Customer,Long> {



}
