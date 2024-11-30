package com.alti.logical.samples.accessmodi;

import java.io.FileNotFoundException;
import java.io.IOException;

public class B extends A {
	public int k = 0;

	public void m1() throws ArrayIndexOutOfBoundsException {
		/*
		 * throwing Checked/compiletime exception(FileNotFoundException) if parent throws runtime/unchecked is
		 * illegal
		 */
		System.out.println("executed child method");
	}

	public void m2() {
		System.out.println("child m2");
	}

	public static void main(String[] args) throws FileNotFoundException {
		A a = new B();
		a.m2();
	System.out.println(a.k);	
	//	a.m1();
		System.out.println(a.k);

	}
}
