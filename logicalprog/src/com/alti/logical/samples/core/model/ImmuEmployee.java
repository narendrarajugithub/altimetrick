package com.alti.logical.samples.core.model;

import java.util.Objects;

public final class ImmuEmployee {
	private  final Integer age;
	private final String name;
	
	public ImmuEmployee(Integer age,String name) {
		this.age=age;
		this.name=name;
	}
	
	public Integer getAge() {
		return this.age;
	} 
	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return "ImmuEmployee [age=" + age + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImmuEmployee other = (ImmuEmployee) obj;
		return Objects.equals(age, other.age) && Objects.equals(name, other.name);
	}
	
	public static void main(String[] args) {

		ImmuEmployee emp= new ImmuEmployee(34,"Narendra");
		ImmuEmployee emp2= new ImmuEmployee(34, "Narendra");
		ImmuEmployee emp3=emp2;
		System.out.println(emp == emp2 );// false
		System.out.println(emp.equals(emp2));// true
		System.out.println(emp.hashCode()==emp2.hashCode());// true
	
		String s1= "narendra";
		String s2="narendra";
		String s3= new String("narendra");
		String s4=new String("narendra");
		String s5=s4;
		System.out.print(s1==s2);// true
		System.out.println(s3==s4);//false
		System.out.println(s1==s3);//false
		System.out.println(s1.equals(s3));//true
		System.out.println(s1.hashCode()==s3.hashCode());//true
		System.out.println(s5==s4); //true
		System.out.println(emp3==emp2); // true
		
	}
	

	enum Size{
		SMALL("Small pizza"),
		LARGE("Large pizza"),
		EXTRASMALL("Exta small pizza");
		
		private String pizzaSize;
		
		private Size(String psize) {
			this.pizzaSize=psize;
		}
		
		public String getSize() {
			return pizzaSize;
		}
	}

	

}
