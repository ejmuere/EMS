package com.collabera.team3000.employmentType;

import java.io.Serializable;

public class FullTime implements EmploymentType, Serializable {
    
    String empType;
    int salary;
    String payType;
    
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    
    public String getEmpType() {
        return empType;
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
    	return "Full Time";
    }

}