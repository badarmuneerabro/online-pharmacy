package com.pharmacy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacy.model.Medicine;
import com.pharmacy.model.Order;
import com.pharmacy.repos.OrderRespository;

@Service
public class OrderServiceImp implements OrderService {

	@Autowired
	private OrderRespository orderRespository;
	@Override
	public Order getOrderById(int id) 
	{
		return this.orderRespository.getOrderById(id);
	}

	@Override
	public List<Order> getAll() 
	{
		
		return this.orderRespository.getAll();
	}

	@Override
	public List<Order> getAllByUser(String email) 
	{
		return this.orderRespository.getAllByUser(email);
	}

	@Override
	public Order updateOrder(Order order) 
	{
		return this.orderRespository.updateOrder(order);
	}

	@Override
	public boolean deleteOrder(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateOrderStatus(int id, int status) 
	{
		return this.orderRespository.updateOrderStatus(id, status);
	}

	@Override
	public Order saveOrder(Order order, List<Medicine> items) 
	{
		StringBuffer strItems = new StringBuffer();
		if(items.size() != 0)
		{
			Medicine m = items.get(0);
			strItems.append(m.getQuantity() + m.getName());
		}
		
		for(int i = 1; i < items.size(); i++)
		{
			strItems.append("," + items.get(i).getQuantity() +  items.get(i).getName());
		}
		order.setItems(strItems.toString());
		return this.orderRespository.saveOrder(order);
	}

	public OrderRespository getOrderRespository() {
		return orderRespository;
	}

	public void setOrderRespository(OrderRespository orderRespository) {
		this.orderRespository = orderRespository;
	}

}
