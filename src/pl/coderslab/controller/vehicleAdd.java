package pl.coderslab.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.util.VersionFSHierarchyMaker;

import pl.coderslab.dao.Customer_Dao;
import pl.coderslab.dao.Vehicle_Dao;
import pl.coderslab.model.Customer;
import pl.coderslab.model.Vehicle;

/**
 * Servlet implementation class vehicleAdd
 */
@WebServlet("/vehicleAdd")
public class vehicleAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public vehicleAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("vehicleAdd.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String model = request.getParameter("model");
		String brand = request.getParameter("brand");	
		String registrationNo = request.getParameter("registrationNo"); 
		String nextReviewDate = request.getParameter("nextReviewDate");
		try {
		String productionYear = request.getParameter("productionYear");
		int prodYear = Integer.parseInt(productionYear);
		
		
		Vehicle newCar = new Vehicle(model, brand, prodYear, registrationNo, nextReviewDate);
		
		Vehicle_Dao.saveToDB(newCar);
		
		}catch(NumberFormatException e) {
			e.printStackTrace();
			response.getWriter().append("Błąd konwersji daty produkcji. Data powinna być podana jako dodatnia liczba całkowita");
		}
		
	}

}
