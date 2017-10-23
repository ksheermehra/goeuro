package com.goeuro.codingassignment;

public class BusRouteResponse {
	
	private int dep_sid;
	private int arr_sid;
	private boolean direct_bus_route;
	
	BusRouteResponse(int d, int a, boolean r) {
		dep_sid = d;
		arr_sid = a;
		direct_bus_route = r;
	}
	
	public int getDep_sid() {
		return dep_sid;
	}
	public void setDep_sid(int dep_sid) {
		this.dep_sid = dep_sid;
	}
	public int getArr_sid() {
		return arr_sid;
	}
	public void setArr_sid(int arr_sid) {
		this.arr_sid = arr_sid;
	}
	public boolean isDirect_bus_route() {
		return direct_bus_route;
	}
	public void setDirect_bus_route(boolean direct_bus_route) {
		this.direct_bus_route = direct_bus_route;
	}

	@Override
	public String toString() {
		return "BusRouteResponse [dep_sid=" + dep_sid + ", arr_sid=" + arr_sid + ", direct_bus_route="
				+ direct_bus_route + "]";
	}
}
