package com.alti.logical.samples.core;

import com.alti.logical.samples.accessmodi.A;

public class C extends A {

	public static void main(String[] args) {
		C a= new C();
		a.m1();
		System.out.println(a.j); 
		/* if k is default, a.k not visible from outside package 
		 * if j is protected in A and super to C where C c = new C() subclass can access
		 * 
		 * */
		
		D d =new D();
	//	System.out.println(d.a.j); // j, k can't be access from A class
								
	}
	
}

class D extends A {
	A a =new A();
	
	
	
}


