package pl.coderslab.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.Customer_Dao;
import pl.coderslab.dao.Vehicle_Dao;
import pl.coderslab.model.Customer;
import pl.coderslab.model.Vehicle;

/**
 * Servlet implementation class vehicleDelete
 */
@WebServlet("/vehicleDelete")
public class vehicleDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public vehicleDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("vehicleDelete.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strVehicleId = request.getParameter("id");
		try {
		int vehicleId = Integer.parseInt(strVehicleId);
		Vehicle vehicToDel = Vehicle_Dao.loadById(vehicleId);
		Vehicle_Dao.delete(vehicToDel);
		
		}catch(NumberFormatException e) {
			System.out.println("Błąd wprowadzonych danych. Id powinno być dodatnią liczą całkowitą");
			response.getWriter().append("Błąd wprowadzonych danych. Id powinno być dodatnią liczą całkowitą");
		}
		
	}

}
