package com.goeuro.codingassignment;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

public class RouteFinder {
	
	Logger logger = Logger.getLogger("appTrace");
	
	private static final Map<Integer, Integer[]> routeData = RouteDataLoader.routeData;
	
	Boolean routeExists = false;
	
	public BusRouteResponse find(int dep_sid, int arr_sid) {
		
		routeData
			.entrySet()
			.parallelStream()
			.forEach( rd -> {
				if(!routeExists) routeExists = findRoute(rd, dep_sid, arr_sid);
			});
		
		BusRouteResponse response = new BusRouteResponse(dep_sid, arr_sid, routeExists);
		
		logger.info("i will try to find routes between: " + dep_sid + " and " + arr_sid + "; result is: " + routeExists);
		
		return response;
	}

	private boolean findRoute(Entry<Integer, Integer[]> rd, int dep_sid, int arr_sid) {
		
		boolean result = false;
		
		Integer[] stations = rd.getValue();
		
		int dep_sid_index, arr_sid_index;
		
		// we look for the dep_sid in this route
		dep_sid_index = Arrays.binarySearch(stations, dep_sid);
		
		// we look for the arr_sid in this route
		arr_sid_index = Arrays.binarySearch(stations, arr_sid);
		
		// if we find both the dep_sid & the arr_sid in this route, then there exists a direct route
		if(dep_sid_index >= 0 && arr_sid_index >= 0)
			result = true;
		
		return result;
	}

}
