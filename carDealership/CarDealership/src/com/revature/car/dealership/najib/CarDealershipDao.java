package com.revature.car.dealership.najib;

import java.sql.ResultSet;

public interface CarDealershipDao {
	public int saveCustomer(String f, String l, String p);
	public int addCar(String make, String m, String v, double p);
	public int putOffer(int i, int j);
	public ResultSet getTable(String table, ResultSet tableData);
	public ResultSet getCustomerSSN(ResultSet r, String i);
	public int removeeCar(int id);

}
