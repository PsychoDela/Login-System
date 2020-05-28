package main;

import java.util.Scanner;

import dto.UserRegister;

public class Main 
{
	static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) 
	{
		start();
	}
	
	public static void start()
	{
		int choice;
		
		System.out.println("~~~Login System~~~");
		System.out.println("1) Login\n2) Register");
		
		choice = sc.nextInt();
		
		switch (choice)
		{
			case 1:
				login();
				break;
				
			case 2:
				register();
				break;
			
			default:
				errorMessage();
				break;
		}
	}
	
	public static void login()
	{
		String username, password;
		
		System.out.println("Enter username: ");
		username = enterText();
		
		System.out.println("Enter password: ");
		password = enterText();
	}
	
	public static void register()
	{
		String name, surname, username, password;
		
		System.out.println("Enter name: ");
		name = enterText();
		
		System.out.println("Enter surname: ");
		surname = enterText();
		
		System.out.println("Enter username: ");
		username = enterText();
		
		System.out.println("Enter password: ");
		password = enterText();
		
		UserRegister user = new UserRegister(name, surname, username, password);
	}
	
	public static void errorMessage()
	{
		System.out.println("Something went wrong. Please try again!");
		start();
	}
	
	public static String enterText()
	{
		return sc.next();
	}
}
