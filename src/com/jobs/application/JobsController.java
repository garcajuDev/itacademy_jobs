package com.jobs.application;

import java.util.ArrayList;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;

public class JobsController {

	private EmployeeRepository repository = new EmployeeRepository();
	
	public JobsController(){
	}
	
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	}
	
	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee employee = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(employee);
	}

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		Employee employee = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(employee);
	}


	public void payAllEmployeers() {
		ArrayList<AbsStaffMember> employeers = (ArrayList<AbsStaffMember>) repository.getAllMembers();
		for (AbsStaffMember member : employeers) member.pay();
	}

	public String getAllEmployees() {
		ArrayList<AbsStaffMember> employeers = (ArrayList<AbsStaffMember>) repository.getAllMembers();
		String emp = "";
		for(AbsStaffMember employee: employeers) emp += employee.toString() + "\n";		
		
		return emp;
	}

	public void createVolunteer(String string, String string2, String string3, String string4) throws Exception{
		Volunteer vol = new Volunteer(string, string2, string3, string4, PaymentFactory.createPaymentRateVolunteer());
		repository.addMember(vol);
	}

	@Override
	public String toString() {
		return "JobsController [getAllEmployees()=" + getAllEmployees() + "]";
	}
}
