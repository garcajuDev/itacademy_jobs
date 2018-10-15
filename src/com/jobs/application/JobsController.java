package com.jobs.application;

import java.util.ArrayList;
import java.util.List;

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
	
	public void createVolunteer(String name, String address, String phone, String description) throws Exception{
		Volunteer vol = new Volunteer(name, address, phone, description, PaymentFactory.createPaymentRateVolunteer());
		repository.addMember(vol);
	}

	public void payAllEmployeers() {
		ArrayList<AbsStaffMember> employeers = (ArrayList<AbsStaffMember>) repository.getAllMembers();
		for (AbsStaffMember member : employeers) member.pay();
	}

	public String getAllEmployees() {
		List<AbsStaffMember> employeers = repository.getAllMembers();
		String emp = "";
		for(AbsStaffMember employee: employeers) emp += employee.toString() + "\n";		
		
		return emp;
	}

}
