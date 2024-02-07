package com.alti.logical.samples;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LogicalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// swapTwoNumbers(5, 9); /** Swap two numbers without using third variable **/
		// BigestOfThreeNumber(10, 10, 1); /** finding BigestOfThreeNumber **/
		//stringToDate("2017-07-25");
		 // leapyearOrNot(1804);
		// reverceNumber(125);
		//amstrong(153l);
		//charectorOrNot('a');
		//coutOfDigitsNumber(1547);
		numberOfDigits(000054376);
	}

	public static void swapTwoNumbers(int a, int b) {
		System.out.println("a is " + a + " B is " + b);
		a = a + b; // a= 1 b=2
		b = a - b; // 3-2 b=1
		a = a - b; // 3-1

		System.out.println("a is " + a + " B is " + b);

	}

	public static void BigestOfThreeNumber(int a, int b, int c) {

		if (a >= b & b >= c) {
			System.out.println("A is big");
		} else if (b >= a & b >= c) {
			System.out.println("B is big");
		} else {
			System.out.println("c is Big");
		}

	}

	public static void stringToDate(String date) {

		String datestr = date;
		LocalDate loc_date = LocalDate.parse(datestr, DateTimeFormatter.ISO_DATE);
		System.out.println(loc_date);

	}

	public static void leapyearOrNot(int year) {
		boolean leap = false;

		if (year % 4 == 0) {

			if (year % 100 == 0) {
				if (year % 400 == 0) {
					leap = true;
				} else {
					leap = false;
				}

			} else {
				leap = true;
			}

		}else {
			leap=false;
		}
		
		if(leap) {
			System.out.println("Leap year");
		}else {
			System.out.println("Not leap Year");
		}

	}
	
	public static void reverceNumber(int number) {
		int givennumber=number; // 112
		int reminder=0;
		int temp=0;
		int rev=0;
		System.out.println(givennumber);
		while(givennumber!=0) {
		
		reminder= givennumber%10; // 2
		temp=reminder; //2
		rev=rev*10+temp;
		givennumber=givennumber/10; // 11
		
		}
		System.out.println(rev);
		
		
	}
	
	public static void  amstrong(Long number) {
		
		int n=0;
		Long amstrong =number;
		while(number!=0) {
		//number=	number%10;
			n++;
			number = number/10;
		}
		System.out.println(n);
		Long reminder=0l;
		Long result =0l;
		while(amstrong!=0) {
			
		reminder =amstrong%10;
		result = (long) (result + Math.pow(reminder, n));
		amstrong /=10;
		
		}
	System.out.println(result);
	}
	
	public static void charectorOrNot(char c) {
		
		/*
		
			// given charecter is alphabet or not
		if( (c>='a'&& c <= 'z') || c >= 'A'&& c<='Z' ) {
			System.out.println(c+" is Charector");
		}else
			System.out.println(c+" is Not a Charector");
		*/
		
		// is Alpahabet or not
		
		String result = Character.isAlphabetic(c)?"Charector":"Not charecter";
		System.out.println(result);
		
	} 
	
	
	public static void coutOfDigitsNumber(int number) {
		
		   //  13
		
		int reminder=0;
		//int sum=0;
		
			reminder =number % 9;
			
			if(reminder==0) {
				System.out.println(reminder);
			}else {
				System.out.println(reminder);
			}	
		
	}
	
	// g=find the digits from number 00000531 result as 3
	public static void numberOfDigits(int number) {
		
		int count=0;
		while(number!=0) {
			number/=10;
			++count;	
		}
		System.out.println(count);
		
	}
	

}






























































