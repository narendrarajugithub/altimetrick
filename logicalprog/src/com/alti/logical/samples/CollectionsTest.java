package com.alti.logical.samples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.alti.logical.samples.core.model.Address;
import com.alti.logical.samples.core.model.Employee;
import com.alti.logical.samples.model.Employee1;

public class CollectionsTest {

	public static void main(String[] args) {
		//getDuplicates();
		// getSamesalarfromtwoList();
		// withArray();
		// nonDuplicates();
		// collectionSortcity();
		 sortByTwofields();
		// flatmaptest();
		/// mapwithIdAndObject();
		// findFirstNonRepeatechar();
		// mapSample();
		// hashMapStream();
		// groupByTest();
		// fidDuplicates();
		// mapTest();
		// collectionSortTest();
	}

	public static void getDuplicates() {
		List<String> fruits = Arrays.asList("apple", "banana", "apple","apple");
		List<String> dupli = fruits.stream().filter(e -> Collections.frequency(fruits, e) > 1)
				.collect(Collectors.toList());

		Map<String, Long> resmap = fruits.stream().filter(e -> Collections.frequency(fruits, e) > 1)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

		resmap.entrySet().stream().filter(e -> e.getValue() > 1).distinct().map(e -> e.getKey())
				.collect(Collectors.toList()).forEach(System.out::println);
		
		Set<String> fruitsset = new HashSet<>();
		
		fruits.stream().filter(e -> !fruitsset.add(e)).distinct().collect(Collectors.toList()).forEach(System.out::println);

//System.out.println(resmap);

	}

	public static void getSamesalarfromtwoList() {

		List<Employee1> emp = new ArrayList<>();
		emp.addAll(Arrays.asList(new Employee1("narnedra", 15000), new Employee1("ram", 12000)));

		List<Employee1> emp1 = new ArrayList<>();
		emp1.addAll(Arrays.asList(new Employee1("pavan", 15000), new Employee1("ram", 12001)));

		List<Employee1> result = emp.stream()
				.filter(e -> emp1.stream().anyMatch(e2 -> e.getSalary().equals(e2.getSalary())))
				.collect(Collectors.toList());

		System.out.println(result);

	}

	public static void withArray() {
		String str = "Abchgffbhh";
		char[] charaee = str.toCharArray();

		boolean isduplicate = false;
		int len = 0;
		char[] chara = new char[charaee.length];
		for (int i = 0; i < charaee.length; i++) {

			for (int j = 1; j < charaee.length; j++) {

				if (charaee[i] == charaee[j]) {
					isduplicate = true;
					break;
				}

			}

			if (isduplicate == false) {

				chara[len] = charaee[i];
				len++;
			}
			isduplicate = false;
		}

	}

	public static void nonDuplicates() {
		String s = "narendra";

		List<String> straeeay = Arrays.asList(s.split(""));
		straeeay.stream().filter(e -> Collections.frequency(straeeay, e) == 1).forEach(System.out::println);
		Set<String> result = new HashSet<>();
		System.out.println("---------------------");
		straeeay.stream().filter(e -> !result.add(e)).collect(Collectors.toList()).forEach(System.out::print);
	}

	public static void flatmaptest() {
		List<List<Integer>> number = new ArrayList<>();

		// adding the elements to number arraylist
		number.add(Arrays.asList(1, 2));
		number.add(Arrays.asList(3, 4));
		number.add(Arrays.asList(5, 6));
		number.add(Arrays.asList(7, 8));

		number.stream().flatMap(e -> e.stream()).forEach(System.out::println);

	}

	public static void sortByTwofields() {
		List<Employee1> empList = Arrays.asList(new Employee1("ravi", 152800), new Employee1("ravi", 152000),
				new Employee1("narenda", 150000));

		List<Employee1> empres = empList.stream().sorted((o1, o2) -> {
			int n = o1.getName().compareTo(o2.getName());
			if (n != 0) {
				return n;
			}

			return o1.getSalary().compareTo(o2.getSalary());
		}).collect(Collectors.toList());

		// System.out.println(empres);
		// sort in reverse(desc) order
		empList.stream().filter(e -> e.getSalary() > 142000).sorted(Comparator.comparing(Employee1::getName).reversed())
				.collect(Collectors.toList()).forEach(System.out::println);
		

	}

