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
import pl.coderslab.dao.Order_Dao;
import pl.coderslab.dao.Vehicle_Dao;
import pl.coderslab.model.Customer;
import pl.coderslab.model.Employee;
import pl.coderslab.model.Order;
import pl.coderslab.model.Vehicle;

/**
 * Servlet implementation class vehicleEdit
 */
@WebServlet("/orderEdit")
public class orderEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orderEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("orderEdit.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dateReception = request.getParameter("dateReception");
		String datePlannedStart = request.getParameter("datePlannedStart");
		String dateStart = request.getParameter("dateStart");
		String problemDescription = request.getParameter("problemDescription");
		String repairDescription = request.getParameter("repairDescription");
		String repairStatus = request.getParameter("repairStatus");

 		try{
 		int order_id = Integer.parseInt(request.getParameter("id"));
		int idEmployee = Integer.parseInt(request.getParameter("idEmployee"));		
		int idVehicle = Integer.parseInt(request.getParameter("idVehicle"));		
		double repairCost = Double.parseDouble(request.getParameter("repairCost"));
		double elementsCost = Double.parseDouble(request.getParameter("elementsCost"));
		int quanWorkHour = Integer.parseInt(request.getParameter("quanWorkHour"));


		Order newOrder = new Order(dateReception, datePlannedStart, dateStart, idEmployee, problemDescription, repairDescription, repairStatus, idVehicle, repairCost, elementsCost, quanWorkHour);
		newOrder.order_id=order_id;
		Order_Dao.saveToDB(newOrder);
		
		}catch(NumberFormatException e) {
			e.printStackTrace();
			response.getWriter().append("Bład parsowania pól liczbowych - dane żle wprowadzone");
		}
	}


}
