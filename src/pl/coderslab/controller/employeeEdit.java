package pl.coderslab.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.Customer_Dao;
import pl.coderslab.dao.Employee_Dao;
import pl.coderslab.dao.Vehicle_Dao;
import pl.coderslab.model.Customer;
import pl.coderslab.model.Employee;
import pl.coderslab.model.Vehicle;

/**
 * Servlet implementation class vehicleEdit
 */
@WebServlet("/employeeEdit")
public class employeeEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public employeeEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("employeeEdit.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		String strId = request.getParameter("id");
		int employee_id = Integer.parseInt(strId);
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String adress = request.getParameter("adress");
		int tel_num = Integer.parseInt(request.getParameter("tel_num"));		
		String describe = request.getParameter("describe");
		int costPerH = Integer.parseInt(request.getParameter("costPerH"));		
		
		Employee newEmployee = new Employee(name, surname, adress, tel_num, describe, costPerH);
		newEmployee.employee_id=employee_id;
		Employee_Dao.saveToDB(newEmployee);
		
		}catch(NumberFormatException e) {
			response.getWriter().append("Bład parsowania");
		}
	}

}
