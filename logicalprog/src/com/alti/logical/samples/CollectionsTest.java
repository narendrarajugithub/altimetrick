package com.alti.logical.samples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.TooManyListenersException;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.alti.logical.samples.core.model.Address;
import com.alti.logical.samples.core.model.Employee;

public class CollectionsTest {

	public static void main(String[] args) {

		// mapSample();
		// hashMapStream();
		// groupByTest();
		fidDuplicates();

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
		

		// an element from the list1 occur from list2 more then once
		fruits1.stream().filter(f -> Collections.frequency(fruits2, f) > 1).collect(Collectors.toSet())
				.forEach(System.out::println);
		// an element from the list1 not occurred from list2
		fruits1.stream().filter(f -> Collections.frequency(fruits2, f) == 0).collect(Collectors.toSet())
				.forEach(System.out::println);
		*/
		
	
		
		// remove duplicates from the list
		fruits2.stream().distinct().forEach(System.out::println);
		fruits2.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).forEach((k,v)->System.out.println(k+" : "+v));
		ArrayList<String> diff = new ArrayList<>(fruits1);
		diff.removeAll(fruits2);
		// fruits2.removeAll(fruits1) you can't perform removeAll it is unSupported opration on list
		
		
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

		fruitCost.keySet();
		Collection<Integer> values = fruitCost.values();

		Set fruits = fruitCost.entrySet();
		Iterator fruitIterator = fruits.iterator();

		while (fruitIterator.hasNext()) {

			Map.Entry entry = (Entry) fruitIterator.next();
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		Optional<Entry<String, Integer>> optval = fruitCost.entrySet().stream().filter(m -> m.getKey().equals("apple"))
				.findFirst();
		if (optval.isPresent()) {
			System.out.println(optval.get().getValue());
		}

		optval.ifPresent(d -> {
			System.out.print(d.getKey() + "  : " + d.getValue());
		});

	}
	
	
	public static int[] getDuplicatesStreamsToArray( int[] input ) {
		  return( IntStream.of( input ).boxed().collect( Collectors.collectingAndThen(
		      Collectors.groupingBy( Function.identity(), Collectors.counting() ),
		      map -> {
		        map.values().removeIf( cnt -> cnt < 2 );
		        return( map.keySet() );
		      } ) ).stream().mapToInt( i -> i ).toArray() );
		}
	
	

}
