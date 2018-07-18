package pl.coderslab.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pl.coderslab.model.Customer;
import pl.coderslab.model.Vehicle;
import pl.coderslab.util.DbUtil;

public class Vehicle_Dao {
	

	public static void saveToDB(Vehicle vehicle){
		if(vehicle.getVehicle_id()==0){
			try {
				String generatedColumns[] = { "ID" };
				PreparedStatement stmt = DbUtil.getConn().prepareStatement("INSERT INTO vehicle (model,brand,productionYear,registrationNo,nextReviewDate) VALUES (?,?,?,?,?)",generatedColumns);
				stmt.setString(1, vehicle.getModel()); 
				stmt.setString(2,  vehicle.getBrand());
				stmt.setInt(3, vehicle.getProductionYear());
				stmt.setString(4, vehicle.getRegistrationNo());
				stmt.setDate(5, (java.sql.Date) vehicle.getNextReviewDate());
				stmt.executeUpdate();
				ResultSet rs = stmt.getGeneratedKeys(); 
				if (rs.next()) {
					vehicle.vehicle_id = rs.getInt(1);
				}
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}else{
			try{
				PreparedStatement stmt = DbUtil.getConn().prepareStatement("UPDATE vehicle SET model = ?,brand = ?,productionYear = ?,registrationNo = ? WHERE id = ?");
				stmt.setString(1, vehicle.getModel()); 
				stmt.setString(2, vehicle.getBrand());
				stmt.setInt(3, vehicle.getProductionYear());
				stmt.setString(4, vehicle.getRegistrationNo());
				stmt.setInt(5, vehicle.getVehicle_id());
				stmt.executeUpdate();
			}catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
	}
	
	
	
	
	public static void delete(Vehicle vehicle){
		String sql = "DELETE FROM vehicle WHERE id= ?";
		try{
			PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
			stmt.setInt(1, vehicle.getVehicle_id()); 
			stmt.executeUpdate();
			vehicle.vehicle_id= 0;
		}catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static Vehicle loadById(int vehicle_id){
		try { 
			String sql = "SELECT * FROM vehicle WHERE id=?";
			PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
			stmt.setInt(1, vehicle_id);
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				Vehicle loadedVehicle = new Vehicle();
				loadedVehicle.vehicle_id = resultSet.getInt("id"); 
				loadedVehicle.setModel(resultSet.getString("model"));
				loadedVehicle.setBrand(resultSet.getString("brand")); 
				loadedVehicle.setProductionYear(resultSet.getInt("productionYear"));  
				loadedVehicle.setRegistartionNo(resultSet.getString("registrationNo")); 
				loadedVehicle.setNextReviewDate(resultSet.getDate("nextReviewDate"));  
				return loadedVehicle;
			}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} 
		
		return null;
	}
	
	public static ArrayList<Vehicle> loadAll(){
		try {
			ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
			String sql = "SELECT * FROM vehicle"; 
			PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				Vehicle loadedVehicle = new Vehicle();
				loadedVehicle.vehicle_id = resultSet.getInt("id"); 
				loadedVehicle.setModel(resultSet.getString("model"));
				loadedVehicle.setBrand(resultSet.getString("brand")); 
				loadedVehicle.setProductionYear(resultSet.getInt("productionYear"));  
				loadedVehicle.setRegistartionNo(resultSet.getString("registrationNo")); 
				loadedVehicle.setNextReviewDate(resultSet.getDate("nextReviewDate")); 
				 
				vehicles.add(loadedVehicle);
			}
			return vehicles;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		return null; 

	}
	

}
