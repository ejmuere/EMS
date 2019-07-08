package com.collabera.team3000.Employee;
import java.io.Serializable;

import com.collabera.team3000.Department.Department;
import com.collabera.team3000.employmentType.*;
/**
 * Employee class contains all the employee details and has the to String methods
 * @author joshe_000
 *
 */

public class Employee implements Serializable{
    
    int employeeID;
    EmploymentType empType;
    String name;
    Address address;
    Department department;
    int sSN;
    int age;
    
    
    public int getEmployeeID() {
        return employeeID;
    }
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
    public String getEmpType() {
        return empType.getEmployeeType();
    }
    public void setEmpType(EmploymentType empType) {
        this.empType = empType;
    }
    public int getsSN() {
        return sSN;
    }
    public void setsSN(int sSN) {
        this.sSN = sSN;
    }
    public int getiD() {
        return employeeID;
    }
    public void setiD(int iD) {
        this.employeeID = iD;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public String toStringAll() {
		return "Id: " + this.getiD() + "  Name: " + this.getName() +
				" Department: " + this.getDepartment().getDepartmentName() +
				" Type of Employee: " + this.getEmpType();
	}
	
	public String toString() {
		return "Id: " + this.getiD() + "  Name: " + this.getName() +
		"\nDepartment: " + this.getDepartment().getDepartmentName() +
		"\nType of Employee: " + this.getEmpType() +
		"\nAddress: " + this.getAddress().toString();
		
	}
    

}