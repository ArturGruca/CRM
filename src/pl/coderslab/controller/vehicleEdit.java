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
 * Servlet implementation class vehicleEdit
 */
@WebServlet("/vehicleEdit")
public class vehicleEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public vehicleEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("vehicleEdit.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		String strId = request.getParameter("id");
		int id = Integer.parseInt(strId);
		String model = request.getParameter("model");
		String brand = request.getParameter("brand");
		String strProductionYear = request.getParameter("productionYear");
		int productionYear = Integer.parseInt(strProductionYear);
		String registrationNo = request.getParameter("registrationNo");
		String nextReviewDate = request.getParameter("nextReviewDate");
		
		Vehicle vehicleEdit = new Vehicle(model, brand, productionYear, registrationNo, nextReviewDate);
		vehicleEdit.vehicle_id=id;
		Vehicle_Dao.saveToDB(vehicleEdit);
		
		}catch(NumberFormatException e) {
			response.getWriter().append("Bład parsowania daty");
		}
	}

}
