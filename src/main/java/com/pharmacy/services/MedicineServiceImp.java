package com.pharmacy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacy.model.Medicine;
import com.pharmacy.repos.MedicinRepository;

@Service
public class MedicineServiceImp implements MedicineService 
{

	@Autowired
	private MedicinRepository medicineRepository;
	@Override
	public Medicine getMedicineById(int id) 
	{
		
		return this.medicineRepository.getMedicineById(id);
	}

	@Override
	public List<Medicine> getAll() 
	{
		return this.medicineRepository.getAll();
	}

	@Override
	public Medicine updateMedicine(Medicine medicine) 
	{
		return this.medicineRepository.updateMedicine(medicine);
	}

	@Override
	public int deleteMedicine(int id) 
	{
		return this.medicineRepository.deleteMedicine(id);
	}

	@Override
	public Medicine saveMedicine(Medicine medicine) 
	{
		return this.medicineRepository.saveMedicine(medicine);
	}

	

}
