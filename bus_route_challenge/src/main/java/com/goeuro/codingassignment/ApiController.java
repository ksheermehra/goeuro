package com.goeuro.codingassignment;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
		
	@RequestMapping("/api/direct")
	public BusRouteResponse findRoute(@RequestParam(value="dep_sid") int dep_sid, @RequestParam(value="arr_sid") int arr_sid) {
		
		BusRouteResponse r;
		
		RouteFinder rf = new RouteFinder();
		
		r = rf.find(dep_sid, arr_sid);
		
		return r;
	}
	
}
