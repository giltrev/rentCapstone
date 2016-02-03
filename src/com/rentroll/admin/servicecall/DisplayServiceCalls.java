package com.rentroll.admin.servicecall;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rentroll.business.ServiceCall;
import com.rentroll.data.DbFunctions;

/**
 * Servlet implementation class DisplayServiceCalls
 */
@WebServlet("/DisplayServiceCalls")
public class DisplayServiceCalls extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayServiceCalls() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		List<ServiceCall> serviceCalls= null;
		
		serviceCalls = DbFunctions.selectAllOpenServiceCalls();
		System.out.println("Total ServiceCalls is " + serviceCalls.size());
		
		request.setAttribute("serviceCalls", serviceCalls);
		
		getServletContext().getRequestDispatcher("/WEB-INF/displayServiceCalls.jsp")
		.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
