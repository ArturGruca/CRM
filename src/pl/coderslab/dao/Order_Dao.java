package pl.coderslab.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pl.coderslab.model.Customer;
import pl.coderslab.model.Employee;
import pl.coderslab.model.Order;
import pl.coderslab.util.DbUtil;

public class Order_Dao {
	

	public static void saveToDB(Order order){
		if(order.getOrder_id()==0){
			try {
				String generatedColumns[] = { "ID" };
				PreparedStatement stmt = DbUtil.getConn().prepareStatement("INSERT INTO `order` (dateReception,datePlannedStart,dateStart,idEmployee,problemDescription,repairDescription,repairStatus,idVehicle,\n" + 
						"repairCost,elementsCost,quanWorkHour) VALUES (?,?,?,?,?,?,?,?,?,?,?)",generatedColumns);
				stmt.setDate(1, (java.sql.Date) order.getDateReception()); 
				stmt.setDate(2,(java.sql.Date) order.getDatePlannedStart());
				stmt.setDate(3,(java.sql.Date) order.getDateStart()); 
				stmt.setInt(4,  order.getIdEmployee());
				stmt.setString(5, order.getProblemDescription()); 
				stmt.setString(6, order.getRepairDescription());
				stmt.setString(7, order.getRepairStatus()); 
				stmt.setInt(8, order.getIdVehicle());
				stmt.setDouble(9, order.getRepairCost()); 
				stmt.setDouble(10, order.getElementsCost());
				stmt.setInt(11, order.getQuanWorkHour());
				
				stmt.executeUpdate();
				ResultSet rs = stmt.getGeneratedKeys(); 
				if (rs.next()) {
					order.order_id = rs.getInt(1);
				}
				
				
				stmt = DbUtil.getConn().prepareStatement("UPDATE `order` SET costPerH = (SELECT costPerH FROM employee WHERE id = ?) WHERE id=?");
				stmt.setInt(1,  order.getIdEmployee());
				stmt.setInt(2,  order.getOrder_id());
				stmt.executeUpdate();          // Zapytanie kopiujące z komórki jednej tabeli do komróki drugiej tabeli
				
				
				
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}else{
			try{
				PreparedStatement stmt = DbUtil.getConn().prepareStatement("UPDATE `order` SET dateReception = ?,datePlannedStart=?,dateStart=?,idEmployee=?,problemDescription=?,repairDescription=?,repairStatus=?,idVehicle=?, \n" + 
						"repairCost=?,elementsCost=?,quanWorkHour=? WHERE id = ?");
				stmt.setDate(1, (java.sql.Date) order.getDateReception()); 
				stmt.setDate(2,(java.sql.Date) order.getDatePlannedStart());
				stmt.setDate(3,(java.sql.Date) order.getDateStart()); 
				stmt.setInt(4,  order.getIdEmployee());
				stmt.setString(5, order.getProblemDescription()); 
				stmt.setString(6, order.getRepairDescription());
				stmt.setString(7, order.getRepairStatus()); 
				stmt.setInt(8, order.getIdVehicle());
				stmt.setDouble(9, order.getRepairCost()); 
				stmt.setDouble(10, order.getElementsCost());
				stmt.setInt(11, order.getQuanWorkHour());
				stmt.setInt(12, order.getOrder_id());
				
				stmt.executeUpdate();

				stmt = DbUtil.getConn().prepareStatement("UPDATE `order` SET costPerH = (SELECT costPerH FROM employee WHERE id = ?) WHERE id=?");
				stmt.setInt(1,  order.getIdEmployee());
				stmt.setInt(2,  order.getOrder_id());
				stmt.executeUpdate();          // Zapytanie kopiujące z komórki jednej tabeli do komróki drugiej tabeli
				
			}catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
	}
	
	
	
	
	public static void delete(Order order){
		String sql = "DELETE FROM `order` WHERE id= ?";
		try{
			PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
			stmt.setInt(1, order.getOrder_id()); 
			stmt.executeUpdate();
			order.order_id = 0;
		}catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	public static Order loadById(int order_id){
		try { 
			String sql = "SELECT * FROM `order` WHERE id=?";
			PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
			stmt.setInt(1, order_id);
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				Order loadedOrder = new Order();
				loadedOrder.order_id = resultSet.getInt("id"); 
				loadedOrder.setDateReception(resultSet.getDate("dateReception")); 
				loadedOrder.setDatePlannedStart(resultSet.getDate("datePlannedStart")); 
				loadedOrder.setDateStart(resultSet.getDate("dateStart")); 
				loadedOrder.setIdEmployee(resultSet.getInt("idEmployee")); 
				loadedOrder.setProblemDescription(resultSet.getString("problemDescription")); 
				loadedOrder.setRepairDescription(resultSet.getString("repairDescription")); 
				loadedOrder.setRepairStatus(resultSet.getString("repairStatus")); 
				loadedOrder.setIdVehicle(resultSet.getInt("idVehicle")); 
				loadedOrder.setRepairCost(resultSet.getInt("repairCost")); 
				loadedOrder.setElementsCost(resultSet.getInt("elementsCost")); 
				loadedOrder.setQuanWorkHour(resultSet.getInt("quanWorkHour")); 
				loadedOrder.setCostPerH(resultSet.getInt("costPerH")); 
				
				return loadedOrder;
			}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} 
		
		return null;
	}
	
	public static ArrayList<Order> loadAll(){
		try {
			ArrayList<Order> orders = new ArrayList<Order>();
			String sql = "SELECT * FROM `order`"; 
			PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				Order loadedOrder = new Order();
				loadedOrder.order_id = resultSet.getInt("id"); 
				loadedOrder.setDateReception(resultSet.getDate("dateReception")); 
				loadedOrder.setDatePlannedStart(resultSet.getDate("datePlannedStart")); 
				loadedOrder.setDateStart(resultSet.getDate("dateStart")); 
				loadedOrder.setIdEmployee(resultSet.getInt("idEmployee")); 
				loadedOrder.setProblemDescription(resultSet.getString("problemDescription")); 
				loadedOrder.setRepairDescription(resultSet.getString("repairDescription")); 
				loadedOrder.setRepairStatus(resultSet.getString("repairStatus")); 
				loadedOrder.setIdVehicle(resultSet.getInt("idVehicle")); 
				loadedOrder.setRepairCost(resultSet.getInt("repairCost")); 
				loadedOrder.setElementsCost(resultSet.getInt("elementsCost")); 
				loadedOrder.setQuanWorkHour(resultSet.getInt("quanWorkHour")); 
				loadedOrder.setCostPerH(resultSet.getInt("costPerH")); 
				
				
				
				orders.add(loadedOrder);
			}
			return orders;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		return null; 

	}
	

}