	public static void findFirstNonRepeatechar() {
		String str = "narendra";
		List<String> listStr = Arrays.asList(str.split(""));
		listStr.stream().filter(e -> Collections.frequency(listStr, e) == 1).findFirst().ifPresent(System.out::print);

		String s1 = "abc";
		StringBuffer s2 = new StringBuffer("abc");
		String s3 = "abc";

		System.out.println(s1.equals(s2));
		System.out.println(s2.equals(s3));

	}

	public static void mapwithIdAndObject() {
		List<Address> emplist = Arrays.asList(new Address(500082, "Shaikpet", "TG", "Hyderabad"),
				new Address(534126, "Nelamuru", "AP", "Penumantra"),
				new Address(534120, "Toleru", "AP", "Veeravasaram"),
				new Address(534120, "Konithivada", "AP", "varavam"));

		Map<Integer, List<Address>> mapList = emplist.stream()
				.collect(Collectors.groupingBy(e -> e.getPincode(), HashMap::new, Collectors.toList()));
		System.out.println(mapList);

	}

	public static void fidDuplicates() {
		List<String> fruits1 = Arrays.asList("apple", "banana", "pinaple", "grape");
		List<String> fruits2 = Arrays.asList("mango", "pamogranade", "apple", "pinaple", "apple");

		/*
		 * Set duplicates = new HashSet<Integer>(); Stream.of(1,2,3,2).filter(e ->
		 * !duplicates.add(e)).collect(Collectors.toSet()).forEach(System.out::println);
		 */
		/*
		 * Stream.of(1,2,3,2).collect(Collectors.toMap(Function.identity(),v->
		 * 1,Integer::sum )) .forEach((k,v)->System.out.println(k +" : "+v));
		 */
		/*
		 * List numbers = Arrays.asList(1,2,3,2); numbers.stream().filter(e ->
		 * Collections.frequency(numbers,e)>1).collect(Collectors.toSet());
		 */

		/*
		 * 
		 * 
		 * // an element from the list1 occur from list2 more then once
		 * fruits1.stream().filter(f -> Collections.frequency(fruits2, f) >
		 * 1).collect(Collectors.toSet()) .forEach(System.out::println); // an element
		 * from the list1 not occurred from list2 fruits1.stream().filter(f ->
		 * Collections.frequency(fruits2, f) == 0).collect(Collectors.toSet())
		 * .forEach(System.out::println);
		 */

		// remove duplicates from the list
		fruits2.stream().distinct().forEach(System.out::println);
		Map<String, Long> numoffruits = fruits2.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));// .forEach((k, v) ->
																							// System.out.println(k + "
																							// : " + v));

		// get duplicate
		List<String> resList = numoffruits.entrySet().stream().filter(e -> e.getValue() > 1).map(e -> e.getKey())
				.collect(Collectors.toList());
		System.out.println(resList);

		ArrayList<String> diff = new ArrayList<>(fruits1);
		diff.removeAll(fruits2);
		System.out.println(diff);
		// fruits2.removeAll(fruits1) you can't perform removeAll it is unSupported
		// opration on list

	}

	public static void groupByTest() {
		List<Address> address = Arrays.asList(new Address(534126, "nelamuru", "AP", "palakollu"),
				new Address(534126, "Oduru", "AP", "palakollu"), new Address(534125, "Navuduru", "AP", "veeravasaram"));

		Map<Integer, List<String>> collect = address.stream().collect(Collectors.groupingBy(Address::getPincode,
				/* TreeMap::new , */Collectors.mapping(Address::getCity, Collectors.toList())));

		collect.entrySet().stream().map(k -> k.getKey() + " : " + k.getValue()).forEach(System.out::println);

	}

	public static void hashMapStream() {
		Map<String, Employee> employee = new HashMap<>();

		employee.put("one", new Employee(1, "narendra", "sr.SoftwareDevloper"));
		employee.put("two", new Employee(2, "ravi", "sr.SoftwareDevloper"));

		Predicate<Entry<String, Employee>> key = k -> k.getKey().equals("one");
		List<Entry<String, Employee>> collect = employee.entrySet().stream().filter(key).collect(Collectors.toList());
		Iterator iterator = collect.iterator();

		while (iterator.hasNext()) {
			Entry<String, Employee> obj = (Entry<String, Employee>) iterator.next();

			System.out.println(obj.getKey() + " : " + obj.getValue());
		}

	}

	public static void mapSample() {
		Map<String, Integer> fruitCost = new HashMap<>();
		fruitCost.put("apple", 25);
		fruitCost.put("kiwi", 30);
		fruitCost.put("Oreng", 10);

		Set fruits = fruitCost.entrySet();
		Iterator fruitIterator = fruits.iterator();

		while (fruitIterator.hasNext()) {

			Map.Entry entry = (Entry) fruitIterator.next();
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

		// using Streams

		Optional<Entry<String, Integer>> optval = fruitCost.entrySet().stream().filter(m -> m.getKey().equals("apple"))
				.findFirst();
		if (optval.isPresent()) {
			System.out.println(optval.get().getValue());
		}

		optval.ifPresent(d -> {
			System.out.print(d.getKey() + "  : " + d.getValue());
		});

	}

	public static int[] getDuplicatesStreamsToArray(int[] input) {
		return IntStream.of(input).boxed().collect(
				Collectors.collectingAndThen(Collectors.groupingBy(Function.identity(), Collectors.counting()), map -> {
					map.values().removeIf(cnt -> cnt < 2);
					return (map.keySet());
				})).stream().mapToInt(i -> i).toArray();
	}

	public static void mapTest() {
		Employee e = new Employee(1, "ram", "sr.soft");
		Map map = new HashMap<String, Employee>();
		map.put("one", e);
		map.put("two", new Employee(2, "ravi", "sr.Soft"));
		e.setName("Narendra");
		Set<String> keys = map.keySet();
		/*
		 * if try to remove after create the iterator, The hashMap throw
		 * ConcurrentModificationException. map.remove("one");
		 */
		Iterator<String> key = keys.iterator();
		while (key.hasNext()) {
			String mapkey = key.next();
			// key.remove();
			Employee emp = (Employee) map.get(mapkey);
			System.out.println(emp);
			map.remove(mapkey);

		}
	}

	public static void collectionSortTest() {

		List<Address> emplist = Arrays.asList(new Address(500082, "Shaikpet", "TG", "Hyderabad"),
				new Address(534126, "Nelamuru", "AP", "Penumantra"),
				new Address(534120, "Toleru", "AP", "Veeravasaram"),
				new Address(534120, "Konithivada", "AP", "varavam"));

		emplist.stream().sorted(
				Comparator.comparingInt(Address::getPincode).thenComparing(Comparator.comparing(Address::getCity)))
				.forEach(System.out::print);
		/*
		 * {pincode=534120, village=konithivada, state=AP,
		 * city=Veeravasaram}{pincode=534126, village=Nelamuru, state=AP,
		 * city=Penumantra}{pincode=5000082, village=Shaikpet, state=TG, city=Hyderabad}
		 */

	}

	public static void collectionSortcity() {
		List<Address> emplist = Arrays.asList(new Address(500082, "Shaikpet", "TG", "Hyderabad"),
				new Address(534126, "Nelamuru", "AP", "Penumantra"),
				new Address(534120, "Toleru", "AP", "veeravasaram"),
				new Address(534120, "Konithivada", "AP", "veeravasaram"));

		emplist.stream().filter(e -> e.getCity().equals("veeravasaram"))
				.sorted((o1, o2) -> o1.getVillage().compareTo(o2.getVillage())).forEach(System.out::println);

		emplist.stream().sorted(Comparator.comparing(Address::getVillage))
				.filter(e -> e.getCity().equals("veeravasaram")).forEach(System.out::println);

	}

}
