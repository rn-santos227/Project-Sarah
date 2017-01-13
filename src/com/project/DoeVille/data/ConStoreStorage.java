package com.project.Doeville.data;

public class ConStoreStorage {
	public static int HamSandwichQ, MilkCartonQ, EnergyDrinkQ, JunkFoodQ; 
	public double HamSandwichP, MilkCartonP, EnergyDrinkP, JunkFoodP;
	public ConStoreStorage() {
		HamSandwichQ = 50;
		MilkCartonQ = 50;
		EnergyDrinkQ = 50;
		JunkFoodQ = 50;
		
		HamSandwichP = 5.00;
		MilkCartonP = 10.00;
		EnergyDrinkP = 15.00;
		JunkFoodP = 8.00;
	}
	
	public static void updateConvinienceStore() {
		HamSandwichQ = 50;
		MilkCartonQ = 50;
		EnergyDrinkQ = 50;
		JunkFoodQ = 50;
	}
}
