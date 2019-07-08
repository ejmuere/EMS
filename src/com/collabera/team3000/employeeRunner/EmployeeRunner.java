package com.collabera.team3000.employeeRunner;
import com.collabera.team3000.Employee.*;


import com.collabera.team3000.employmentType.*;
import com.collabera.team3000.Department.*;
import com.collabera.team3000.utilities.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This program is an employee manager. One can create employees, delete employees, update employees
 * information and display all employees. One can also create and delete departments for the employees to be in.
 * @author joshe_000
 *
 */
public class EmployeeRunner {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException, ClassNotFoundException{

		ArrayList<Employee> employeeList=new ArrayList<Employee>();
		ArrayList<Department> departmentList=new ArrayList<Department>();
		Scanner scan = new Scanner(System.in);
		int option = 0;
		boolean validDepartmentId = false;
		boolean validEmploymentId = false;
		Department depart = new Department();

		//Records Actions
		File addEmployee = new File("C:\\Users\\joshe_000\\Desktop\\Employee Added.txt");
		FileOutputStream outstream = new FileOutputStream(addEmployee);
		FileInputStream inputstream = new FileInputStream(addEmployee);
		PrintWriter out = new PrintWriter(outstream,true);
		//Start of 1st code
		//Records Previous Data
		File employeeInfo = new File("C:\\Users\\joshe_000\\Desktop\\EmployeeInfo.txt");
		File departmentInfo = new File("C:\\Users\\joshe_000\\Desktop\\DepartmentInfo.txt");



		try {
			FileInputStream inEmployeeStream = new FileInputStream(employeeInfo);
			ObjectInputStream objectInputStream = new ObjectInputStream(inEmployeeStream);

			employeeList.addAll((ArrayList<Employee>) objectInputStream.readObject());
			objectInputStream.close();
			inEmployeeStream.close();

			FileInputStream inDepartmentStream = new FileInputStream(departmentInfo);
			ObjectInputStream departmentInputStream = new ObjectInputStream(inDepartmentStream);

			departmentList.addAll((ArrayList<Department>) departmentInputStream.readObject());
			departmentInputStream.close();
			inDepartmentStream.close();	
		}
		catch(Exception e) {
			System.out.println("Hello put in data please :)");
		}

		if(departmentList.isEmpty()) {
			depart.setDepartmentName("General");
			depart.setDepartmentId(departmentList.size()+1);
			departmentList.add(depart);
		}

		//End of second this code
		
		//int employeeCount = employeeList.size();
		int employeeCount = 0;
		if(employeeList.isEmpty())
			employeeCount = 0;
		else
			employeeCount = employeeList.get(employeeList.size()-1).getiD()+1;
		//int departmentListCount = departmentList.size()+1;
		int departmentListCount = departmentList.get(departmentList.size()-1).getDepartmentId()+1;

