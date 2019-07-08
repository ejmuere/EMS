package com.collabera.team3000.employmentType;

import java.io.Serializable;

public class Intern implements EmploymentType, Serializable  {
	
	String empType;
	int hourly;
	String payType;
	
	public String getEmpType() {
		return empType;
	}
	public int getHourly() {
		return hourly;
	}
	public void setHourly(int hourly) {
		this.hourly = hourly;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public void setEmpType() {
		
	}
	
	@Override
	public void setPayType() {
		// TODO Auto-generated method stub
		
	}
	
	public String getEmployeeType() {
    	return "Intern";
    }

}
