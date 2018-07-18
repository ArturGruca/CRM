package pl.coderslab.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.Customer_Dao;
import pl.coderslab.model.Customer;

/**
 * Servlet implementation class CustomerAdd
 */
@WebServlet("/CustomerAdd")
public class CustomerAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("customerAdd.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		try {
		String date = request.getParameter("date");
		
		Customer newCustomer = new Customer (name, surname, date);
		
		Customer_Dao.saveToDB(newCustomer);
		
		}catch(NumberFormatException e) {
			e.printStackTrace();
			response.getWriter().append("Błąd konwersji daty. Data powinna być podana w formacie \"RRRR-MM-DD\".");
		}
		
		
		}

}