		// displays if managing employee or department
		while(true) {
			try {
				System.out.println("Select your option:\n1:Manage Employees\n2:Manage Departments\n3:"
						+ "Exit");
				option = scan.nextInt();
				scan.nextLine();

				//Manages Employee

				if(option == 1) {
					while(true) {
						System.out.println("Select your option:\n1:Add Employee\n2:Delete Employee\n3:Display All Employees"
								+ "\n4:Update Employee\n5:Display Single Employee\n6:Return to main menu");
						option = scan.nextInt();
						scan.nextLine();

						//Add Employee

						if(option == 1) {
							Employee employee = new Employee();

							employee.setName(Validation.checkString("Enter Employee Name","Please enter string value only",true));
							employee.setAge(Validation.checkInt("Enter Age", "Please enter integers only for Age"));
							
							employee.setAddress(addAddress());
							while(true) {
								option = Validation.checkInt("Input the number for the type of worker\n1:Full Time"
										+ "\n2:Contract\n3:Intern","Please enter integer value only");
								if(option == 1) {
									FullTime f = new FullTime();
									employee.setEmpType(f);
									break;
								}
								else if(option == 2) {
									Contract c = new Contract();
									employee.setEmpType(c);
									break;
								}
								else if(option == 3) {
									Intern i = new Intern();
									employee.setEmpType(i);
									break;
								}
								else
									System.out.println("Type in a number between 1-3");
							}
							while(true) {
								System.out.println("Input Department Id for the employee to be in: ");
								for(Department d : departmentList) {
									System.out.println("Department Id: " + d.getDepartmentId() + " "
											+ " Department Name: " + d.getDepartmentName());
								}
								option = Validation.checkInt("","Please enter Integer value only");
								for(Department d: departmentList) {
									if(d.getDepartmentId() == option) {
										validDepartmentId = true;
										employee.setDepartment(d);
										break;
									}	
									else {
										System.out.println("Put a valid ID number");
										validDepartmentId = false;
									}

								}
								if(validDepartmentId) 
									break;
							}

							employee.setEmployeeID(employeeCount+1);
							employeeList.add(employee);
							System.out.println("Employee Added\n" + employee.toString());
							employeeCount++;

							//Has a file where employee added is stored

							out.println("Employee Added\n" + employee.toString());


							//Sends email if employee is created

							//														SendMail smail=new SendMail();
							//														smail.from = "joshedx@gmail.com";
							//														smail.password = "roidmonsters";
							//														smail.to = "joshedx@gmail.com"; 
							//														smail.sub ="Employee";
							//														smail.msg = "Created Employee";
							//														smail.start();
							//														System.out.println("Employee ID: " + employee.getiD());
						}



						//Delete Employee 

						else if(option == 2) {
							if(employeeList.isEmpty())
								System.out.println("No Employees");
							else
								while(true) {
									System.out.println("Input Employee Id to Delete");
									for(Employee e : employeeList)
										System.out.println(e.toStringAll());
									System.out.println("Press 0 to cancel delete");
									option = Validation.checkInt("","Please enter Integer value only");
									for(Employee e : employeeList) {
										if(e.getiD() == option) {
											System.out.println("Deleted: " + e.toString());
											employeeList.remove(e);
											validEmploymentId = true;

											//Has a file where employee added is stored

											out.println("Employee Deleted\n" + e.toString());

											// sends email if employee is deleted

											//																		SendMail smail = new SendMail();
											//																		smail.from = "joshedx@gmail.com";
											//																		smail.password = "roidmonsters";
											//																		smail.to = "joshedx@gmail.com"; 
											//																		smail.sub ="Employee";
											//																		smail.msg = "Deleted Employee";
											//																		smail.start();

											break;
										}
									}	
									if(validEmploymentId)
										break;
									if(option == 0)
										break;
									else
										System.out.println("Didn't put a valid ID number try again");
								}
						}

						//Display All Employee

						else if(option == 3) {
							if(employeeList.isEmpty())
								System.out.println("No Employees");
							else
								for(Employee e : employeeList) {
									System.out.println(e.toStringAll());
								}

							//Has a file where it tells displays all

							out.println("Displayed All Employees");
						}

						//Update Employee

						else if(option ==4) {
							if(employeeList.isEmpty())
								System.out.println("No Employees");
							else
								while(true) {
									boolean validEmployeeId = false;
									System.out.print("Enter your ID: ");
									for(Employee e : employeeList) 
										System.out.println(e.toStringAll());
									option = Validation.checkInt("","Please enter Integer value only");
									for(Employee e : employeeList){
										if(e.getEmployeeID() == option) {
											validEmployeeId = true;
											System.out.println(e.toString());

											option = Validation.checkInt("Input the number which number's data would you like to update into employee database\n1:UpdateName"
													+ "\n2:Update Address\n3:Update Age\n4:Update Employement Type\n5:Update Departement","Please enter Integer value only");
											if(option == 1) {
												String name = Validation.checkString("Input new updated name", "Enter String Value only",true);
												e.setName(name);
												System.out.println("Updated name is " + e.getName());	

												//Updated employee name

												out.println("This employee's name was updated\n" + e.toStringAll());
												break;
											}

											else if(option == 2) {
												System.out.println("Input new updated Address");
												Address address = new Address();
												address.setCountry(Validation.checkString("Country: ", "Enter String Value only",true));
												address.setState(Validation.checkString("State : ", "Enter String Value only",true));
												address.setCity(Validation.checkString("City : ", "Enter String Value only",true));
												address.setZipCode(Validation.checkZip("Zip Code: ","Please enter right input."));
												e.setAddress(address);
												System.out.println("Updated Address is " + e.getAddress().toString());

												//Updated employee address

												out.println("This employee's address was updated\n" + e.toStringAll());
												break;
											}
											else if(option == 3) {
												int age = Validation.checkInt("Input new Age","Please enter Integer value only");
												e.setAge(age);
												System.out.println("Updated Age is " + e.getAge());

												//Updated employee age

												out.println("This employee's age was updated\n" + e.toStringAll());
												break;				
											}
											else if(option == 4) {
												while(true) {
													option = Validation.checkInt("Input the number for the type of worker\n1:Full Time\n" + 
															"2:Contract\n3:Intern","Please enter Integer value only");
													if(option == 1) {
														FullTime f = new FullTime();
														e.setEmpType(f);
														System.out.println("Updated Employee Type is " + e.getEmpType());	
														break;
													}
													else if(option == 2) {
														Contract c = new Contract();
														e.setEmpType(c);
														System.out.println("Updated Employee Type is " + e.getEmpType());	
														break;
													}
													else if(option == 3) {
														Intern intern = new Intern();
														e.setEmpType(intern);
														System.out.println("Updated Employee Type is " + e.getEmpType());	
														break;
													}
													else
														System.out.println("Type in a number between 1-3");
												}
												//Updated employee's employee type

												out.println("This employee's type was updated\n" + e.toStringAll());
												break;
											}
											else if(option == 5) {
												while(true) {
													System.out.println("Input new updated departement");
													for(Department d: departmentList) {
														System.out.println("Department Id: " + d.getDepartmentId() + " "
																+ " Department Name: " + d.getDepartmentName());
													}
													//Updated employee's department

													out.println("This employee's department was updated\n" + e.toStringAll());

													option = Validation.checkInt("","Please enter Integer value only");
													for(Department d: departmentList) {	
														if(d.getDepartmentId() == option) {
															validDepartmentId = true;
															e.setDepartment(d);
															break;
														}	
														else 
															validDepartmentId = false;


													}
													if(validDepartmentId) {
														System.out.println("Updated Employee Departement is " + e.getDepartment().toString());	
														break;
													}
													else   
														System.out.println("Put a valid ID number");
												}
											}
										}
										
									}
									if(validEmployeeId)
										break;
									else   
										System.out.println("Put a valid ID number");
								}

						}

						//Display Single Employee

						else if(option ==5) {
							if(employeeList.isEmpty())
								System.out.println("No Employees");
							else
								while(true) {
									System.out.println("Input Employee Id to Display");
									for(Employee e: employeeList)
										System.out.println(e.toStringAll());
									option = Validation.checkInt("","Please enter Integer value only");
									for(Employee e: employeeList) {
										if(e.getiD() == option) {
											System.out.println(e.toString());
											validEmploymentId = true;

											//Displayed single employee

											out.println("Displayed this employee" + e.toStringAll());
											break;
										}
									}	
									if(validEmploymentId)
										break;
									else
										System.out.println("Put a valid ID number");
								}
						}

						//Exit out of application

						else if(option ==6) {
							break;
						}

						else
							System.out.println("Type in a number between 1-6 -_-");
					}

				}

				//Manage Departments

				else if(option ==2) {
					while(true) {

						option = Validation.checkInt("Select your option\r\n" + 
								"1. Add \n2. Delete \n3. View Departments \n4. Return to main Menu","Please enter Integer value only");

						//add departments

						if(option ==1) {
							//	                Department dept = new Department();

							Department dept = new Department();
							dept.setDepartmentId(departmentListCount + 1);
							String name = Validation.checkString("Enter Department Name: ", "Enter String Value only",true);

							dept.setDepartmentName(name);

							departmentList.add(dept);
							System.out.println("Department Id:" + dept.getDepartmentId()
							+ " Department Name: " + dept.getDepartmentName());
							departmentListCount++;

							//Added Department

							out.println("Added this department:\n" + dept.toString());
						}

						//delete departments

						else if(option == 2) {
							while(true) {
								System.out.println("Enter Department ID: ");
								for(Department d: departmentList) {
									System.out.println(d.toString());
								}
								System.out.println("Press 0 to cancel delete");
								int deleteID = Validation.checkInt("","Please enter Integer value only");
								for(Department d: departmentList) {
									if(d.getDepartmentId() == deleteID && deleteID!= 1) {
										validDepartmentId = true;
										System.out.println("Deleted: " + d.toString());
										departmentList.remove(d);

										//Deleted Department

										out.println("Deleted this department:\n" + d.toString());
										break;
									}
									else if(deleteID ==1) {
										validDepartmentId = false;
										System.out.println("Can't delete general department");
									}
									else
										validDepartmentId = false;
								}
								if(validDepartmentId) 
									break;
								if(deleteID ==0)
									break;
								else {
									System.out.println("Didn't put a valid ID number try again");
								}
							}
						}
						//View departments

						else if(option == 3) {
							// student count
							for(Department e: departmentList) {
								System.out.println(e.toString());
							}
							System.out.println();
						}
						else if(option == 4)
							break;
						else
							System.out.println("Put a number between 1-4 -_-");
					}
				}

				// exit out application

				else if(option == 3) {

					//Start of second code
					FileOutputStream employeeStream = new FileOutputStream(employeeInfo);
					ObjectOutputStream objectOutputStream = new ObjectOutputStream(employeeStream);
					objectOutputStream.writeObject(employeeList);
					objectOutputStream.close();
					employeeStream.close();

					FileOutputStream departmentStream = new FileOutputStream(departmentInfo);
					ObjectOutputStream departmentOutputStream = new ObjectOutputStream(departmentStream);
					departmentOutputStream.writeObject(departmentList);
					departmentOutputStream.close();
					departmentStream.close();
					break;
					//end of second code
				}
				else
					System.out.println("Type a number between 1-3");
			}catch(InputMismatchException ie) {
				System.out.println("Type in an integer -_-");
				scan.nextLine();
			}
		}	
		
		outstream.close();
		out.flush();
		out.close();
		scan.close();
	}
	
	public static Address addAddress() {
		Address a = new Address();
		a.setCountry(Validation.checkString("Enter Country","Please enter string value only",true));
		a.setState(Validation.checkString("State:", "Enter String Value only",true));
		a.setCity(Validation.checkString("City:", "Enter String Value only",true));
		a.setZipCode((Validation.checkZip("Enter Zip Code", "Please enter right input.")));
		
		return a;
	}
}