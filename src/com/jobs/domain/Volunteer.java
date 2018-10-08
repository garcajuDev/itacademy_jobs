package com.jobs.domain;

public class Volunteer extends AbsStaffMember {
	
	protected String description;
	protected double salaryPerMonth = 0;
	protected IPaymentRate paymentRate;	

	public Volunteer(String name, String address, String phone, String description, IPaymentRate paymentRate) throws Exception {
		super(name, address, phone);
		this.description = description;
		this.paymentRate = paymentRate;
		
		if(paymentRate==null) throw new Exception();
	}
	
	@Override
	public void pay() {
		totalPaid=this.paymentRate.pay(salaryPerMonth);
	}
	
	@Override
	public String toString() {
		return "Name:" + this.name + " | Address: " + this.address + " | Phone: " + this.phone + 
				" | Description: " + this.description +  " | Salary: " + salaryPerMonth;
	}

}
