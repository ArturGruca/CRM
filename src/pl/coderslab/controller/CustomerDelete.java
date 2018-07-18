package pl.coderslab.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.Customer_Dao;
import pl.coderslab.model.Customer;

/**
 * Servlet implementation class CustomerDelete
 */
@WebServlet("/CustomerDelete")
public class CustomerDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("customerDelete.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String strCustomerId = request.getParameter("id");
	try {
	int customerId = Integer.parseInt(strCustomerId);
	Customer custToDel = Customer_Dao.loadById(customerId);
	Customer_Dao.delete(custToDel);
	
	}catch(NumberFormatException e) {
		System.out.println("Błąd wprowadzonych danych. Id powinno być dodatnią liczą całkowitą");
		response.getWriter().append("Błąd wprowadzonych danych. Id powinno być dodatnią liczą całkowitą");
	}
}
	
	
}
