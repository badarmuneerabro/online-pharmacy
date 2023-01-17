package com.pharmacy.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.pharmacy.model.LoginForm;
import com.pharmacy.model.User;
import com.pharmacy.services.UserService;

@Controller
@RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
public class LoginController 
{
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginPage(HttpSession session, @ModelAttribute("loginForm") LoginForm loginForm)
	{
		User user = (User) session.getAttribute("user");
		String email = (String) session.getAttribute("email");
		if(email != null)
		{
			return "admin/home";
		}
		else if(user != null)
		{
			return "user/home";
		}
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("loginForm") LoginForm loginForm, HttpSession session, HttpServletRequest request)
	{
		if(loginForm.getEmail().equals("admin@system.com") || loginForm.getPassword().equals("secret"))
		{
			session.setAttribute("email", loginForm.getEmail());
			request.changeSessionId();
			return "admin/home";
		}
		
		User user = this.userService.getUserByEmail(loginForm.getEmail());
		if(user != null)
		{
			session.setAttribute("user", user);
			return "user/home";
		}
		
		
		return "login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public View logout(HttpSession session)
	{
		session.invalidate();
		return new RedirectView("/", true);
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
