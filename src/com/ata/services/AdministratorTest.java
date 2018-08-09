package com.ata.services;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.ata.bean.DriverBean;
import com.ata.bean.RouteBean;
import com.ata.bean.VehicleBean;
import com.ata.dao.DriverDao;
import com.ata.dao.DriverDaoImpl;
import com.ata.dao.RouteDao;
import com.ata.dao.RouteDaoImpl;
import com.ata.dao.VehicleDao;
import com.ata.dao.VehicleDaoImpl;

public class AdministratorTest {

	
	
	Administrator ad = new AdministratorImpl();
	@Test
	public void testAddVehicle() 
	{
		
		VehicleBean vb = new VehicleBean();
		
		VehicleDao vd = new VehicleDaoImpl();
		vb.setVehicleID(vd.getVehicleId("ta"));
		vb.setName("tata");
		vb.setType("bus");
		vb.setRegistrationNumber("3356555");
		vb.setSeatingCapacity(50);
		vb.setFarePerKM(60);
		
		String actual = ad.addVehicle(vb);
		assertEquals("SUCCESS", actual);
		
		 
	/*	VehicleBean vb = new VehicleBean();
		VehicleDao vd = new VehicleDaoImpl();
		vb.setVehicleID(vd.getVehicleId("pr"));
		vb.setName("pranav");
		vb.setType(null);
		vb.setRegistrationNumber("1465535");
		vb.setSeatingCapacity(2);
		vb.setFarePerKM(30);
		String actual = ad.addVehicle(vb);
		assertEquals("INVALID", actual);*/
		
		
		/*ad.addVehicle(null);*/
		
		
		
		
		
	}
	
	
	@Test
	public void testViewVehicle() 
	{
		
		//assertNull(ad.viewVehicle("ho1044"));
		//assertNull(ad.viewVehicle(null));
		//assertNull(ad.viewVehicle("r1003"));	//invalid id format
		//assertNull(ad.viewVehicle("rr1002"));	//no such vehicle
		
	}
	
	@Test
	public void testModifyVehicle()
	{
		/*VehicleBean vb = new VehicleBean();
		vb.setVehicleID("hy1001");
		vb.setName("hyundai");
		vb.setType("car");
		vb.setRegistrationNumber("12345345");
		vb.setFarePerKM(200);
		vb.setSeatingCapacity(4);
		assertTrue(ad.modifyVehicle(vb));*/
		
		/*VehicleBean vb = new VehicleBean();
		vb.setVehicleID("hy1001");
		vb.setName("hyundai");
		vb.setType(null);
		vb.setRegistrationNumber("12345345");
		vb.setFarePerKM(200);
		vb.setSeatingCapacity(4);
		assertFalse(ad.modifyVehicle(vb));*/
		
		
		//assertFalse(ad.modifyVehicle(null));*/
	}
	@Test
	public void testDeleteVehicle()			
	{
		/*ArrayList<String> al = new ArrayList<String>();
		al.add("ma1003");
		al.add("ma1007");
		int c = ad.deleteVehicle(al);
		assertEquals(2, c);*/
		
		/*ArrayList<String> al = new ArrayList<String>();
		al.add("hy1001");
		int c = ad2.deleteVehicle(al);
		assertEquals(0, c);*/
		
	}
	@Test
	public void testAddDriver()
	{
		/*DriverBean db= new DriverBean();
		DriverDao dd = new DriverDaoImpl();
		db.setDriverID(dd.getDriverId("ra"));
		db.setName("rajesh");
		db.setCity("delhi");
		db.setLicenseNumber("34434");
		db.setLocation("karolbagh");
		db.setMobileNo("9090909900");
		db.setPincode("233233");
		db.setState("delhi");
		db.setStreet("chodi gali");
		String res = ad.addDriver(db);
		assertEquals("SUCCESS", res);
		*/
		
		/*DriverBean db= new DriverBean();
		DriverDao dd = new DriverDaoImpl();
		db.setDriverID(dd.getDriverId("ra"));
		db.setName("rajesh");
		db.setCity("delhi");
		db.setLicenseNumber("34434");
		db.setLocation(null);
		db.setMobileNo("9090909900");
		db.setPincode("233233");
		db.setState("delhi");
		db.setStreet("chodi gali");
		String res = ad.addDriver(db);
		assertEquals("INVALID", res);*/
		
	}
	
	@Test
	public void testAddRoute()
	{
		/*RouteDao rd = new RouteDaoImpl();
		RouteBean rb = new RouteBean();
		rb.setRouteID(rd.getRouteId("ku", "is"));
		rb.setDestination("ismailabad");
		rb.setSource("kurukshetra");
		rb.setDistance(30);
		rb.setTravelDuration(55.0);
		String actual = ad.addRoute(rb);
		assertEquals("SUCCESS", actual);*/
		
		/*RouteDao rd = new RouteDaoImpl();
		RouteBean rb = new RouteBean();
		rb.setRouteID(rd.getRouteId("ku", "is"));
		rb.setDestination("ismailabad");
		rb.setSource(null);
		rb.setDistance(30);
		rb.setTravelDuration(55.0);
		String actual = ad.addRoute(rb);
		assertEquals("INVALID", actual);*/
	}
	@Test
	public void testDeleteRoute()
	{
		/*
		ArrayList<String> al = new ArrayList<String>();
		al.add("kuis1004");
		int c = ad.deleteRoute(al);
		assertEquals(1, c);*/
		
		/*Administrator ad = new AdministratorImpl();
		ArrayList<String> al = new ArrayList<String>();
		al.add("kais1007");
		int c = ad.deleteRoute(al);
		assertEquals(0, c);*/
	}
	@Test
	public void testViewRoute()
	{
		
		/*assertNotNull(ad.viewRoute("deis1002"));
		assertNull(ad.viewRoute("rrgg1008"));
		assertNull(ad.viewRoute("r45"));
		assertNull(ad.viewRoute(null));
		*/
	}
	@Test
	public void testModifyDriver()
	{
		/*DriverBean db = new DriverBean();
		db.setDriverID("ra1002");
		db.setCity("gurugram");
		db.setLicenseNumber("3489349");
		db.setLocation("new mall road");
		db.setMobileNo("7854455445");
		db.setName("ramesh");
		db.setPincode("455055");
		db.setState("haryana");
		db.setStreet("purani gali");
		assertTrue(ad.modifyDriver(db));*/
		
		/*DriverBean db = new DriverBean();
		db.setDriverID("ra1002");
		db.setCity("gurugram");
		db.setLicenseNumber("3489349");
		db.setLocation("new mall road");
		db.setMobileNo(null);
		db.setName("ramesh");
		db.setPincode("455055");
		db.setState("haryana");
		db.setStreet("purani gali");
		assertFalse(ad.modifyDriver(db));*/
		
		/*assertFalse(ad.modifyDriver(null));*/
	}
	
	@Test
	public void testModifyRoute()
	{
		/*RouteBean rb = new RouteBean();
		rb.setDestination("ismailabad");
		rb.setDistance(27);
		rb.setRouteID("kuis1003");
		rb.setSource("kurukshetra");
		rb.setTravelDuration(50);
		assertTrue(ad.modifyRoute(rb));*/
		
		//assertFalse(ad.modifyRoute(null));
		
		/*RouteBean rb = new RouteBean();
		rb.setDestination("ismailabad");
		rb.setDistance(30);
		rb.setRouteID("kuis");
		rb.setSource("kurukshetra");
		rb.setTravelDuration(50);
		assertFalse(ad.modifyRoute(rb));*/
		
	}
}
