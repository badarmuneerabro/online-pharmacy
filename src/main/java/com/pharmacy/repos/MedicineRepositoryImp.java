package com.pharmacy.repos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pharmacy.helper.Connect;
import com.pharmacy.model.Medicine;

@Repository
public class MedicineRepositoryImp implements MedicinRepository
{
	@Override
	public Medicine getMedicineById(int id) 
	{
		String query = "SELECT * FROM MEDICINE WHERE id=?;";
		PreparedStatement statement = Connect.getInstance().getPreparedStatement(query);
		try {
			statement.setInt(1, id);
			
			ResultSet rs = statement.executeQuery();
			if(rs.next())
			{
				Medicine medicine = new Medicine();
				medicine.setId(id);
				medicine.setCatgory(rs.getString("CATEGORY"));
				medicine.setCompany(rs.getString("COMPANY"));
				medicine.setCost(rs.getDouble("COST"));
				medicine.setDescription(rs.getString("DESC"));
				medicine.setName(rs.getString("NAME"));
				
				return medicine;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Medicine> getAll() 
	{
		List<Medicine> list = new ArrayList<>();
		String query = "SELECT * FROM MEDICINE;";
		PreparedStatement statement = Connect.getInstance().getPreparedStatement(query);
		try {
			ResultSet rs = statement.executeQuery();
			
			while(rs.next())
			{
				Medicine medicine = new Medicine();
				medicine.setId(rs.getInt("ID"));
				medicine.setCatgory(rs.getString("CATEGORY"));
				medicine.setCompany(rs.getString("COMPANY"));
				medicine.setCost(rs.getDouble("COST"));
				medicine.setDescription(rs.getString("DESC"));
				medicine.setName(rs.getString("NAME"));
				
				list.add(medicine);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}

	@Override
	public Medicine updateMedicine(Medicine medicine) 
	{
		String query = "UPDATE MEDICINE SET CATEGORY=?, COMAPNY=?, COST=?, DESC=?, NAME=? WHERE id=?;";
		PreparedStatement statement = Connect.getInstance().getPreparedStatement(query);
		try {
			statement.executeUpdate();
			return medicine;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public int deleteMedicine(int id) 
	{
		String query = "DELETE FROM MEDICINE WHERE ID=?;";
		PreparedStatement statement = Connect.getInstance().getPreparedStatement(query);
		
		try {
			return statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Medicine saveMedicine(Medicine medicine) 
	{
		String query = "INSERT INTO MEDICINE(CATEGORY, COMPANY, COST, DESC, NAME) VALUES(?, ?, ?, ?, ?);";
		PreparedStatement statement = Connect.getInstance().getPreparedStatement(query);
		try {
			statement.executeUpdate();
			return medicine;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
