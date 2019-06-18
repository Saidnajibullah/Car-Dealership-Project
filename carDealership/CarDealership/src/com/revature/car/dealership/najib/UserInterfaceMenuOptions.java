package com.revature.car.dealership.najib;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserInterfaceMenuOptions extends CarDealershipDriver implements UserInterface {
	Car car1 = new Car();
	Customers customer1 = new Customers();
	Employees employee = new Employees();
	CarDealershipDaoImpt customerDao = new CarDealershipDaoImpt();
	
	Scanner scanner = new Scanner(System.in);
	public void register() throws IOException{
		
		
		int x = 1;
		do {
			try {
				ResultSet customerPss = null;
				System.out.println("\n\t>>Enter Your First Name! (a-z/A-Z)\n");
				String name = scanner.nextLine();
				if(Pattern.matches("[a-zA-Z]+", name)) {
					System.out.println("\n\t>>Enter Your First Last Name! (a-z/A-Z)\n");
					String lname = scanner.nextLine();
					if(Pattern.matches("[a-zA-Z]+", lname)) {
						System.out.println("\n\t>>Enter Your SSN #! (Digits Only)");
						String ssn = scanner.nextLine();
						if(Pattern.matches("[0-9]+", ssn)) {
							customerDao.getCustomerSSN(customerPss, ssn);
							ResultSet pass = customerDao.getCustomerSSN(customerPss, ssn);
							while(pass.next()) {
							
								System.out.println("\tThe Customer Already Exists!\n");
								employee.exit("\tPlease Exit To Register Or Login!\n");
								}
							
						}else {
							System.out.println("\n\tInvalid Input!\n");
							continue;
						}
						customerDao.saveCustomer(name, lname, ssn);
					
					}else {
						System.out.println("\n\tInvalid Input!\n");
						continue;
					}
					employee.exit("\tThank You! You Registered Successfuly\n");
					x = 2;
					
				}else {
					System.out.println("\n\tInvalid Input!\n");
					continue;
				}
				
			}
			catch(Exception e) {
				logger.error(e);
				x = 2;
			}
		}while(x == 1);
		login();
	}
	
	public void login() {
		
		System.out.println("\n\t\t\t\t--------Login Screen!--------\n");
		System.out.println("\n\t>>Enter Your SSN #!\n");
		String ssn = scanner.nextLine();
		
		ResultSet customerPss = null;
		customerDao.getCustomerSSN(customerPss, ssn);
		ResultSet pass = customerDao.getCustomerSSN(customerPss, ssn);
		try {
			while(pass.next()) {
				System.out.println("\n\t\t\t----- YOU ARE LOGGED IN-----\n");
				System.out.println("\t>>Enter 'S' See Cars From The Lot!");
				System.out.println("\t>>Enter 'P' To Put An Offer!");
				System.out.println("\t>>Enter 'E' to Logout");
				
				String options = scanner.nextLine();
				switch(options) {
				case "E": CarDealershipDriver.main(null);
				    break;
				case "S": employee.showCars();
					break;
				case "P": customer1.putOffer();
					break;
					
				}
				
		}
			System.out.println("\tYou Are Not Register! Please Register First!\n");
			employee.exit(" ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);;
		}
		
	}



}
