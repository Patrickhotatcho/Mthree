package com.softra.proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.softra.bankingapp.Customer;

@Component(value="dao")
public class CustomerDao implements ICustomer {
	
	@Autowired
	private JdbcTemplate template;
	@Override
	public void saveCustomer(Customer c) {
		String insert = "INSERT INTO customer VALUES(?,?,?,?,?,?)";
		template.update(insert,c.getCustomerId(),c.getName(),c.getAge(),
				+c.getMobileNumber(),c.getAadHarNumber(),c.getIsSeniorCitizen());

	}

	@Override
	public void modifyCustomer(Customer c) {

	}
}


