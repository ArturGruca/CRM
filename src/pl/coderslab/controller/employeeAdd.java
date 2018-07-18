package pl.coderslab.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.Employee_Dao;
import pl.coderslab.dao.Vehicle_Dao;
import pl.coderslab.model.Employee;
import pl.coderslab.model.Vehicle;

/**
 * Servlet implementation class employeeAdd
 */
@WebServlet("/employeeAdd")
public class employeeAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public employeeAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("employeeAdd.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String adress = request.getParameter("adress");
		String describe = request.getParameter("describe");
		try{
		int tel_num = Integer.parseInt(request.getParameter("tel_num"));		
		int costPerH = Integer.parseInt(request.getParameter("costPerH"));		
		
		Employee newEmployee = new Employee(name, surname, adress, tel_num, describe, costPerH);
		Employee_Dao.saveToDB(newEmployee);
		
		}catch(NumberFormatException e) {
			response.getWriter().append("Bład parsowania numeru telefonu lub roboczogodziny");
		}
	}
}
