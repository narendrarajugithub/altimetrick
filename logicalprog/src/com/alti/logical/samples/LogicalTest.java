package com.alti.logical.samples;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class LogicalTest {

	public static void main(String[] args) {
		//splitStringRgx();
		// stringLexograpical();
		// withoutSort();
		// febnoice();
		// stringRevwithSpaceCondotion();
		// IsAnagram();
		// sumDigit();
		// swapTwoNumbers(5, 9); /** Swap two numbers without using third variable **/
		// BigestOfThreeNumber(10, 10, 1); /** finding BigestOfThreeNumber **/
		// stringToDate("2017-07-25");
		// leapyearOrNot(1804);
		// reverceNumber(125);
		// amstrong(153l);
		// charectorOrNot('a');
		// coutOfDigitsNumber(1547);
		// numberOfDigits(000054376);

		/*
		 * int[] num = { 13, 17, 15}; LargestNumber(num);
		 */
		// findDuplcateChars();
		StrRev();
	}
	
	public static void StrRev() {
		String name = "NarendraRaju";
		int len = name.length();
		
		for(int i=0 ;i<len-1;i++) {
			System.out.print(name.charAt(len-i-1));
		}
		
		
	}

	public static void splitStringRgx() {
		String str = "";
		String pattern = "[^a-zA-Z]";

		String[] str_arr = str.trim().split(pattern);

		System.out.println(Arrays.asList(str_arr).size());
		System.out.println(Arrays.asList(str_arr));

		for (String s : Arrays.asList(str_arr)) {
			if (!s.isEmpty()) {
				System.out.println(s);
			} else {
				System.out.println(0);
			}

		}
		// System.out.println();

	}

	public static void stringLexograpical() {
		String s = "ASDFHDSFHsdlfhsdlfLDFHSDLFHsdlfhsdlhkfsdlfLHDFLSDKFHsdfhsdlkfhsdlfhsLFDLSFHSDLFHsdkfhsdkfhsdkfhsdfhsdfjeaDFHSDLFHDFlajfsdlfhsdlfhDSLFHSDLFHdlfhs";
		int k = 30;
		String small = s.substring(0, k);
		String larger = s.substring(0, 3);

		for (int i = 0; i + 3 <= s.length(); i++) {
			String sub = s.substring(i, i + 3);

			if (sub.compareTo(small) < 0) {
				small = sub;
			}
			if (sub.compareTo(larger) > 0) {
				larger = sub;
			}

		}
		System.out.println(small);
		System.out.println(larger);
	}

	public static void withoutSort() {
		List<Integer> numbers = Arrays.asList(2, 3, 4, 1, 5);

		int k = 2;// size for sub array
		int max = 0;
		int sum = 0;
		int inc = 1; // flag for size count
		List<List<Integer>> supera = new ArrayList<>();
		List<Integer> subarr = new ArrayList<>();
		for (int v = 0; v < numbers.size(); v++) {
			sum = sum + numbers.get(v);
			subarr.add(numbers.get(v));
			if (inc++ % k == 0) {
				if (max < sum) {
					max = sum;
					supera = new ArrayList<>();
					supera.add(subarr);
				}
				inc = 1;
				sum = 0;
				v = v - (k - 1);
				subarr = new ArrayList<>();
			}

		}
		System.out.println(supera);
	}

	public static void usingSort() {

		List<Integer> numbers = Arrays.asList(2, 1, 5, 1, 3, 2);

		List<Integer> ordernumbers = numbers.stream().sorted((o1, o2) -> {
			return o2.compareTo(o1);

		}).collect(Collectors.toList());

		int t = 1;
		int size = 3;
		List<List<Integer>> added = new ArrayList<>();
		List<Integer> subList = new ArrayList<>();

		for (Integer e : ordernumbers) {

			subList.add(e);
			if (t++ % size == 0) {
				added.add(subList);
				subList = new ArrayList<>();
				t = 1;
			}

		}

		Optional<List<Integer>> fin = added.stream().findFirst();
		List<Integer> list = fin.get();
		Integer sum = list.stream().reduce(0, Integer::sum);

		System.out.println(list + ": " + sum);
	}

	public static void febnoice() {
		int a = 0;
		int b = 1;
		int c = 0;

		for (int i = 0; i < 5; i++) {
			System.out.println(a);
			c = a + b; // 1 = 0 1
			b = a;
			a = c;

		}

	}

	public static void stringRevwithSpaceCondotion() {
		String str = "i am in meeting";

		String[] inStrarr = str.split("");
		List<Integer> spaceposition = new ArrayList<>();
		int index = 0;
		String res = "";
		String str2 = "";
		for (int i = inStrarr.length - 1; i >= 0; i--) {

			if (inStrarr[inStrarr.length - 1 - i].equals(" ")) {
				spaceposition.add(inStrarr.length - 1 - i);
			}

			res = res + inStrarr[i];
		}

		String[] revarr = res.split(" ");
		for (String s : revarr) {
			str2 = str2 + s;
		}
		List<String> revarrl = Arrays.asList(str2.split(""));
		List<String> finallist = new ArrayList<>();
		finallist.addAll(revarrl);
		for (int i : spaceposition) {
			if (i != 0)
				finallist.add(i, " ");
		}
		System.out.println(finallist);

	}

	public static void IsAnagram() {
		String s1 = "Hello";
		String s2 = "hello";
		String[] starr = s1.toLowerCase().split("");
		String[] starr2 = s2.toLowerCase().split("");
		List<String> strList = Arrays.asList(s1.split(""));

		Arrays.sort(starr);
		Arrays.sort(starr2);
		boolean istrue = false;

		if (starr.length == starr2.length)
			for (int i = 0; i < starr2.length; i++) {
				if (!starr[i].equalsIgnoreCase(starr2[i])) {
					istrue = false;
					break;
				}
				istrue = true;
			}

		System.out.println(istrue);

	}

	// total sum of any pair from the array
	public static void sumDigit() {
		List<Integer> inputList1 = Arrays.asList(4, 5, 7, 11, 9, 13, 8, 1, 2);
		List<Integer> inputList = inputList1.stream().sorted().collect(Collectors.toList());

		List<List<Integer>> resultList = new ArrayList<>();

		for (int i = 0; i < inputList.size(); i++) {

			for (int j = 1; j < inputList.size(); j++) {

				if (inputList.get(i) + inputList.get(j) == 20) {
					List<Integer> sumList = new ArrayList<>();
					sumList.add(inputList.get(i));
					sumList.add(inputList.get(j));
					resultList.add(sumList);
					inputList.remove(j);
					inputList.remove(i);
				}

			}

		}
		System.out.println(resultList);

	}

	public static void findDuplcateChars() {

		String str = "narendrau";
		char[] chararr = str.toCharArray();

		Set<Character> set = new LinkedHashSet<>();

		for (int i = 0; i < chararr.length - 1; i++) {
			for (int j = 1; j < chararr.length; j++) {
				if (chararr[i] == chararr[j]) {
					set.add(chararr[i]);
				}
			}

		}
		System.out.println(set);

	}

	public static void LargestNumber(int[] numbers) {
		int max = numbers[0];
		int second = numbers[1];
		// Arrays.sort(numbers);

		if (max < second) {
			int temp = second;
			second = max;
			max = temp;
		}

		for (int k : numbers) {
			if (k > max) {
				max = k;
			} else if (k > second && k != max) {
				second = k;
			}

		}
		System.out.println("Second Max " + second);
		System.out.println("First Max" + max);

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

		} else {
			leap = false;
		}

		if (leap) {
			System.out.println("Leap year");
		} else {
			System.out.println("Not leap Year");
		}

	}

	public static void reverceNumber(int number) {
		int givennumber = number; // 112
		int reminder = 0;
		int rev = 0;
		System.out.println(givennumber);
		while (givennumber != 0) {

			reminder = givennumber % 10; // 2
			// temp = reminder; // 2
			rev = rev * 10 + reminder;
			givennumber = givennumber / 10; // 11

		}
		System.out.println(rev);

	}

	public static void amstrong(Long number) {

		int n = 0;
		Long amstrong = number;
		while (number != 0) {
			n++;
			number = number / 10;
		}
		System.out.println(n);
		Long reminder = 0l;
		Long result = 0l;
		while (amstrong != 0) {

			reminder = amstrong % 10;
			result = (long) (result + Math.pow(reminder, n));
			amstrong /= 10;

		}
		System.out.println(result);
	}

	public static void charectorOrNot(char c) {

		/*
		 * 
		 * // given charecter is alphabet or not if( (c>='a'&& c <= 'z') || c >= 'A'&&
		 * c<='Z' ) { System.out.println(c+" is Charector"); }else
		 * System.out.println(c+" is Not a Charector");
		 */

		// is Alpahabet or not

		String result = Character.isAlphabetic(c) ? "Charector" : "Not charecter";
		System.out.println(result);

	}

	public static void coutOfDigitsNumber(int number) {

		// 13

		int reminder = 0;
		// int sum=0;

		reminder = number % 9;

		if (reminder == 0) {
			System.out.println(reminder);
		} else {
			System.out.println(reminder);
		}

	}

	// g=find the digits from number 00000531 result as 3
	public static void numberOfDigits(int number) {

		int count = 0;
		while (number != 0) {
			number /= 10;
			++count;
		}
		System.out.println(count);

	}

	public static void commen(String[] strarr) {
		int min = strarr[0].length();
		int max = strarr[1].length();
		int temp = 0;

		if (min > max) {
			temp = max;
			max = min;
			min = temp;
		}

		for (String s : strarr) {
			int size = s.length();
			if (size < min) {
				min = size;
			}
		}

		List<String> intputstring = Arrays.asList(strarr);
		int shortlen = min;
		String result = "";
		String input = strarr[0];

		List<String> resultlist = new ArrayList<>();

		for (int i = 1; i <= shortlen; i++) {// the required substring need to evaluate
			for (int j = 0; j < strarr.length; j++) {// iterating one by one element

				String substr = input.substring(0, i);
				if (intputstring.get(j).startsWith(substr)) {// checking each element
					result = substr;
				}
			}
		}
		System.out.println(result);
	}

}
