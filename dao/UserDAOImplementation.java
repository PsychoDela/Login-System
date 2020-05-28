package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
				users.add(new UserRegister(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 0));
			}

		}

		return users;
	}
	
	public void addStudent(String name, String surname, String username, String password) throws SQLException 
	{
		String query = "INSERT INTO useri VALUES (?, ?, ?, ?)";

		try (PreparedStatement statement = connection.prepareStatement(query)) 
		{
			statement.setString(1, name);
			statement.setString(2, surname);
			statement.setString(3, username);
			statement.setString(4, password);

			statement.executeUpdate();

			System.out.println("User added to the database.");
		}
	}
}
