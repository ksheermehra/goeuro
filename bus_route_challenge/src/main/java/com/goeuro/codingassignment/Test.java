package com.goeuro.codingassignment;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Test {
	public static void main(String[] args) {
		int routes = 1000;
		
		System.out.println(routes);
		
		for(int i = 0; i < routes; i++) {
			int stations = ThreadLocalRandom.current().nextInt(10,100);
			
			System.out.print(i + " ");
			
			Set<Integer> stationsset = new HashSet<>();
			
			for(int j = 0; j < stations; j++) {
				stationsset.add(ThreadLocalRandom.current().nextInt(100,500));
			}
			
			stationsset.stream().forEach( s -> System.out.print( s + " "));
			
			System.out.println("");
		}
		
	}
}
