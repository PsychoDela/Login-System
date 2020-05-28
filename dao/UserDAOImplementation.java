package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.UserRegister;

public class UserDAOImplementation 
{
	Connection connection = ConnectionManager.getInstance().getConnection();

	public ArrayList <UserRegister> getUsers() throws SQLException {

		ArrayList <UserRegister> users = new ArrayList <UserRegister> ();

		String query = "SELECT * FROM useri";

		ResultSet rs = null;

		try (Statement statement = connection.createStatement()) 
		{
			rs = statement.executeQuery(query);

			while (rs.next()) 
			{
				users.add(new UserRegister(rs.getString("Ime"), rs.getString("Prezime"), rs.getString("Username"), rs.getString("Password")));

				System.out.println("User: " + rs.getString("Ime") + " added to students.");
			}

		}

		return users;
	}
}
