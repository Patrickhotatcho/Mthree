package com.softra.bankingapp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.exp.InsufficientFundsException;

public class TestBankingSystem {
	public static void displayOp(String acctName,String action, Account a) {
		System.out.println("----------------Account Operation-----------------------");
		System.out.println(acctName);
		System.out.println("Account:　" + a.getAccountNumber());
		System.out.println("Action:　"+action);
		System.out.println("Balance:　$"+a.balance);
		System.out.println("--------------------------------------------------------");
	}
	public static void displayInt(String acctName, Account a,Customer c) {
		System.out.println("----------------Interest Calculation--------------------");
		System.out.println(acctName);
		System.out.println("Account:　" + a.getAccountNumber());
		System.out.println("Balance:　$"+a.balance);;
		System.out.println("Interest:　$"+ a.calculateInterest(a, c.getIsSeniorCitizen()));
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
			String insert = "insert into customer (customerId,name,age,mobileNumber,aadHarNumber,isSeniorCitizen)"
					+ " values("+ctr.getCustomerId()+","+ctr.getName()+","+ctr.getAge()+","+ctr.getMobileNumber()+
					","+ctr.getAadHarNumber()+","+ctr.getIsSeniorCitizen()+")";
			
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}*/
	
	public static void main(String[] args) {
		
		Customer c1 = new Customer(1,"Patrick",26,1234,4321,true);
		Customer c2 = new Customer(2,"Gigi",23,2468,8642,false);
		Customer c3 = new Customer(3,"Edward",27,1359,9531,true);
		//insertCustomerToDB(c1);
		Account[] a1; 
		try {
			SavingAccount sa1 = new SavingAccount(101, true, 1);
			SavingAccount sa2 = new SavingAccount(102, false, 100);
			
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
			
			FixedDeposit fd1 = new FixedDeposit(102, 100, 1);
			FixedDeposit fd2 = new FixedDeposit(102, 100, 4);
			
			displayInt("Fixed Deposit 1", fd1, c1);
			displayInt("Fixed Deposit 2", fd2, c2);
			
		} catch (InsufficientFundsException e) {
			e.printStackTrace();
		}
		
		
	}

}
