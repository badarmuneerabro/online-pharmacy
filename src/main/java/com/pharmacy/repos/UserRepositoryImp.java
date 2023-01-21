package com.pharmacy.repos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.pharmacy.helper.Connect;
import com.pharmacy.model.User;

@Repository
public class UserRepositoryImp implements UserRepository {

	public User getUserByEmail(String email)
	{
		String query = "SELECT * FROM USER_DETAILS WHERE EMAIL=?;";
		PreparedStatement statement = Connect.getInstance().getPreparedStatement(query);
		try {
			statement.setString(1, email);
			ResultSet rs = statement.executeQuery();
			if(rs.next())
			{
				User user = new User();
				user.setEmail(email);
				user.setFirstName(rs.getString("FIRST_NAME"));
				user.setLastName(rs.getString("LAST_NAME"));
				user.setAddress(rs.getString("ADDRESS"));
				user.setPassword(rs.getString("PASSWORD"));
				
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public User getUserByEmailAndPassword(String email, String password)
	{
		String query = "SELECT * FROM USER_DETAILS WHERE EMAIL=? AND PASSWORD=?;";
		PreparedStatement statement = Connect.getInstance().getPreparedStatement(query);
		try {
			statement.setString(1, email);
			statement.setString(2, password);
			ResultSet rs = statement.executeQuery();
			if(rs.next())
			{
				User user = new User();
				user.setEmail(email);
				user.setFirstName(rs.getString("FIRST_NAME"));
				user.setLastName(rs.getString("LAST_NAME"));
				user.setAddress(rs.getString("ADDRESS"));
				user.setPassword(rs.getString("PASSWORD"));
				
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<User> getAllUsers() 
	{
		List<User> list = new ArrayList<>();
		PreparedStatement statement = Connect.getInstance().getPreparedStatement("SELECT * FROM USER_DETAILS;");
		try {
			ResultSet rs = statement.executeQuery();
			
			while(rs.next())
			{
				User user = new User();
				user.setEmail(rs.getString("EMAIL"));
				user.setFirstName(rs.getString("FIRST_NAME"));
				user.setLastName(rs.getString("LAST_NAME"));
				user.setAddress(rs.getString("ADDRESS"));
				user.setPassword(rs.getString("PASSWORD"));
				
				list.add(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public User saveUser(User user)
	{
		String query = "INSERT INTO USER_DETAILS(EMAIL, FIRST_NAME, LAST_NAME, ADDRESS, PASSWORD) VALUES(?,?,?,?,?);";
		PreparedStatement statement = Connect.getInstance().getPreparedStatement(query);
		
		try {
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getFirstName());
			statement.setString(3, user.getLastName());
			statement.setString(4, user.getAddress());
			statement.setString(5, user.getPassword());
			statement.executeUpdate();
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public User updateUser(User user) 
	{
		String query = "UPDATE USER_DETAILS SET FIRST_NAME=?, LAST_NAME=?, ADDRESS=?, PASSWORD=? WHERE EMAIL=?;";
		PreparedStatement statement = Connect.getInstance().getPreparedStatement(query);
		try {
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setString(3, user.getAddress());
			statement.setString(4, user.getPassword());
			statement.setString(5, user.getEmail());
			statement.executeUpdate();
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int deleteUser(String email) 
	{
		String query = "DELETE FROM USER_DETAILS WHERE EMAIL=?;";
		PreparedStatement statement = Connect.getInstance().getPreparedStatement(query);
		try {
			statement.setString(1, email);
			return statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
