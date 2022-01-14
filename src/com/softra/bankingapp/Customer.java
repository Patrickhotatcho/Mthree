package com.softra.bankingapp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Customer {
	private int customerId;
	private String name;
	private int age;
	private int mobileNumber;
	private int aadHarNumber;
	private boolean isSeniorCitizen;
	private SavingAccount sa;
	public List<FixedDeposit> fds;
	
	public Customer() {
		super();
	}
	
	public Customer(int customerId, String name, int age, int mobileNumber, int aadHarNumber, boolean isSeniorCitizen) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.age = age;
		this.mobileNumber = mobileNumber;
		this.aadHarNumber = aadHarNumber;
		this.isSeniorCitizen = isSeniorCitizen;
		this.sa = sa;
		this.fds = new ArrayList<FixedDeposit>();
	}

	public Account getSa() {
		return sa;
	}



	public void setSa(SavingAccount sa) {
		this.sa = sa;
	}
	public void setFixedDeposit(FixedDeposit fd) {
		this.fds.add(fd);
	}
	public void getFixedDeposit() {
		System.out.println(this.fds.toString());
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", age=" + age + ", mobileNumber="
				+ mobileNumber + ", aadHarNumber=" + aadHarNumber + "]";
	}



	public boolean getIsSeniorCitizen() {
		return isSeniorCitizen;
	}

	public void setSeniorCitizen(boolean isSeniorCitizen) {
		this.isSeniorCitizen = isSeniorCitizen;
	}

	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public int getAadHarNumber() {
		return aadHarNumber;
	}
	public void setAadHarNumber(int aadHarNumber) {
		this.aadHarNumber = aadHarNumber;
	}
	

}
