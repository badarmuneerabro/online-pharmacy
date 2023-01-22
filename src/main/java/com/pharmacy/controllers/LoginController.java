package com.pharmacy.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.pharmacy.model.LoginForm;
import com.pharmacy.model.Medicine;
import com.pharmacy.model.User;
import com.pharmacy.services.UserService;

@Controller
public class LoginController 
{
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public View home(HttpSession session)
	{
		User user = (User) session.getAttribute("user");
		String email = (String) session.getAttribute("email");
		if(user != null)
		{
			return new RedirectView("/home", true);
		}
		
		else if(email != null)
		{
			// redirect to admin home page
			return new RedirectView("/home", true);
		}
		
		return new RedirectView("/login", true);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(@ModelAttribute("loginForm") LoginForm form)
	{
		return "login";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView homePage(HttpSession session)
	{
		User user = (User) session.getAttribute("user");
		String email = (String) session.getAttribute("email");
		if(user != null)
		{
			return new ModelAndView("user/home");
		}
		
		else if(email != null)
		{
			// redirect to admin home page
			return new ModelAndView("admin/home");
		}
		
		return new ModelAndView(new RedirectView("/login", true));
	}
	@RequestMapping(value = "/process-login", method = RequestMethod.POST)
	public ModelAndView home(HttpServletRequest request, LoginForm loginForm)
	{
		if(loginForm.getEmail().equals("admin@system.com") && loginForm.getPassword().equals("secret"))
		{
			HttpSession session = request.getSession();
			session.setAttribute("email", loginForm.getEmail());
			request.changeSessionId();
			
			return new ModelAndView(new RedirectView("/home", true));
		}
		
		User user = this.userService.getUserByEmailAndPassword(loginForm.getEmail(), loginForm.getPassword());
		
		if(user != null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			session.setAttribute("cart", new ArrayList<Medicine>());
			request.changeSessionId();
			return new ModelAndView(new RedirectView("/home", true));
		}
		
		return new ModelAndView(new RedirectView("/login", true));
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public View logout(HttpServletRequest request)
	{
		request.getSession().invalidate();
		return new RedirectView("/", true);
	}
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
