package com.pharmacy.repos;

import java.util.List;

import com.pharmacy.model.Order;


public interface OrderRespository 
{
	Order getOrderById(int id);
	List<Order> getAll();
	List<Order> getAllByUser(String email);
	Order updateOrder(Order order);
	boolean deleteOrder(int id);
	boolean updateOrderStatus(int id, int status);
	Order saveOrder(Order order);
}
