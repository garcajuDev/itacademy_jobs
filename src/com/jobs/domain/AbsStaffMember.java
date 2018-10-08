package com.jobs.domain;

public abstract class AbsStaffMember {

	protected int id = 0;
	protected String name;
	protected String address;
	protected String phone;
	protected double totalPaid=0;

	private static int COUNTER_MEMBERS = 1;

	public AbsStaffMember(String name, String address, String phone) throws Exception {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.id = COUNTER_MEMBERS;
		COUNTER_MEMBERS++;
		
		if (name.equals(""))
			throw new Exception();
		if (address.equals(""))
			throw new Exception();
		if (phone.equals(""))
			throw new Exception();
	}
	

	public String getName() {
		return this.name;
	}

	public String getAddress() {
		return this.address;
	}


	public String getPhone() {
		return this.phone;
	}

	public abstract void pay();
}
