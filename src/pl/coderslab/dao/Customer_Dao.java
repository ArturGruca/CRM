package pl.coderslab.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pl.coderslab.model.Customer;
import pl.coderslab.util.DbUtil;

public class Customer_Dao {
	

	public static void saveToDB(Customer customer){
		if(customer.getCustomer_id()==0){
			try {
				String generatedColumns[] = { "ID" };
				PreparedStatement stmt = DbUtil.getConn().prepareStatement("INSERT INTO customers (name,surname,birthday) VALUES (?,?,?)",generatedColumns);
				stmt.setString(1, customer.getName()); 
				stmt.setString(2,  customer.getSurname());
				stmt.setDate(3, (java.sql.Date) customer.getDate());
				stmt.executeUpdate();
				ResultSet rs = stmt.getGeneratedKeys(); 
				if (rs.next()) {
					customer.customer_id = rs.getInt(1);
				}
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}else{
			try{
				PreparedStatement stmt = DbUtil.getConn().prepareStatement("UPDATE customers SET name = ?,surname = ?,birthday = ? WHERE customer_id = ?");
				stmt.setString(1, customer.getName()); 
				stmt.setString(2, customer.getSurname());
				stmt.setDate(3, (java.sql.Date) customer.getDate());
				stmt.setInt(4, customer.getCustomer_id());
				stmt.executeUpdate();
			}catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
	}
	
	
	
	
	public static void delete(Customer customer){
		String sql = "DELETE FROM customers WHERE customer_id= ?";
		try{
			PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
			stmt.setInt(1, customer.getCustomer_id()); 
			stmt.executeUpdate();
			customer.customer_id = 0;
		}catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	public void deleteId(int customerId){
		String sql = "DELETE FROM customers WHERE customer_id= ?";
		try{
			PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
			stmt.setInt(1, customerId); 
			stmt.executeUpdate();
		}catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static Customer loadById(int customer_id){
		try { 
			String sql = "SELECT * FROM customers WHERE customer_id=?";
			PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
			stmt.setInt(1, customer_id);
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				Customer loadedCustomer = new Customer();
				loadedCustomer.customer_id = resultSet.getInt("customer_id"); 
				loadedCustomer.setName(resultSet.getString("name")); 
				loadedCustomer.setSurname(resultSet.getString("surname")); 
				loadedCustomer.setDate(resultSet.getDate("birthday"));  
				return loadedCustomer;
			}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} 
		
		return null;
	}
	
	public static ArrayList<Customer> loadAll(){
		try {
			ArrayList<Customer> customers = new ArrayList<Customer>();
			String sql = "SELECT * FROM customers"; 
			PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				Customer loadedCustomer = new Customer();
				loadedCustomer.customer_id = resultSet.getInt("customer_id"); 
				loadedCustomer.setName(resultSet.getString("name"));
				loadedCustomer.setSurname(resultSet.getString("surname"));
				loadedCustomer.setDate(resultSet.getDate("birthday"));
				 
				customers.add(loadedCustomer);
			}
			return customers;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		return null; 

	}
	

}
