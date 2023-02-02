package com.pharmacy.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.pharmacy.model.Medicine;
import com.pharmacy.model.Order;
import com.pharmacy.model.OrderForm;
import com.pharmacy.model.User;
import com.pharmacy.services.OrderService;

@Controller
public class OrderController 
{
	@Autowired
	private OrderService orderService;
	
	public OrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	@RequestMapping(value = "/confirm-order", method = RequestMethod.GET)
	public ModelAndView confirmOrder(HttpSession session)
	{
		User user = (User)session.getAttribute("user");
		if(user == null)
		{
			new ModelAndView(new RedirectView("/login", true));
		}
		
		double total = Double.parseDouble(session.getAttribute("total").toString());
		List<Medicine> items = (List<Medicine>)session.getAttribute("cart");
		Order order = new Order();
		order.setOrderStatus(0);
		order.setTotalPrice(total);
		order.setUserEmail(user.getEmail());
		
		this.orderService.saveOrder(order, items);
		
		session.removeAttribute("cart");
		session.removeAttribute("total");
		session.setAttribute("cart", new ArrayList<Medicine>());
		return new ModelAndView("user/confirmOrder");
	}
	
	@RequestMapping(value = "/all-orders", method=RequestMethod.GET)
	public ModelAndView allOrders(HttpSession session,  Map<String, Object> model)
	{
		if(session.getAttribute("email") == null)
		{
			return new ModelAndView(new RedirectView("/login", true));
		}
		List<Order> list = this.orderService.getAll();
		model.put("list", list);
		return new ModelAndView("admin/allOrders");
	}
	
	@RequestMapping(value = "/update-order-status/{id}", method = RequestMethod.GET)
	public ModelAndView updateOrderStatus(@PathVariable("id") int id, HttpSession session)
	{
		if(session.getAttribute("email") == null)
		{
			return new ModelAndView(new RedirectView("/login", true));
		}
		this.orderService.updateOrderStatus(id, 1);
		return new ModelAndView(new RedirectView("/all-orders", true));
	}
	
	@RequestMapping(value = "/reject-order/{id}", method = RequestMethod.GET)
	public ModelAndView rejectOrder(@PathVariable("id") int id, HttpSession session)
	{
		if(session.getAttribute("email") == null)
		{
			return new ModelAndView(new RedirectView("/login", true));
		}
		this.orderService.updateOrderStatus(id, 2);
		return new ModelAndView(new RedirectView("/all-orders", true));
	}
	
	@RequestMapping(value = "/cancel-order/{id}", method = RequestMethod.GET)
	public ModelAndView cancelOrder(@PathVariable("id") int id, HttpSession session)
	{
		if(session.getAttribute("user") == null)
		{
			return new ModelAndView(new RedirectView("/login", true));
		}
		this.orderService.updateOrderStatus(id, 3);
		return new ModelAndView(new RedirectView("/my-orders", true));
	}
	
	@RequestMapping(value = "/my-orders", method = RequestMethod.GET)
	public ModelAndView myOrders(HttpSession session, Map<String, Object> model)
	{
		User user = (User) session.getAttribute("user");
		if(user == null)
		{
			return new ModelAndView(new RedirectView("/login", true));
		}
		
		List<Order> list = this.orderService.getAllByUser(user.getEmail());
		model.put("list", list);
		return new ModelAndView("user/myOrders");
	}
	
	@RequestMapping(value = "update-order/{id}", method = RequestMethod.GET)
	public ModelAndView updateOrderPage(@PathVariable("id") int id, HttpSession session, Map<String, Object> model)
	{
		if(session.getAttribute("email") == null)
		{
			return new ModelAndView(new RedirectView("/login"));
		}
		Order order = this.orderService.getOrderById(id);
		OrderForm orderForm = new OrderForm();
		orderForm.setItems(order.getItems());
		orderForm.setOrderDate(order.getOrderDate());
		orderForm.setOrderId(order.getOrderId());
		orderForm.setOrderStatus(order.getOrderStatus());
		orderForm.setTotalPrice(order.getTotalPrice());
		orderForm.setUserEmail(order.getUserEmail());
		model.put("orderForm", orderForm);
		return new ModelAndView("admin/updateOrder");
	}
	
	@RequestMapping(value = "update-order", method = RequestMethod.POST)
	public ModelAndView updateOrder(OrderForm orderForm)
	{
		Order order = new Order();
		order.setItems(orderForm.getItems());
		order.setOrderDate(orderForm.getOrderDate());
		order.setOrderId(orderForm.getOrderId());
		order.setOrderStatus(orderForm.getOrderStatus());
		order.setTotalPrice(orderForm.getTotalPrice());
		order.setUserEmail(orderForm.getUserEmail());
		
		this.orderService.updateOrder(order);
		
		return new ModelAndView(new RedirectView("/all-orders", true));
	}
	
	@RequestMapping(value = "/update-my-order/{id}", method = RequestMethod.GET)
	public ModelAndView updateMyOrder(@PathVariable("id") int id, HttpSession session, Map<String, Object> model)
	{
		if(session.getAttribute("user") == null)
		{
			return new ModelAndView(new RedirectView("/login", true));
		}
		Order order = this.orderService.getOrderById(id);
		OrderForm orderForm = new OrderForm();
		orderForm.setItems(order.getItems());
		orderForm.setOrderDate(order.getOrderDate());
		orderForm.setOrderId(order.getOrderId());
		orderForm.setOrderStatus(order.getOrderStatus());
		orderForm.setTotalPrice(order.getTotalPrice());
		orderForm.setUserEmail(order.getUserEmail());
		model.put("orderForm", orderForm);
		
		return new ModelAndView("user/updateOrder");
	}
	
	@RequestMapping(value = "/update-my-order", method = RequestMethod.POST)
	public ModelAndView updateMyOrderDetails(OrderForm orderForm)
	{
		Order order = new Order();
		order.setItems(orderForm.getItems());
		order.setOrderDate(orderForm.getOrderDate());
		order.setOrderId(orderForm.getOrderId());
		order.setOrderStatus(orderForm.getOrderStatus());
		order.setTotalPrice(orderForm.getTotalPrice());
		order.setUserEmail(orderForm.getUserEmail());
		
		this.orderService.updateOrder(order);
		
		return new ModelAndView(new RedirectView("/my-orders", true));
	}
}
