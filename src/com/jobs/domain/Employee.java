package com.jobs.domain;

public class Employee extends AbsStaffMember {

	protected double salaryPerMonth = 0;
	protected IPaymentRate paymentRate;	

	public Employee(String name, String address, String phone, double salaryPerMonth,IPaymentRate paymentRate) throws Exception {
		super(name, address, phone);
		this.salaryPerMonth=salaryPerMonth;
		this.paymentRate=paymentRate;
		
		if(salaryPerMonth<0) throw new Exception();
		if(paymentRate==null) throw new Exception();
	}
	
	public double getSalaryPerMonth() {
		return this.salaryPerMonth;
	}

	public IPaymentRate getPaymentRate() {
		return this.paymentRate;
	}

	@Override
	public void pay() {
		this.totalPaid=this.paymentRate.pay(this.salaryPerMonth);
	}

	@Override
	public String toString() {
		return "Name:" + this.name + " | Address: " + this.address + " | Phone: " + this.phone + " | Salary: " + this.totalPaid;
	}
	
}
