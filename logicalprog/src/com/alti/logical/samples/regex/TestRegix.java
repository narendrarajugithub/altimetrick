package com.alti.logical.samples.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegix {

	public static void main(String[] args) {
		// testdateRegex();
		testEmailRegex();
	}

	public static void testdateRegex() {
		String date = "10/31/2024";
		String regex = "(0?[1-9]|1[0-2])[\\/|\\-](0?[1-9]|[12][0-9]|[3][01])[\\\\/|\\\\-](\\d{4})";
		Pattern p = Pattern.compile(regex);
		Matcher match = p.matcher(date);

		if (match.matches()) {
			System.out.println("valid");
		}

	}

	public static void testEmailRegex() {
		String email = "narendra@gmail.com";

		String regex = "([a-zA-Z0-9_]+)[@]([a-zA-Z]+)[.]([a-z]+)";

		Pattern p = Pattern.compile(regex);
		Matcher match = p.matcher(email);
		if (match.matches()) {
			System.out.print("valid");
		} else {
			System.out.println("not avalid");
		}

	}
	
	
}
