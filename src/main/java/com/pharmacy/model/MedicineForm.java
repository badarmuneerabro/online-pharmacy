package com.pharmacy.model;

public class MedicineForm 
{
	private int id;
	private String name;
	private String description;
	private double cost;
	private String company;
	private String catgory;
	
	
	public MedicineForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MedicineForm(String name, String description, double cost, String company, String catgory) {
		super();
		this.name = name;
		this.description = description;
		this.cost = cost;
		this.company = company;
		this.catgory = catgory;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCatgory() {
		return catgory;
	}
	public void setCatgory(String catgory) {
		this.catgory = catgory;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
