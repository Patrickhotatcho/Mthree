package com.softra.proxy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.softra.bankingapp.Customer;

@Component(value="Cservice")
public class CustomerService implements ICustomerService {
	
	@Autowired
	private CustomerDao dao;
	@Override
	public void saveCustomers(List<Customer> ctrs) {
		System.out.println("Inside Service layer "+this.dao);//Logging statement
		for(Customer c:ctrs) {
			dao.saveCustomer(c);
		}

	}

	@Override
	public void modifyCustomers(List<Customer> ctrs) {
		// TODO Auto-generated method stub

	}

}
