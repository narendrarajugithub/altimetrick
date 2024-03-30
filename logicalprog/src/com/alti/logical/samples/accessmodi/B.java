package com.alti.logical.samples.accessmodi;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class B extends A{
	//public int k=0;
	public void m1() throws NumberFormatException {
		/* throwing Checked exception(FileNotFoundException) if parent throws runtime is illegal*/
		System.out.println("executed child method");
	}

	public void m2() {
		
	}
	
	
	public static void main(String[] args) {
		A a= new B();
		a.m1();
		System.out.println(a.k);
		
	List<Integer> list =	Arrays.asList(12,12,11);
		
	Set<Integer> hashset  = new HashSet<>();
	
	
	list.stream().filter(e->hashset.add(e)).forEach(System.out::println);
	
	}
}
