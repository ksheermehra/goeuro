package com.goeuro.codingassignment;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

public class BusrouteApplicationTests {
	
	private static Map<Integer, Integer[]> mockRouteData = new HashMap<>();
	
	private static RouteDataLoader rdl;
	
	/*
	 * first two pairs (3,4) & (0,1)
	 */
	private int[] dep_sids = new int[] {3, 0};
	private int[] arr_sids = new int[] {4, 1};
	
	private static String testRouteData = "src/test/resources/data.txt";
	
	@BeforeClass
	public static void testData() throws IOException, RouteDataMalformedException {
		// prep the mock data
		mockRouteData.put(new Integer(0), new Integer[] {0, 1, 2, 3, 4});
		mockRouteData.put(new Integer(1), new Integer[] {1, 3, 5, 6});
		mockRouteData.put(new Integer(2), new Integer[] {0, 4, 6});
		
		// load the data from file
		rdl = new RouteDataLoader(testRouteData);
	}
	
	@Test
	public void routeDataLoadingTest() {
		Map<Integer, Integer[]> loadedRouteData = RouteDataLoader.routeData;
		
		loadedRouteData.forEach((k,v) -> {
			
			Integer[] mockv = mockRouteData.get(k);
			
			assertArrayEquals(mockv, v);
			
		});
		
	}
	
	@Test
	public void routeFindTest() {
		RouteFinder rd = new RouteFinder();
		BusRouteResponse result;
		
		// test 1: (3,4)
		result = rd.find(dep_sids[0], arr_sids[0]);
		assertEquals(result.isDirect_bus_route(), true);
		
		// test 2: (0,1)
		result = rd.find(dep_sids[1], arr_sids[1]);
		assertEquals(result.isDirect_bus_route(), true);
	}

}
