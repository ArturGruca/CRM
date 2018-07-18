package pl.coderslab.model;

public class Employee {

	public int employee_id;
	private String name;
	private String surname;
	private String adress;
	private int tel_num;
	private String describe;
	private int costPerH;
	
	
	
	public Employee(String name, String surname, String adress, int tel_num, String describe, int costPerH) {
		this.employee_id=0;
		this.name=name;
		this.surname=surname;
		this.adress=adress;
		this.tel_num=tel_num;
		this.describe=describe;
		this.costPerH=costPerH;
	}
	
	

	public Employee() {
		
	}



	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getAdress() {
		return adress;
	}

	public int getTel_num() {
		return tel_num;
	}

	public String getDescribe() {
		return describe;
	}

	public int getCostPerH() {
		return costPerH;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public void setTel_num(int tel_num) {
		this.tel_num = tel_num;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public void setCostPerH(int costPerH) {
		this.costPerH = costPerH;
	}

}
