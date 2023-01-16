package com.pharmacy.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pharmacy.model.LoginForm;

@Controller
@RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
public class LoginController 
{
	
	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public String loginPage(HttpSession session, @ModelAttribute("loginForm") LoginForm loginForm)
	{
		if(session.getAttribute("email") != null)
		{
			return "home";
		}
		
		
		return "login";
	}
	
	@RequestMapping(value = "/UserLogin", method = RequestMethod.POST)
	public String login(@ModelAttribute("loginForm") LoginForm loginForm)
	{
		if(loginForm.getEmail().equals("admin@system.com") && loginForm.getPassword().equals("secret"))
		{
			return "admin/home";
		}
		return "user/home";
	}
}
