package pl.coderslab.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer {

	public int customer_id;
	private String name;
	private String surname;
	private java.sql.Date date;

	public Customer() {
	}

	public Customer(String name, String surname, String date) {
		this.customer_id = 0;
		this.name = name;
		this.surname = surname;
		this.date=toSqlDate(date);
		
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
	
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getDate() {
		return date;
	}

	

	public int getCustomer_id() {
		return customer_id;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
	}

}
