package com.revature.car.dealership.najib;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class Employees extends CarDealershipDriver implements Employee {
	Logger logger = Logger.getLogger(Employees.class);
	CarDealershipDaoImpt cardealerdao = new CarDealershipDaoImpt();
	Scanner scanner = new Scanner(System.in);
	Scanner scannerint = new Scanner(System.in);
	Scanner scannerd = new Scanner(System.in);
	Car car = new Car();


	@Override
	public void seeAllOffers() {
		ResultSet offerTable = null; 
		ResultSet allOffers = cardealerdao.getTable("offer", offerTable);
		try {
			if(allOffers.wasNull()){
				System.out.println("\tThere Is Not Any New Offer!");
				this.exit(" ");
			}else {
				try {
					System.out.println("\t\tList Of All Offers:\n");
					while(allOffers.next()) {
						System.out.println("\t\t----------------------------------------------");
						System.out.println("\t\tOffer Status: " + allOffers.getString(2) + 
								", Offer Date: " + allOffers.getDate(3));
						
					}
					this.exit(" ");
				} catch (SQLException e) {
					logger.error(e);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
		
		
		
		
	}

	public void employeeMenuOptions() {
		System.out.println("\t>>Enter Enter Your 4 Digit PIN!");
		pins.add("1234");
		String pin = scanner.nextLine();
		for(String pin1: pins) {
			if(pin1.contains(pin)) {
				System.out.println("\t>>Enter 'A' To Add A Car to The Car Lot!");
				System.out.println("\t>>Enter 'D' To Remove A Car From The Car Lot!");
				System.out.println("\t>>Enter 'S' Show Cars From The Lot!");
				System.out.println("\t>>Enter 'W' To See Car Offers!");
				String choiceE = scanner.nextLine();
			
				switch(choiceE) {
				case "A":   this.createCar();
				break;
				case "D":   this.removeCarFromTheLot();
				break;
				case "S":   this.showCars();
				break;
				case "W":   this.seeAllOffers();
				break;
				    
				default: System.out.println("\tInvalid Input!");
				this.exit(" ");
				break;
				}
				
			}else {
				this.exit("\tYou Are Not An Authorized Employee!\\n");
			}
		}
	}

	
	public void createCar() {
		int x = 1;
		do {
			try {
				System.out.println("\tAdd Car To The Lot");
				System.out.println("\tEnter Car Make");
				String make = scanner.nextLine();
				System.out.println("\tEnter Car Model");
				String model = scanner.nextLine();
				System.out.println("\tEnter Car VIN");
				String vin = scannerint.nextLine();
				System.out.println("\tEnter Car Price");
				double price = scannerd.nextDouble();
				cardealerdao.addCar(make, model, vin, price);
				if(cardealerdao.addCar(make, model, vin, price) > 0) {
					x = 2;
					System.out.println("\tThe Car Was Successfully Added\n");
					this.exit(" ");
				}else {
					System.out.println("\tEnter 'R' to To Remove A Cars From The Lot !");
					System.out.println("\tEnter 'S' to To Show Cars From The Lot !");
					System.out.println("\tPress Any key to Exit !");
					String addMoreExit = scanner.nextLine();
					if(addMoreExit.contains("R")) {
						x = 2; this.removeCarFromTheLot();
					  
					} else if(addMoreExit.contains("S")) {
						x = 2; this.showCars();
				    } else{ 
				        x = 2;
					    this.exit(" "); 
					}
				}
				 	
			}catch(Exception e) {
				logger.error(e);
			}
		}while(x == 1);
	}
@Override
	public void removeCarFromTheLot() {
	
		System.out.println("\tEnter 'R' To Remove A Car From The Car Lot!");
		String removeCar = scanner.nextLine();
		if(removeCar.contains("R")) {
			System.out.println("\tEnter The Car Id!");
			String carId = scanner.nextLine();
			if(Pattern.matches("[0-9]+", carId)) {
				int id = Integer.valueOf(carId);
				cardealerdao.removeeCar(id);
				if(cardealerdao.removeeCar(id) > 0) {
					System.out.println("The Car Was Successfully Deleted");
					this.exit(" ");
				}else {
					this.exit("\tCar Not Found!\n");
				}
			}else {
				this.exit("\tInvalid Input!");
			}
			
		}else {
			this.exit("\tInvalid Input!");
		}
		
	}
@Override
	public void showCars() {
		ResultSet offerTable = null; 
		ResultSet allcars = cardealerdao.getTable("car", offerTable);
		try {
			if(allcars.wasNull()){
				System.out.println("\tThe Car Lot Is Empty!");
				this.exit(" ");
			}else {
				try {
					System.out.println("\t\tList Of All Cars:\n");
					while(allcars.next()) {
						System.out.println("\t\t-----------------------------------------------------");
						System.out.println("\t\tMake: " + allcars.getString(2)
						+ ", Model: " + allcars.getString(3)
						+ ", price: " + allcars.getString(5)
					    + ", VIN: " + allcars.getInt(4));
						
						
					}
					this.exit(" ");
				} catch (SQLException e) {
					logger.error(e);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}

	}
@Override
	public void exit(String v) {
		int x = 1;
		System.out.println(v);
		do {
			System.out.println("\tEnter 'E' to Exit");
			String exit = scanner.nextLine();
			if(exit.contains("E")) {
				CarDealershipDriver.main(null);
				x = 2;
			}else {
				System.out.println("\tInvalid Input!");
				continue;
			}
		}while(x ==1);
	}




	




}
