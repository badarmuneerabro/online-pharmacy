package com.pharmacy.repos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pharmacy.helper.Connect;
import com.pharmacy.model.Order;

@Repository
public class OrderRespositoryImp implements OrderRespository 
{

	@Override
	public Order getOrderById(int id) 
	{
		String query = "SELECT * FROM ORDER_DETAILS WHERE ORDER_ID=?;";
		PreparedStatement statement = Connect.getInstance().getPreparedStatement(query);
		try {
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			if(rs.next())
			{
				Order order = new Order();
				order.setOrderId(id);
				order.setOrderStatus(rs.getInt("ORDER_STATUS"));
				order.setUserEmail(rs.getString("ORDERED_BY"));
				order.setOrderDate(rs.getString("ORDER_DATE"));
				order.setItems(rs.getString("items"));
				order.setTotalPrice(rs.getDouble("total_price"));
				return order;
				
			}
		} catch (SQLException e) 
		{
			System.out.println("ERROR: " + e.getMessage() + " in getting order by id.");
		}
		return null;
	}

	@Override
	public List<Order> getAll() 
	{
		List<Order> list = new ArrayList<>();
		String query = "SELECT * FROM ORDER_DETAILS;";
		PreparedStatement statement = Connect.getInstance().getPreparedStatement(query);
		try {
			ResultSet rs = statement.executeQuery();
			while(rs.next())
			{
				Order order = new Order();
				order.setOrderId(rs.getInt("ORDER_ID"));
				order.setOrderStatus(rs.getInt("ORDER_STATUS"));
				order.setUserEmail(rs.getString("ORDERED_BY"));
				order.setOrderDate(rs.getString("ORDER_DATE"));
				order.setItems(rs.getString("items"));
				order.setTotalPrice(rs.getDouble("total_price"));
				list.add(order);
			}
		} catch (SQLException e) 
		{
			System.out.println("ERROR: " + e.getMessage() + " in getting all orders");
		}
		return list;
	}

	@Override
	public Order updateOrder(Order order) 
	{
		String query = "UPDATE ORDER_DETAILS SET TOTAL_PRICE=?, ITEMS=?, ORDER_STATUS=?, ORDERED_BY=?, ORDER_DATE=? WHERE ORDER_ID=?;";
		PreparedStatement statement = Connect.getInstance().getPreparedStatement(query);
		try {
			statement.setDouble(1, order.getTotalPrice());
			statement.setString(2, order.getItems());
			statement.setInt(3, order.getOrderStatus());
			statement.setString(4, order.getUserEmail());
			statement.setString(5, order.getOrderDate());
			statement.setInt(6, order.getOrderId());
			statement.executeUpdate();
			return order;
		} catch (SQLException e) {
			System.out.println("ERROR: " + e.getMessage() + " in updating order details.");
		}
		return null;
	}

	@Override
	public boolean deleteOrder(int id) 
	{
		String query = "DELETE FROM ORDER_DETAILS WHERE ORDER_ID=?;";
		PreparedStatement statement = Connect.getInstance().getPreparedStatement(query);
		try {
			statement.setInt(1, id);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) 
		{
			System.out.println("ERROR: " + e.getMessage() + " in deleting order.");
		}
		return false;
	}
	
	@Override
	public boolean updateOrderStatus(int id, int status) 
	{
		String query = "UPDATE ORDER_DETAILS SET ORDER_STATUS=? WHERE ORDER_ID=?;";
		PreparedStatement statement = Connect.getInstance().getPreparedStatement(query);
		try {
			System.out.println("id="+ id + ",status=" + status);
			statement.setInt(1, status);
			statement.setInt(2, id);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) 
		{
			System.out.println("ERROR: " + e.getMessage() + " in updating order status");
		}
		
		return false;
	}
	
	@Override
	public List<Order> getAllByUser(String email) 
	{
		List<Order> list = new ArrayList<>();
		String query = "SELECT * FROM ORDER_DETAILS WHERE ORDERED_BY=?;";
		PreparedStatement statement = Connect.getInstance().getPreparedStatement(query);
		try {
			statement.setString(1, email);
			ResultSet rs = statement.executeQuery();
			while(rs.next())
			{
				Order order = new Order();
				order.setOrderId(rs.getInt("ORDER_ID"));
				order.setOrderStatus(rs.getInt("ORDER_STATUS"));
				order.setUserEmail(rs.getString("ORDERED_BY"));
				order.setOrderDate(rs.getString("ORDER_DATE"));
				order.setItems(rs.getString("items"));
				order.setTotalPrice(rs.getDouble("total_price"));
				list.add(order);
				
			}
		} catch (SQLException e) 
		{
			System.out.println("ERROR: " + e.getMessage() + " in getting all orders");
		}
		return list;
	}
	
	@Override
	public Order saveOrder(Order order) 
	{
		String query = "INSERT INTO ORDER_DETAILS(ORDER_DATE, ORDERED_BY, ORDER_STATUS, ITEMS, TOTAL_PRICE) VALUES(?, ?, ?, ?, ?);";
		PreparedStatement statement = Connect.getInstance().getPreparedStatement(query);
		try {
			statement.setString(1, order.getOrderDate());
			statement.setString(2, order.getUserEmail());
			statement.setInt(3, order.getOrderStatus());
			statement.setString(4, order.getItems());
			statement.setDouble(5, order.getTotalPrice());
			statement.executeUpdate();
			return order;
		} catch (SQLException e) {
			System.out.println("ERROR: " + e.getMessage() + " in inserting order.");
		}
		
		return null;
	}
	
	
}
