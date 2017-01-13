package com.project.Doeville.data;

public class PharmacyStorage {
	public static int HealthTabletQ;
	public static int HealthCapsuleQ;
	public static int SantizerQ; 
	public double HealthTabletP, HealthCapsuleP, SantizerP; 
	public PharmacyStorage() {
		HealthTabletQ = 50;
		HealthCapsuleQ = 50;
		SantizerQ = 50;
		
		HealthTabletP = 25.00;
		HealthCapsuleP = 50.00;
		SantizerP = 25.00;
	}
	
	public static void updatePharmacyStorage() {
		HealthTabletQ = 50;
		HealthCapsuleQ = 50;
		SantizerQ = 50;
	}
}
