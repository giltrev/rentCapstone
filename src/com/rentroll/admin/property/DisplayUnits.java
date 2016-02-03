package com.rentroll.admin.property;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rentroll.business.RentProperty;
import com.rentroll.data.DbFunctions;

/**
 * Servlet implementation class DisplayUnits
 */
@WebServlet("/DisplayUnits")
public class DisplayUnits extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayUnits() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int propId = Integer.parseInt(request.getParameter("propId"));
		
		RentProperty property = DbFunctions.selectProperty(propId);
		
		request.setAttribute("property", property);
		
		getServletContext().getRequestDispatcher("/WEB-INF/displayUnits.jsp")
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
