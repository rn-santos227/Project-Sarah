package com.project.Doeville.data;

public class BankInformation {
	public static double currentBalance;
	public BankInformation() {
		currentBalance = 1000;
	}
	public double getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(double currentBalance) {
		BankInformation.currentBalance = currentBalance;
	}
}
