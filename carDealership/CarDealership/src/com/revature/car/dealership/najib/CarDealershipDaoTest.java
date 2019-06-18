package com.revature.car.dealership.najib;

import static org.junit.Assert.*;

import java.sql.ResultSet;


import org.junit.Test;

public class CarDealershipDaoTest {
	CarDealershipDaoImpt carDao = new CarDealershipDaoImpt();

	  @Test 
	  public void connecToDatabaseTest() {
	  assertNotNull(CarDealershipDaoImpt.connecToDatabase()); }
	  
	  @Test public void saveCustomerTest() {
		  // for each run the password value should be changed. because the column
		  // constrain does not allow password duplication.
		  assertEquals(1,carDao.saveCustomer("Sarim", "Ali", "34klrn")); 
		  } 
	  public void addCarTest() {
	  assertEquals(1, carDao.addCar("Ford", "X42", "3421", 23089)); 
	  }
	  
	  @Test
	 
	public void getTableTest() {
		ResultSet rs = null;
		assertNotNull(carDao.getTable("customer1", rs));
	}
	  @Test
	  public void getCustomerSSNTest() {
		  ResultSet rs = null;
		  ResultSet rsp = carDao.getCustomerSSN(rs, "jmst78");
		  assertNotNull(rsp);
	
	  }
	  @Test
	  public void putOfferTest() {
		  assertEquals(1, carDao.putOffer(2, 3)); 
	  }
}
