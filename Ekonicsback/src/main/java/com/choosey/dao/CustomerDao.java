package com.choosey.dao;

import com.choosey.models.Customer;

public interface CustomerDao {

	void registerCustomer(Customer customer);
	boolean isEmailUnique(String email);
}
