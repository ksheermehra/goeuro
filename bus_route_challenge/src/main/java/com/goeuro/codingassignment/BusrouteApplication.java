package com.goeuro.codingassignment;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * this stub was generated using the spring boot start page: start.spring.io
 */

@SpringBootApplication
public class BusrouteApplication {
	
	// i will initialize my logger here. will use this to create my traces
	public static Logger logger = Logger.getLogger("appTrace");
		
	protected static String dataFileInputPath;
	
	public static void main(String[] args) {
		
		if(args.length == 1) { // we got exactly the number of arguments that we were expecting
			
			dataFileInputPath = args[0];
			
			logger.info("input args were in order, will continue to initialize the app");
			
			// initialize the application now
			SpringApplication.run(BusrouteApplication.class, args);
			
			logger.info("app loaded, hit me with a request!");
			
		} else { // incorrect number of input args, shudnt load the app
			logger.severe("incorrect number of command line arguments. correct usage (example): java -jar myjar.jar <path_to_data_file>");
		}
		
	}
}
