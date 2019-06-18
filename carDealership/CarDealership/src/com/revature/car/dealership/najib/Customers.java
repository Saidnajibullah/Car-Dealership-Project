package com.revature.car.dealership.najib;

import java.util.Scanner;

public class Customers extends CarDealershipDriver implements Customer {
	CarDealershipDaoImpt cardealerdao = new CarDealershipDaoImpt();
	Employees employee = new Employees();
	Scanner scanner = new Scanner(System.in);
	

	public void putOffer() {
		int x = 1;
		try {
			do {
				System.out.println("\tEnter 'P' To Put An Offer!");
				String offer = scanner.nextLine();
				if(offer.contains("P")) {
					System.out.println("\tInsert Customer ID!");
					int cusId = scanner.nextInt();
					System.out.println("\tInsert Car ID!");
					int carId = scanner.nextInt();
					cardealerdao.putOffer(cusId, carId);
					if(cardealerdao.putOffer(cusId, carId) > 0) {
						System.out.println("\tYou Put Your Offer Succesfully, Thank You! ");
						employee.exit(" ");
					}
					
				}else {
					System.out.println("Invalid Input!");
					System.out.println("Enter 'E' To Exit!");
					String offerExit = scanner.nextLine();
					if(offerExit.contains("E")) {
						CarDealershipDriver.main(null);
						x = 2;
					}
				}
				
				
			}while(x == 1);
		}catch(Exception e) {
			logger.error(e);
		}
		
	}


}
