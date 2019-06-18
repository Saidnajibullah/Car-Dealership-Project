package com.revature.car.dealership.najib;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

import org.apache.log4j.Logger;

public abstract class CarDealershipDriver {
	static ArrayList<String> carLots = new ArrayList<>();
	static ArrayList<String> userLoninData = new ArrayList<String>();
	static Hashtable<String, String> offers = new Hashtable<>();
	static ArrayList<String> pins = new ArrayList<String>();
	final static Logger logger = Logger.getLogger(CarDealershipDriver.class);
	

	public static void main(String[] args) {
		
		
		UserInterfaceMenuOptions userInterface = new UserInterfaceMenuOptions();
		Employees employee = new Employees();
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n\n");
		try {
			System.out.println("\t\t\t\t ----------------------------------- ");
			System.out.println("\t\t\t\t|                                   |");
			System.out.println("\t\t\t\t|  Welcome To Gladiator Car Dealer  |");
			System.out.println("\t\t\t\t|                                   |");
			System.out.println("\t\t\t\t -----------------------------------\n\n\n");
			logger.info("Application executions starts");
			System.out.println("\tCustomr: Enter (C)\tEmployee: Enter (E) ");
			

			String choice = scanner.nextLine();
			logger.info("User input was: " + choice);
			if(choice.contains("C")) {
				System.out.println("\t>>Enter 'R' To Register");
				System.out.println("\t>>Enter 'L' To Login!");

				String choiceC = scanner.nextLine();
				logger.info("Customer input was: " + choiceC);
				switch(choiceC) {
				case "R": 	userInterface.register();
				break;
				case "L":   userInterface.login();
				break;
				    
				default: System.out.println("\tInvalid Input!");
				employee.exit(" ");
				
				break;
			}
				

			}
			else if(choice.contains("E")) {
                 employee.employeeMenuOptions();
			}
			else {
				System.out.println("Invalid Input!");
				employee.exit(" ");
			}
				scanner.close();
		
		}catch (IOException e) {
			
			logger.error(e);;
		}
		
	}

}
