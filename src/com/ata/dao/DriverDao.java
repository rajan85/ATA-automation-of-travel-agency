package com.ata.dao;

import java.util.ArrayList;

import com.ata.bean.DriverBean;

public interface DriverDao {
	String createDriver(DriverBean driverBean);
	int deleteDriver(ArrayList<String> driverIDs);
	boolean updateDriver(DriverBean driverBean);
	DriverBean findByID(String driverID);
	ArrayList<DriverBean> findAll();
	String getDriverId(String prefix);
}
 