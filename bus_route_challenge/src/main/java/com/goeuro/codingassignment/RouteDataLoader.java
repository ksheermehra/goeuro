package com.goeuro.codingassignment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

@Component
public class RouteDataLoader {
	
	Logger logger = Logger.getLogger("appTrace");
	
    private String dataFileInputPath = BusrouteApplication.dataFileInputPath;
    
    public static final Map<Integer, Integer[]> routeData = new HashMap<>();
	
	RouteDataLoader() throws IOException, RouteDataMalformedException {
		
		loadData();
		
	}
	
	// use this constructor for unit tests
	RouteDataLoader(String dataFilePath) throws IOException, RouteDataMalformedException{
		
		dataFileInputPath = dataFilePath;
		loadData();
		
	}
	
	private void loadData() throws IOException, RouteDataMalformedException {
		
		Path routeDatafilePath = Paths.get(dataFileInputPath);
		
		if(Files.exists(routeDatafilePath)) { // the supplied path exists
			
			// lets read the file in to memory, and then close it
			Stream<String> routeDataStream = Files.lines(routeDatafilePath);
			
			List<String> routeDataFileLines = new ArrayList<>();
			
			routeDataStream.forEach( line -> routeDataFileLines.add(line));
			
			routeDataStream.close(); // close it! before i forget!
			
			int routes = Integer.parseInt(routeDataFileLines.get(0));
			
			// let us check if the N is correct, if the number of routes indicated in the first line is equal to the
			// number of routes in the file. it is just a check routine, to ensure the file what is expected
			
			if(routes == routeDataFileLines.size() - 1) { // all good, we can proceed
				routeDataFileLines.remove(0); // we dont need the first line in the file any more
				
				routeDataFileLines.forEach( line -> addToDataMap(line));
				
				logger.info("data loaded!");
				
			} else { // the number of routes indicated in the file do not match the actual number of routes available

				throw new RouteDataMalformedException("the number of routes indicated in the file do not match the actual number of routes available");
			}
			
		} else { // the route data file doesnt exist, there is no point continuing
			logger.severe("didnt find the data file at the location , will exit now");
			System.exit(-1);  
		}

	}

	private Object addToDataMap(String l) {
		// split the line to tokens
		String[] tokens = l.split(" ");
		
		// lets convert the tokens to integer
		List<Integer> dataList = new ArrayList<>();
		
		Arrays.stream(tokens).forEach(t -> dataList.add(Integer.parseInt(t)));
		
		// get the route id, first integer in the line, and then remove it from the collection
		Integer routeid = dataList.get(0);
			dataList.remove(0);
		
		Integer[] stations = dataList.toArray(new Integer[1]);
			Arrays.sort(stations); // we will sort it, makes searching easier
		
		routeData.put(routeid, stations);
		
		return null;
	}


}
