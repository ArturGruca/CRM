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
 * Servlet implementation class employeeDelete
 */
@WebServlet("/employeeDelete")
public class employeeDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public employeeDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("employeeDelete.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		Employee employeeToDel = Employee_Dao.loadById(employeeId);
		Employee_Dao.delete(employeeToDel);
		
		}catch(NumberFormatException e) {
			System.out.println("Błąd wprowadzonych danych. Id powinno być dodatnią liczą całkowitą");
			response.getWriter().append("Błąd wprowadzonych danych. Id powinno być dodatnią liczą całkowitą");
		}
		
	}

}
