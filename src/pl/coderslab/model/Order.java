package pl.coderslab.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Order {


	public int order_id;
	private java.sql.Date dateReception;
	private java.sql.Date datePlannedStart;
	private java.sql.Date dateStart;
    private int idEmployee;
    private String problemDescription;
    private String repairDescription;
    private String repairStatus;
    private int idVehicle;
    private double repairCost;
    private double elementsCost;
    private int quanWorkHour;
    private int costPerH;

public Order(String dateReception, String datePlannedStart, String dateStart, int idEmployee, String problemDescription, String repairDescription, String repairStatus, int idVehicle,
		double repairCost, double elementsCost, int quanWorkHour) {
	this.order_id=0;
	this.dateReception=toSqlDate(dateReception);
	this.datePlannedStart=toSqlDate(datePlannedStart);
	this.dateStart=toSqlDate(dateStart);
	this.idEmployee=idEmployee;
	this.problemDescription=problemDescription;
	this.repairDescription=repairDescription;
	this.repairStatus=repairStatus;
	this.idVehicle=idVehicle;
	this.repairCost=repairCost;
	this.elementsCost=elementsCost;
	this.quanWorkHour=quanWorkHour;
	
}

	
	public Order() {
	
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


	public java.sql.Date getDateReception() {
		return dateReception;
	}


	public void setDateReception(java.sql.Date dateReception) {
		this.dateReception = dateReception;
	}


	public java.sql.Date getDatePlannedStart() {
		return datePlannedStart;
	}


	public void setDatePlannedStart(java.sql.Date datePlannedStart) {
		this.datePlannedStart = datePlannedStart;
	}


	public java.sql.Date getDateStart() {
		return dateStart;
	}


	public void setDateStart(java.sql.Date dateStart) {
		this.dateStart = dateStart;
	}


	public int getIdEmployee() {
		return idEmployee;
	}


	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}


	public String getProblemDescription() {
		return problemDescription;
	}


	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}


	public String getRepairDescription() {
		return repairDescription;
	}


	public void setRepairDescription(String repairDescription) {
		this.repairDescription = repairDescription;
	}


	public String getRepairStatus() {
		return repairStatus;
	}


	public void setRepairStatus(String repairStatus) {
		this.repairStatus = repairStatus;
	}


	public double getRepairCost() {
		return repairCost;
	}


	public void setRepairCost(double repairCost) {
		this.repairCost = repairCost;
	}


	public double getElementsCost() {
		return elementsCost;
	}


	public void setElementsCost(double elementsCost) {
		this.elementsCost = elementsCost;
	}


	public int getQuanWorkHour() {
		return quanWorkHour;
	}


	public void setQuanWorkHour(int quanWorkHour) {
		this.quanWorkHour = quanWorkHour;
	}


	public int getOrder_id() {
		return order_id;
	}


	public int getIdVehicle() {
		return idVehicle;
	}


	public void setIdVehicle(int idVehicle) {
		this.idVehicle = idVehicle;
	}


	public void setCostPerH(int costPerH) {
		this.costPerH=costPerH;
		
	}
    
	public int getCostPerH() {
		return costPerH;
	}
    
    
}
