package com.alti.logical.samples.core;

import java.util.stream.IntStream;

import com.alti.logical.samples.core.model.ImmuEmployee;

public class CoreSamples {
	
	public static void main(String[] args) {
		// autoBoxAndUnbox();
		
	
		
	}
	
	private static void autoBoxAndUnbox() {
		Integer num=2099990000;
		int num2=num;
		float fnum=0.01f;  //float fnum=4.01 cannot convert double to float
		double funm2= fnum;
		Double funm3 =  funm2; // Type mismatch: cannot convert from float to Double
		System.out.println(funm2); //  0.009999999776482582
		// int num2=
		
		int no =10;
	}
		
	
	

}
