package com.masai.ui;

import java.util.Scanner;

import com.masai.dao.BrokerDaoImpl;
import com.masai.dao.CustomerDaoImpl;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomeThingWrongException;

public class Main {
	
	static void adminLogin(Scanner sc) {
		System.out.println("Hi Admin Please enter username or password");
		
		System.out.println("Enter username please");
		String username = sc.next();
		System.out.println("Enter password please");
		String password = sc.next();
		
		Admin.isAdmin(username, password);
	}
	
	
	static void userLogin(Scanner sc) {
		System.out.println("Hi Customer Please enter usenrame or password");
		
		System.out.println("Enter username please");
		String username = sc.next();
		System.out.println("Enter password please");
		String password = sc.next();
		
		User.isUser(username, password);
	}
	
	
	
	
		
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		BrokerDaoImpl bdi = new BrokerDaoImpl();
		CustomerDaoImpl cdi = new CustomerDaoImpl();
		
//		int choice = 0;
//		do {
//			System.out.println("1. Admin Login\n2. Customer Login\n0. Exit");
//			choice = sc.nextInt();
//			switch(choice) {
//				case 0:
//					System.out.println("Thank you, Visit again");
//					break;
//				case 1:
//					adminLogin(sc);
//					break;
//				case 2:
//					userLogin(sc);
//					break;
//				default:
//					System.out.println("Invalid Selection, try again");
//			}
//		}while(choice != 0);
//		sc.close();
		
		try {
			cdi.sellStock(2,2,5);
		} catch (SomeThingWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoRecordFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
		
		
	
}