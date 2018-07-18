package pl.coderslab.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pl.coderslab.model.Customer;
import pl.coderslab.model.Employee;
import pl.coderslab.util.DbUtil;

public class Employee_Dao {
	

	public static void saveToDB(Employee employee){
		if(employee.getEmployee_id()==0){
			try {
				String generatedColumns[] = { "ID" };
				PreparedStatement stmt = DbUtil.getConn().prepareStatement("INSERT INTO employee (name,surname,adress,tel_num,describe,costPerH) VALUES (?,?,?,?,?,?)",generatedColumns);
				stmt.setString(1, employee.getName()); 
				stmt.setString(2,  employee.getSurname());
				stmt.setString(3, employee.getAdress()); 
				stmt.setInt(4,  employee.getTel_num());
				stmt.setString(5, employee.getDescribe()); 
				stmt.setInt(6,  employee.getCostPerH());
				stmt.executeUpdate();
				ResultSet rs = stmt.getGeneratedKeys(); 
				if (rs.next()) {
					employee.employee_id = rs.getInt(1);
				}
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}else{
			try{
				PreparedStatement stmt = DbUtil.getConn().prepareStatement("UPDATE employee SET name=?,surname=?,adress=?, tel_num=?, describe=?, costPerH=? WHERE id = ?");
				stmt.setString(1, employee.getName()); 
				stmt.setString(2,  employee.getSurname());
				stmt.setString(3, employee.getAdress()); 
				stmt.setInt(4,  employee.getTel_num());
				stmt.setString(5, employee.getDescribe()); 
				stmt.setInt(6,  employee.getCostPerH());
				stmt.setInt(7,  employee.getEmployee_id());
				stmt.executeUpdate();
			}catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
	}
	
	
	
	
	public static void delete(Employee employee){
		String sql = "DELETE FROM employee WHERE id= ?";
		try{
			PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
			stmt.setInt(1, employee.getEmployee_id()); 
			stmt.executeUpdate();
			employee.employee_id = 0;
		}catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	public static Employee loadById(int employee_id){
		try { 
			String sql = "SELECT * FROM employee WHERE id=?";
			PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
			stmt.setInt(1, employee_id);
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				Employee loadedEmployee = new Employee();
				loadedEmployee.employee_id = resultSet.getInt("id"); 
				loadedEmployee.setName(resultSet.getString("name")); 
				loadedEmployee.setSurname(resultSet.getString("surname")); 
				loadedEmployee.setAdress(resultSet.getString("adress")); 
				loadedEmployee.setTel_num(resultSet.getInt("tel_num")); 
				loadedEmployee.setDescribe(resultSet.getString("describe")); 
				loadedEmployee.setCostPerH(resultSet.getInt("costPerH")); 
				return loadedEmployee;
			}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} 
		
		return null;
	}
	
	public static ArrayList<Employee> loadAll(){
		try {
			ArrayList<Employee> staf = new ArrayList<Employee>();
			String sql = "SELECT * FROM employee"; 
			PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				Employee loadedEmployee = new Employee();
				loadedEmployee.employee_id = resultSet.getInt("id"); 
				loadedEmployee.setName(resultSet.getString("name")); 
				loadedEmployee.setSurname(resultSet.getString("surname")); 
				loadedEmployee.setAdress(resultSet.getString("adress")); 
				loadedEmployee.setTel_num(resultSet.getInt("tel_num")); 
				loadedEmployee.setDescribe(resultSet.getString("describe")); 
				loadedEmployee.setCostPerH(resultSet.getInt("costPerH")); 
				
				staf.add(loadedEmployee);
			}
			return staf;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		return null; 

	}
	

}
