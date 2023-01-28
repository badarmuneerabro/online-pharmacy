package com.pharmacy.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.hibernate.validator.Incubating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.pharmacy.model.User;
import com.pharmacy.model.UserForm;
import com.pharmacy.services.UserService;

@Controller
public class UserController 
{
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/user-list", method = RequestMethod.GET)
	public ModelAndView view(HttpSession session, Map<String, Object> model)
	{
		if(session.getAttribute("email") != null)
		{
			List<User> list = userService.getAllUsers();
			System.out.println("Size of user list: " + list.size());
			model.put("list", list);
			return new ModelAndView("admin/user-list");
		}
			
		return new ModelAndView(new RedirectView("/login", true));
	}
	
	@RequestMapping(value = "/add-user", method = RequestMethod.GET)
	public ModelAndView addUser(HttpSession session, @ModelAttribute("user") UserForm userForm)
	{
		if(session.getAttribute("email") != null)
		{
			return new ModelAndView("admin/addUser");
		}
		
		return new ModelAndView(new RedirectView("/login", true));
	}
	
	@RequestMapping(value = "/save-user", method = RequestMethod.POST)
	public ModelAndView addUser(UserForm userForm)
	{
		User user = new User();
		user.setEmail(userForm.getEmail());
		user.setFirstName(userForm.getFirstName());
		user.setLastName(userForm.getLastName());
		user.setPassword(userForm.getPassword());
		user.setAddress(userForm.getAddress());
		
		this.userService.saveUser(user);
		return new ModelAndView(new RedirectView("/user-list", true));
	}
	
	@RequestMapping(value = "/edit-user/{email}", method = RequestMethod.GET)
	public ModelAndView updateUser(@PathVariable("email") String email, Map<String, Object> model)
	{
		User user = this.userService.getUserByEmail(email);
		UserForm userForm = new UserForm();
		userForm.setAddress(user.getAddress());
		userForm.setEmail(user.getEmail());
		userForm.setFirstName(user.getFirstName());
		userForm.setLastName(user.getLastName());
		userForm.setPassword(user.getPassword());
		model.put("user", userForm);
		
		return new ModelAndView("admin/updateUser");
	}

	@RequestMapping(value = "/update-user", method = RequestMethod.POST)
	public ModelAndView updateUser(UserForm userForm)
	{
		User user = new User();
		user.setEmail(userForm.getEmail());
		user.setFirstName(userForm.getFirstName());
		user.setLastName(userForm.getLastName());
		user.setPassword(userForm.getPassword());
		user.setAddress(userForm.getAddress());
		this.userService.updateUser(user);
		return new ModelAndView(new RedirectView("/user-list", true));
	}
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signupPage(@ModelAttribute("user") UserForm userForm)
	{
		return new ModelAndView("register");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(UserForm userForm)
	{
		User user = new User();
		user.setEmail(userForm.getEmail());
		user.setFirstName(userForm.getFirstName());
		user.setLastName(userForm.getLastName());
		user.setPassword(userForm.getPassword());
		user.setAddress(userForm.getAddress());
		
		this.userService.saveUser(user);
		
		return new ModelAndView(new RedirectView("/login", true));
	}
	
	@RequestMapping(value = "delete-user/{email}")
	public ModelAndView deleteUser(@PathVariable("email") String email)
	{
		this.userService.deleteUser(email);
		return new ModelAndView(new RedirectView("/user-list", true));
	}
	
	@RequestMapping(value = "/update-profile/{email}", method = RequestMethod.GET)
	public ModelAndView editProfile(@PathVariable("email") String email, Map<String, Object> model)
	{
		User user = this.userService.getUserByEmail(email);
		UserForm userForm = new UserForm();
		userForm.setAddress(user.getAddress());
		userForm.setEmail(user.getEmail());
		userForm.setFirstName(user.getFirstName());
		userForm.setLastName(user.getLastName());
		userForm.setPassword(user.getPassword());
		model.put("user", userForm);
		
		return new ModelAndView("user/editProfile");
	}
	
	@RequestMapping(value = "/edit-profile", method = RequestMethod.POST)
	public ModelAndView updateProfile(UserForm userForm)
	{
		User user = new User();
		user.setEmail(userForm.getEmail());
		user.setFirstName(userForm.getFirstName());
		user.setLastName(userForm.getLastName());
		user.setPassword(userForm.getPassword());
		user.setAddress(userForm.getAddress());
		this.userService.updateUser(user);
		
		return new ModelAndView(new RedirectView("/home", true));
	}
	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public ModelAndView showCart(HttpSession session)
	{
		if(session.getAttribute("user") == null)
		{
			new ModelAndView(new RedirectView("/login", true));
		}
		System.out.println("User is present");
		return new ModelAndView("user/cart");
	}
	
	@RequestMapping(value = "/confirm-order", method = RequestMethod.GET)
	public ModelAndView confirmOrder(HttpSession session)
	{
		if(session.getAttribute("user") == null)
		{
			new ModelAndView(new RedirectView("/login", true));
		}
		
		session.removeAttribute("cart");
		session.removeAttribute("total");
		
		return new ModelAndView("user/confirmOrder");
	}
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
