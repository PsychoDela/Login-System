package dto;

import bo.Validation;
import main.Main;

public class UserLogin 
{
	private String username;
	private String password;
	private boolean validationPassed;
	
	public UserLogin(String username, String password) 
	{
		setUsername(username);
		setPassword(username, password);
		setValidationPassed(true);
	}

	public String getUsername() 
	{
		return username;
	}
	
	public void setUsername(String username) 
	{
		if (Validation.usernameLoginValidation(username) == true)
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
	
	public void setPassword(String username, String password) 
	{
		if (Validation.passwordValidation(username, password))
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
