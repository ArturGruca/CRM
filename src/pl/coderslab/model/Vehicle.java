package pl.coderslab.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Vehicle {

	public int vehicle_id;
	private String model;
	private String brand;
	private int productionYear;
	private String registrationNo;
	private java.sql.Date nextReviewDate;

	public Vehicle(String model, String brand, int productionYear, String registrationNo, String nextReviewDate) {
		this.vehicle_id=0;
		this.model = model;
		this.brand = brand;
		this.productionYear = productionYear;
		this.registrationNo = registrationNo;
		this.nextReviewDate= toSqlDate(nextReviewDate);
		
	}
	
	
	public java.sql.Date toSqlDate(String strDate)
	{
	    DateFormat dateFrm = new SimpleDateFormat("yyyy-MM-dd");
	    java.util.Date myDate = new java.util.Date();
	    java.sql.Date sqlDate;

	    try
	    {
	      myDate = dateFrm.parse(strDate);
	      sqlDate = new java.sql.Date(myDate.getTime());
	    }
	    catch (Exception e)
	    {
	      sqlDate = null;
	    }

	    return (sqlDate);
	}
	
	
	
	

	public Vehicle() {

	}

	public String getModel() {
		return model;
	}

	public String getBrand() {
		return brand;
	}

	public int getProductionYear() {
		return productionYear;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public Date getNextReviewDate() {
		return nextReviewDate;
	}

	public int getVehicle_id() {
		return vehicle_id;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}

	public void setRegistartionNo(String registartionNo) {
		this.registrationNo = registartionNo;
	}


	public void setNextReviewDate(java.sql.Date nextReviewDate) {
		this.nextReviewDate = nextReviewDate;
	}



}
