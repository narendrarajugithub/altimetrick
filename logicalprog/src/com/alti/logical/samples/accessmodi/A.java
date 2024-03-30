package com.alti.logical.samples.accessmodi;

import java.io.FileNotFoundException;

public class A {
	 int k=2;
	 protected int j= 5;
	
	 public void m1()throws ArithmeticException{
		System.out.println("parent m1() method ececuted");
	}
	 
	 public void m2()throws FileNotFoundException{
		 System.out.println("parent m2() method ececuted"); 
	 } 

}
