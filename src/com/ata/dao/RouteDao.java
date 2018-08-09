package com.ata.dao;

import java.util.ArrayList;

import com.ata.bean.RouteBean;

public interface RouteDao {
	String createRoute(RouteBean routeBean);
	int deleteRoute(ArrayList<String> routeIDs);
	boolean updateRoute(RouteBean routeBean);
	RouteBean findByID(String routeID);
	ArrayList<RouteBean> findAll();
	String getRouteId(String sourcePrefix ,String destinationPrefix );
}
