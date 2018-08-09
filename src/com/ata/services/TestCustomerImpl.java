package com.ata.services;

import static org.junit.Assert.*;

import org.junit.Test;
import com.ata.bean.*;
import java.util.*;
public class TestCustomerImpl {
	Customer c = new CustomerImpl();
	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/

	
	@Test
	public void testViewVehicleByType()
	{
		/*ArrayList<VehicleBean> al = new ArrayList<VehicleBean>();
		al = c.viewVehiclesByType("car");
		
		assertNotNull(al);*/
		
		/*ArrayList<VehicleBean> al = new ArrayList<VehicleBean>();
		al = c.viewVehiclesByType("airplane");
		assertNull(al);*/
	}
	
	@Test
	public void testViewVehicleBySeats()
	{
		/*ArrayList<VehicleBean> al ;
		al = c.viewVehiclesBySeats(6);
		assertNotNull(al);*/
		
		ArrayList<VehicleBean> al ;
		al = c.viewVehiclesBySeats(4);
		assertNull(al);
	}
	@Test
	public void testViewAllRoutes()
	{
		ArrayList<RouteBean> al;
		al = c.viewAllRoutes();
		assertNotNull(al);
	}
}
