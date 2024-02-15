package com.alti.logical.samples.core.model;

import java.util.Objects;

public class Employee {
	
	private Integer id;
	private String name;
	private String designation;
	private Integer pincode;
	
	
	
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	public Employee(Integer id, String name, String designation) {
		//super();
		this.id = id;
		this.name = name;
		this.designation = designation;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public int hashCode() {
		return Objects.hash(designation, id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(designation, other.designation) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return " {id=" + id + ", name=" + name + ", designation=" + designation + "}";
	}

	

}
