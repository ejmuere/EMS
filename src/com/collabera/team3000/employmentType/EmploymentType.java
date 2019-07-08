package com.collabera.team3000.employmentType;

import java.io.Serializable;

/**
 * Interface which determines what employee type the employee is
 * @author joshe_000
 *
 */

public interface EmploymentType extends Serializable{
    
	public String getEmployeeType();
    public void setPayType();

}