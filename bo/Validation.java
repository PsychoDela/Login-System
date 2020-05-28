package bo;

import dao.UserDAOImplementation;
import main.Main;

public class Validation 
{
	public static boolean userRegisterValidation(String username)
	{
		UserDAOImplementation user = new UserDAOImplementation();
		
		try
		{
			for (int i = 0; i < user.getUsers().size(); i++)
			{
				if (username.equals(user.getUsers().get(i).getUsername()))
				{
					return false;
				}
			}
		}
		
		catch (Exception e)
		{
			System.out.println(e);
			Main.errorMessage();
		}
	
		return true;
	}
}
