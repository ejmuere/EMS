package com.collabera.team3000.Department;

import java.io.Serializable;

/**
 * Department class which employees has a hasa relationship to and determines where employees are  grouped
 * @author joshe_000
 *
 */
public class Department implements Serializable{
    
    int iD;
    String depName;
    public int getDepartmentId() {
        return iD;
    }
    public void setDepartmentId(int iD) {
        this.iD = iD;
    }
    public String getDepartmentName() {
        return depName;
    }
    public void setDepartmentName(String depName) {
        this.depName = depName;
    }
    
    public String toString() {
    	return "Department Id: " + this.getDepartmentId() + " Department Name: " + this.getDepartmentName();
    }

}