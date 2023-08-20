package com.simha.signup.repository;

import java.util.List;

import com.simha.signup.dto.Customer;


public interface CustomerDAO {
	Customer Login(String email,String pass);
	String saveCustomer(Customer customer);
	String updateCustomer(Customer customer);
	Customer getCustomerById(int id);
	List<Customer> getAllCustomer();
	String deleteCustomerById(int id);
}
