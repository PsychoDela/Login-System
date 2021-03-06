package main;

import java.util.Scanner;

import dao.UserDAOImplementation;
import dto.UserLogin;
import dto.UserRegister;

public class Main 
{
	static Scanner sc = new Scanner (System.in);
	static String nowLoggedIn = "";
	
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
		
		UserLogin user = new UserLogin(username, password);
		
		if (user.isValidationPassed() == true)
		{
			System.out.println("Successfully logged in!");
			nowLoggedIn = username;
			options();
		}
		
		else
		{
			errorMessage();
		}
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
		
		if (user.isValidationPassed() == true)
		{
			try
			{
				UserDAOImplementation addData = new UserDAOImplementation();
				addData.addUser(name, surname, username, password);
				System.out.println("Registered successfully!");
				start();
			}
			
			catch (Exception e)
			{
				System.out.println(e);
				errorMessage();
			}
		}
		
		else
		{
			errorMessage();
		}
	}
	
	public static void options()
	{
		int choice;
		
		System.out.println("~~~Options~~~");
		System.out.println("1) Change name\n2) Delete account");
		
		choice = sc.nextInt();
		
		switch (choice)
		{
			case 1:
				changeName();
				break;
				
			case 2:
				deleteAcc();
				break;
				
			default:
				errorMessage();
				break;
		}
	}
	
	public static void changeName()
	{
		String name, surname;
		
		System.out.println("Enter new name: ");
		name = enterText();
		
		System.out.println("Enter new surname: ");
		surname = enterText();
			
		try
		{
			UserDAOImplementation user = new UserDAOImplementation();
			user.updateUser(name, surname, nowLoggedIn);
			start();
		}
		
		catch (Exception e)
		{
			System.out.println(e);
			start();
		}
	}
	
	public static void deleteAcc()
	{
		int choice;
		
		System.out.println("Are you sure you want to delete your account? This action is irreversible.");
		System.out.println("1) YES\n2) NO");
		
		choice = sc.nextInt();
		
		switch (choice)
		{
			case 1:
				deleteFinal();
				break;
			
			default:
				start();
				break;
		}
	}
	
	public static void deleteFinal()
	{
		try
		{
			UserDAOImplementation user = new UserDAOImplementation();
			user.deleteUser(nowLoggedIn);
			start();
		}
		
		catch (Exception e)
		{
			System.out.println(e);
			start();
		}
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
