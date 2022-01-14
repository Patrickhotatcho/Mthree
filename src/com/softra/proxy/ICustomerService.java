package com.softra.proxy;
import com.softra.bankingapp.*;

import java.util.List;

public interface ICustomerService {
	void saveCustomers(List<Customer> ctrs);
	void modifyCustomers(List<Customer> ctrs);
}
