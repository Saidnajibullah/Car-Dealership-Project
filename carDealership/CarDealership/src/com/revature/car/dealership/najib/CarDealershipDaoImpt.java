package com.revature.car.dealership.najib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.Logger;

public final class CarDealershipDaoImpt implements CarDealershipDao {
private static String url;
private static String user;
private static String pass;
private static final String CREDENTIALS = "src/credentials.properties"; 
static Connection conn = null;

static Logger logger = Logger.getLogger(CarDealershipDaoImpt.class);
public static final synchronized Connection connecToDatabase() {
	try {
		Properties prop = new Properties();
		try (FileInputStream fis = new FileInputStream(CREDENTIALS);){
			prop.load(fis);
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			pass = prop.getProperty("pass");
			conn = DriverManager.getConnection(url, user, pass);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}catch ( IOException e) {
			logger.error(e);
		}
		
	} 
	catch (SQLException e) {
		logger.error(e);
	}
	return conn;
}


@Override
public synchronized int saveCustomer(String fname, String lname, String pass) {
	int result = 0;
	try {
		Connection newconn = connecToDatabase();
		Statement stmt = newconn.createStatement();
		String sql = "insert into customer1 (firstname, lastname, password) values " +
		"(" + "'" + fname + "'" + ", " + "'"  + lname + "'"  + ", " + "'"  + pass + "'"  +")";
		result = stmt.executeUpdate(sql);
		newconn.close();
	} catch (SQLException e) {
		logger.error(e);
	}
	return result;
}

	@Override
	public synchronized int addCar(String make, String model, String vin, double price) {
		int result = 0;
		try {
			Connection newconn = connecToDatabase();
			Statement stmt = newconn.createStatement();
			String sql = "insert into car (make, model, vin, price) values " +
			"(" + "'" + make + "'" + ", " + "'"  + model + "'"  + ", " + "'"  + vin + "'"  +
				 ", " + "'" + price + "'" + ")";
			result = stmt.executeUpdate(sql);
			newconn.close();
		} catch (SQLException e) {
			logger.error(e);
		}
		return result;
	}

	public ResultSet getTable(String tableName, ResultSet tableData) {
		
		try {
			Connection newconn = connecToDatabase();
			if(newconn !=null) {
				Statement stmt = newconn.createStatement();
				String sql = "select * from " + tableName;
				tableData = stmt.executeQuery(sql);
				newconn.close();
			}
			else {
				System.out.println("Connection failed! Please check your database connection" );
	
			}
			
		}
		catch (SQLException e) {
			logger.error(e);
		}
		return tableData;
	}

	@Override
	public ResultSet getCustomerSSN(ResultSet result, String input) {
		try {
			Connection newconn = connecToDatabase();
			Statement stmt = newconn.createStatement();
			String sql = "select password from customer1 where password = " + "'" + input + "'";
			result = stmt.executeQuery(sql);
			newconn.close();
		} catch (SQLException e) {
			logger.error(e);
		}
		return result;
	}
	@Override
	public synchronized int putOffer(int customerid, int carid) {
		int result = 0;
		try {
			Connection newconn = connecToDatabase();
			Statement stmt = newconn.createStatement();
			String sql = "insert into offer (cust_id, car_id) values " +
			"(" + "'" + customerid + "'" + ", " + "'"  + carid + "'" + ")";
			result = stmt.executeUpdate(sql);
			newconn.close();
		} catch (SQLException e) {
			logger.error(e);
		}
		return result;
	}
	
	@Override
	public synchronized int removeeCar(int id) {
		int result = 0;
		try {
			Connection newconn = connecToDatabase();
			Statement stmt = newconn.createStatement();
			String sql = "delete from car where id = " + "id";
			result = stmt.executeUpdate(sql);
			newconn.close();
		} catch (SQLException e) {
			logger.error(e);
		}
		return result;
	}
	

	

	

}
