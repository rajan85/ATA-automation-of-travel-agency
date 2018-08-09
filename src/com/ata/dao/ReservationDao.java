package com.ata.dao;

import java.sql.Date;
import java.util.ArrayList;

import com.ata.bean.ReservationBean;

public interface ReservationDao {
	String createReservation(ReservationBean reservationBean);
	int deleteReservation(ArrayList<String> reservationIDs);
	boolean updateReservation(ReservationBean reservationBean);
	ReservationBean findByID(String reservationID);
	ArrayList<ReservationBean> findAll();
	ArrayList<ReservationBean> findAllByJourney(Date journeyDate, String source, String destination);
	String confirmReservation(String reservationID , String driverID);
	String getReservationId();
	
}
