package com.rentroll.admin;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rentroll.business.RentProperty;
import com.rentroll.business.Unit;
import com.rentroll.data.DbFunctions;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<RentProperty> availableUnitsList = DbFunctions.selectAvailableUnits();
		Set<RentProperty> availableUnits = new HashSet<>();
		availableUnits.addAll(availableUnitsList);
		
		request.setAttribute("availableUnits", availableUnits);
		System.out.println("Available units in HOME.java size is "+ availableUnits.size());
		getServletContext().getRequestDispatcher("/WEB-INF/index.jsp")
		.forward(request, response);
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
