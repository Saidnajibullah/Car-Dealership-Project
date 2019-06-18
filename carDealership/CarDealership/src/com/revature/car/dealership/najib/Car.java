package com.revature.car.dealership.najib;

//import java.util.Scanner;
//import java.util.Set;

public class Car extends CarDealershipDriver{

private double price;
private int id;
private String name;
private String model;

    public synchronized String getName() {
	return name;
	}
	public synchronized void setName(String name) {
		this.name = name;
	}
	public synchronized String getModel() {
		return model;
	}
	public synchronized void setModel(String model) {
		this.model = model;
	}
	/*
	 * Scanner scanner = new Scanner(System.in);
	 * 
	 * public void createCar() { int x = 1; do { try {
	 * System.out.println("Add Car To The Lot");
	 * System.out.println("Enter Car Name"); String name = scanner.nextLine();
	 * this.setName(name); System.out.println("Enter Car Model"); String model =
	 * scanner.nextLine(); this.setModel(model);
	 * System.out.println("Do You Want to Add More Cars?\n");
	 * System.out.println("Enter 'Y' to Add More Cars !");
	 * System.out.println("Enter 'R' to To Remove A Cars From The Lot !");
	 * System.out.println("Enter 'S' to To Show Cars From The Lot !");
	 * System.out.println("Enter 'E' to Exit !"); carLots.put(this.getName(),
	 * this.getModel()); String addMoreExit = scanner.nextLine();
	 * if(addMoreExit.contains("Y")) { continue; } else
	 * if(addMoreExit.contains("R")) { this.removeCarFromTheLot(); x = 2;
	 * 
	 * } else if(addMoreExit.contains("S")) { this.showCars(); x = 2; } else {
	 * this.exit(" "); }
	 * 
	 * 
	 * 
	 * }catch(Exception e) { System.out.println("Some Unnormal Happend" + e); }
	 * }while(x == 1); }
	 * 
	 * public void removeCarFromTheLot() {
	 * System.out.println("Enter 'R' To Remove A Car From The Car Lot!"); String
	 * removeCar = scanner.nextLine(); if(removeCar.contains("R")) {
	 * System.out.println("Enter The Car Name!"); String carName =
	 * scanner.nextLine(); if((carLots.containsKey(carName))) {
	 * carLots.remove(carName); this.exit("The Car '" + carName +
	 * "'  Was Removed!");
	 * 
	 * }else { this.exit("Car Not Found!"); }
	 * 
	 * }else { this.exit("Invalid Input!"); }
	 * 
	 * } public void showCars() { Set<String> keys = carLots.keySet();
	 * if(!keys.isEmpty()) { for(String key: keys){
	 * System.out.println("\nCar Name: " + key + ", Car Model: " + carLots.get(key)
	 * );
	 * 
	 * } this.exit(""); }else { this.exit("The Car Lot Is Empty!"); }
	 * 
	 * 
	 * } public void exit(String v) { int x = 1; System.out.println(v); do {
	 * System.out.println("Enter 'E' to Exit"); String exit = scanner.nextLine();
	 * if(exit.contains("E")) { CarDealershipDriver.main(null); x = 2; }else {
	 * System.out.println("Invalid Input!"); continue; } }while(x ==1); }
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
