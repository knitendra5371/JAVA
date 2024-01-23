package com.creational.factoryMethod;

public class GetPlanFactory {
	public Plan getPlan(String planName) {
		
		Plan plan = null;
		if (planName.equalsIgnoreCase("DOMESTICPLAN")) {
			plan = new DomesticPlan();
		} else if (planName.equalsIgnoreCase("COMMERCIALPLAN")) {
			plan = new CommercialPlan();
		} else if (planName.equalsIgnoreCase("INSTITUTIONALPLAN")) {
			plan = new InstitutionalPlan();
		}
		return plan;
		
	}
}
