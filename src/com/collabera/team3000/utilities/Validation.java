package com.collabera.team3000.utilities;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validation {

	// this class reads the data from user




	public static int checkInt(String gretingMsg, String exceptionMsg) {
		Scanner scan =new Scanner(System.in);
		int val;
		while(true) {
			try {
				System.out.println(gretingMsg);
				val=scan.nextInt();
				scan.nextLine();
				break;

			}
			catch(InputMismatchException ex) {
				System.out.println(exceptionMsg);
				//            continue;
				scan.next();
			}
		}
		return  val;
	}

	public static String checkString(String gretingMsg, String exceptionMsg) {
		Scanner scan =new Scanner(System.in);
		String val;
		while(true) {
			try {
				System.out.println(gretingMsg);
				val=scan.nextLine();
				break;

			}
			catch(InputMismatchException ex) {
				System.out.println(exceptionMsg);
				//            continue;
			}
		}
		return  val;
	}

	public static String checkString(String gretingMsg, String exceptionMsg, boolean noNumbers) {
		Scanner scan =new Scanner(System.in);
		String val;
		while(true) {
			try {
				System.out.println(gretingMsg);
				val=scan.nextLine();
				if(noNumbers) {
					if( hasNumbers(val)) {        		
						System.out.println("Numbers Not Allowed");
						continue;
					}
				}
				break;

			}
			catch(InputMismatchException ex) {
				System.out.println(exceptionMsg);
				//            continue;
			}
		}
		return  val;
	}

	private static boolean hasNumbers(String val) {

		return !val.matches ("[a-zA-Z]+\\.?");
	}

//	public static int checkZip(String gretingMsg, String exceptionMsg) {
//
//		Scanner scan =new Scanner(System.in);
//		int val;
//		String s;
//		while(true) {
//			try {
//				System.out.println(gretingMsg);
//				s = scan.nextLine();
//				val = Integer.parseInt(s);
//				if(s.length() != 5) {
//					System.out.println("Not a valid Zip code");
//					continue;
//				}
//				else 
//					break;	
//			}
//			catch(InputMismatchException ex) {
//				System.out.println(exceptionMsg);
//			}
//			catch(NumberFormatException ex) {
//				System.out.println(exceptionMsg);	
//			}	
//		}
//		return  val;
//	}
	public static String checkZip(String gretingMsg, String exceptionMsg) {
		Scanner scan =new Scanner(System.in);
		String val;
		while(true) {
				System.out.println(gretingMsg);
				val=scan.nextLine();
				String regex = "\\d{5}";
				if(val.matches(regex)) {
					break;
				}
				else 
					System.out.println(exceptionMsg);

		}
		return  val;
	}

}