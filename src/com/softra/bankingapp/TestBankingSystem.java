package com.softra.bankingapp;
import com.softra.*;
import java.sql.Connection;
import com.softra.proxy.IAccountService;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.exp.InsufficientFundsException;
import com.softra.proxy.AccountService;
import com.softra.proxy.ICustomerService;


class FixedDepositComparator implements Comparator<FixedDeposit>{
	@Override
	public int compare(FixedDeposit fd1, FixedDeposit fd2) {
		
		return Integer.compare(fd1.getAccountNumber(),fd2.getAccountNumber());
	}
}
public class TestBankingSystem {
	public static void displayOp(String acctName,String action, Account a) {
		System.out.println("----------------Account Operation-----------------------");
		System.out.println(acctName);
		System.out.println("Account: " + a.getAccountNumber());
		System.out.println("Action: "+action);
		System.out.println("Balance: $"+a.balance);
		System.out.println("--------------------------------------------------------");
	}
	public static void displayInt(String acctName, Account a,Customer c) {
		System.out.println("----------------Interest Calculation--------------------");
		System.out.println(acctName);
		System.out.println("Account: " + a.getAccountNumber());
		System.out.println("Balance: $"+a.balance);;
		System.out.println("Interest: $"+ a.calculateInterest(a, c.getIsSeniorCitizen()));
		System.out.println("--------------------------------------------------------");
	}
	/*
	public static void insertCustomerToDB(Customer ctr) {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Type 4 Driver succesfully loaded into memory");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3310/bankingsystem", "root", "Password");
			System.out.println(con);
			Statement stmt = con.createStatement();
			//String delete = "DELETE FROM customer";
			//stmt.executeUpdate(delete);
			String insert = "insert into customer (customerId,name,age,mobileNumber,aadHarNumber,isSeniorCitizen)"
					+ " values("+ctr.getCustomerId()+",'"+ctr.getName()+"',"+ctr.getAge()+","+ctr.getMobileNumber()+
					","+ctr.getAadHarNumber()+","+ctr.getIsSeniorCitizen()+")";
			//String insert = "insert into customer (customerId) value("+ctr.getCustomerId()+")";
			stmt.executeUpdate(insert); 
		}catch (SQLException e) {
			System.out.println("Insert Duplicated");
			//e.printStackTrace();
		}catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
	}*/
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("ac.xml");
		ICustomerService Cservice = context.getBean("Cservice",ICustomerService.class);
		IAccountService Aservice = context.getBean("Aservice",IAccountService.class);
		List<Customer> ctrList = new ArrayList<Customer>();
		Customer c1 = new Customer(119,"Patrick",26,1234,4321,true);
		Customer c2 = new Customer(120,"Gigi",23,2468,8642,false);
		Customer c3 = new Customer(121,"Edward",27,1359,9531,true);
		ctrList.add(c1);
		ctrList.add(c2);
		ctrList.add(c3);
		Cservice.saveCustomers(ctrList);
		
		//insertCustomerToDB(c1);
		//insertCustomerToDB(c2);
		//insertCustomerToDB(c3);
		List<Account> acctList = new ArrayList<Account>();
		try {
			SavingAccount sa1 = new SavingAccount(115, true, 1);
			SavingAccount sa2 = new SavingAccount(116, false, 100);
			acctList.add(sa1);
			acctList.add(sa2);

			c1.setSa(sa1);
			c1.setSa(sa2);
			sa1.deposit(100);
			displayOp("Saving Account 1","Deposit",sa1);
			sa1.withdraw(10);
			displayOp("Saving Account 1","Withdraw",sa1);
			sa2.deposit(50);
			displayOp("Saving Account 2","Deposit",sa2);
			sa2.withdraw(10);
			displayOp("Saving Account 2","Withdraw",sa2);
			
			displayInt("Saving Account 1", sa1, c1);
			displayInt("Saving Account 2", sa2, c2);
			
			FixedDeposit fd1 = new FixedDeposit(117, 100, 1);
			FixedDeposit fd2 = new FixedDeposit(118, 100, 4);
			displayInt("Fixed Deposit 1", fd1, c1);
			displayInt("Fixed Deposit 2", fd2, c2);
			
			acctList.add(fd1);
			acctList.add(fd2);
			Aservice.saveAccounts(acctList);
			c1.setFixedDeposit(fd1);
			c1.setFixedDeposit(fd2);
			//Collections.sort(c1.fds,new FixedDepositComparator());
			c1.getFixedDeposit();
			
		} catch (InsufficientFundsException e) {
			e.printStackTrace();
		}
		
		
	}

}
