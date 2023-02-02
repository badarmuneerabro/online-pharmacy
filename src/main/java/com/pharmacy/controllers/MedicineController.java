package com.pharmacy.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.pharmacy.model.LoginForm;
import com.pharmacy.model.Medicine;
import com.pharmacy.model.MedicineForm;
import com.pharmacy.model.User;
import com.pharmacy.services.MedicineService;

@Controller
public class MedicineController {
	@Autowired
	private MedicineService medicineService;

	@RequestMapping(value = "/view-medicine", method = RequestMethod.GET)
	public ModelAndView viewMedicines(HttpSession session, Map<String, Object> model) {
		User user = (User) session.getAttribute("user");
		String email = (String) session.getAttribute("email");
		List<Medicine> list = this.getMedicineService().getAll();
		model.put("list", list);
		System.out.println("Size=" + list.size());
		if (email != null) {
			return new ModelAndView("admin/view");
		} else if (user != null) {
			return new ModelAndView("user/userView");
		}
		
		return new ModelAndView(new RedirectView("/login", true));
	}

	@RequestMapping(value = "/add-medicine", method = RequestMethod.GET)
	public ModelAndView addForm(@ModelAttribute("medicine") MedicineForm form, HttpSession session) {
		User user = (User) session.getAttribute("user");
		String email = (String) session.getAttribute("email");

		if (email == null) 
		{

			return new ModelAndView(new RedirectView("/login", true));
		}
		return new ModelAndView("admin/addMedicine");
	}

	@RequestMapping(value = "/save-medicine", method = RequestMethod.POST)
	public ModelAndView saveMedicine(MedicineForm form, HttpSession session) {
//		User user = (User) session.getAttribute("user");
		String email = (String) session.getAttribute("email");
		
		if (email == null) 
		{

			return new ModelAndView(new RedirectView("/login", true));
		}

		Medicine medicine = new Medicine();
		medicine.setCatgory(form.getCatgory());
		medicine.setCompany(form.getCompany());
		medicine.setCost(form.getCost());
		medicine.setName(form.getName());
		medicine.setDescription(form.getDescription());

		this.medicineService.saveMedicine(medicine);

		return new ModelAndView(new RedirectView("/view-medicine", true));
	}

	@RequestMapping(value = "/delete-medicine/{id}", method = RequestMethod.GET)
	public ModelAndView deleteMedicine(@PathVariable("id") int id, HttpSession session)
	{
		String email = (String) session.getAttribute("email");

		if (email == null) {

			return new ModelAndView(new RedirectView("/login", true));
		}
		this.medicineService.deleteMedicine(id);
		return new ModelAndView(new RedirectView("/view-medicine", true));
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView showMedicine(@PathVariable("id") int id, Map<String, Object> model, HttpSession session)
	{
		String email = (String) session.getAttribute("email");

		if (email == null) {

			return new ModelAndView(new RedirectView("/login", true));
		}
		
		Medicine medicine = this.medicineService.getMedicineById(id);
		MedicineForm form = new MedicineForm();
		form.setId(medicine.getId());
		form.setCatgory(medicine.getCatgory());
		form.setCost(medicine.getCost());
		form.setDescription(medicine.getDescription());
		form.setName(medicine.getName());
		form.setCompany(medicine.getCompany());
		model.put("medicine", form);
		return new ModelAndView("admin/updateMedicine");
	}
	
	@RequestMapping(value = "/update-medicine", method = RequestMethod.POST)
	public ModelAndView updateMedicine(MedicineForm form)
	{
		Medicine medicine = new Medicine();
		medicine.setId(form.getId());
		medicine.setCatgory(form.getCatgory());
		System.out.println(form.getCatgory());
		medicine.setCompany(form.getCompany());
		medicine.setCost(form.getCost());
		medicine.setName(form.getName());
		medicine.setDescription(form.getDescription());
		Medicine m = this.medicineService.updateMedicine(medicine);
		return new ModelAndView(new RedirectView("/view-medicine", true));
	}
	
	@RequestMapping(value = "/all-products", method = RequestMethod.GET)
	public ModelAndView allProducts(HttpSession session, Map<String, Object> model)
	{
		if (session.getAttribute("user") != null) 
		{
			List<Medicine> list = this.medicineService.getAll();
			model.put("list", list);
			return new ModelAndView("user/allProducts");
		}
		
		return new ModelAndView(new RedirectView("/login", true));
	}
	
	@RequestMapping(value = "/add-to-cart/{id}", method = RequestMethod.GET)
	public ModelAndView addToCart(@PathVariable("id") int id, HttpSession session)
	{
		Medicine medicine = this.medicineService.getMedicineById(id);
		@SuppressWarnings("unchecked")
		ArrayList<Medicine> cart = (ArrayList<Medicine>)session.getAttribute("cart");
		for(int i = 0; i < cart.size(); i++)
		{
			Medicine m = cart.get(i);
			if(m.getId() == id)
			{
				cart.get(i).setQuantity(m.getQuantity() + 1);
				return new ModelAndView(new RedirectView("/all-products", true));
			}
		}
		cart.add(medicine);
		
		return new ModelAndView(new RedirectView("/all-products", true));
	}
	
	@RequestMapping(value = "/remove-from-cart/{id}", method = RequestMethod.GET)
	public ModelAndView removeFromCart(@PathVariable("id") int id, HttpSession session)
	{
		ArrayList<Medicine> cart = (ArrayList<Medicine>)session.getAttribute("cart");
		for(int i = 0; i < cart.size(); i++)
		{
			Medicine m = cart.get(i);
			if(m.getId() == id)
			{
				double total = Double.parseDouble(session.getAttribute("total").toString());
				total = total - (m.getCost() * m.getQuantity());
//				System.out.println("total=" + total);
				session.setAttribute("total", total);
				cart.remove(i);
				break;
			}
		}
		
		session.setAttribute("cart", cart);
		return new ModelAndView(new RedirectView("/cart", true));
	}
	public MedicineService getMedicineService() {
		return medicineService;
	}

	public void setMedicineService(MedicineService medicineService) {
		this.medicineService = medicineService;
	}
}
