package dto;

import bo.Validation;
import main.Main;

public class UserRegister 
{
	private String name;
	private String surname;
	private String username;
	private String password;
	private boolean validationPassed;
	
	public UserRegister(String name, String surname, String username, String password) 
	{
		setName(name);
		setSurname(surname);
		setUsername(username);
		setPassword(password);
		setValidationPassed(true);
	}
	
	public UserRegister(String name, String surname, String username, String password, int num) 
	{
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.password = password;
		setValidationPassed(true);
	}

	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getSurname() 
	{
		return surname;
	}
	
	public void setSurname(String surname) 
	{
		this.surname = surname;
	}
	
	public String getUsername() 
	{
		return username;
	}
	
	public void setUsername(String username) 
	{
		if (Validation.usernameRegisterValidation(username) == true)
		{
			this.username = username;
		}
		
		else
		{
			Main.errorMessage();
		}
	}
	
	public String getPassword() 
	{
		return password;
	}
	
	public void setPassword(String password) 
	{
		if (Validation.passwordLengthValidation(password) == true)
		{
			this.password = password;
		}
		
		else
		{
			Main.errorMessage();
		}
	}
	
	public boolean isValidationPassed() 
	{
		return validationPassed;
	}
	
	public void setValidationPassed(boolean validationPassed) 
	{
		this.validationPassed = validationPassed;
	}
}
