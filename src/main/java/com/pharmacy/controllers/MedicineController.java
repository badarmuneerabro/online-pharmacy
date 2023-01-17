package com.pharmacy.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pharmacy.model.LoginForm;
import com.pharmacy.model.Medicine;
import com.pharmacy.model.User;
import com.pharmacy.services.MedicineService;

@Controller
@RequestMapping(value = "/medicine", method = {RequestMethod.GET, RequestMethod.POST})
public class MedicineController 
{
	@Autowired
	private MedicineService medicineService;
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String viewMedicines(HttpSession session, Map<String, Object> model)
	{
		User user = (User) session.getAttribute("user");
		String email = (String) session.getAttribute("email");
		
		//List<Medicine> list = this.getMedicineService().getAll();
		//model.put("list", list);
		
		if(email != null)
		{
			
			return "admin/view";
		}
		else if(user != null)
		{
			return "user/userView";
		}
		
		return "login";
	}

	public MedicineService getMedicineService() {
		return medicineService;
	}

	public void setMedicineService(MedicineService medicineService) {
		this.medicineService = medicineService;
	}
}
