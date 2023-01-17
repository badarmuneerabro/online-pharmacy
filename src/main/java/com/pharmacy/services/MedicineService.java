package com.pharmacy.services;

import java.util.List;

import com.pharmacy.model.Medicine;

public interface MedicineService 
{
	Medicine getMedicineById(int id);
	List<Medicine> getAll();
	Medicine updateMedicine(Medicine medicine);
	int deleteMedicine(int id);
	Medicine saveMedicine(Medicine medicine);
}
