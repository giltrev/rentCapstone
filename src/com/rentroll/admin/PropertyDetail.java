package com.rentroll.admin;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rentroll.business.Property;
import com.rentroll.business.Unit;
import com.rentroll.data.DbFunctions;

/**
 * Servlet implementation class PropertyDetail
 */
@WebServlet("/PropertyDetail")
public class PropertyDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PropertyDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int propId = Integer.parseInt(request.getParameter("propId"));
		
		Property other_property = DbFunctions.selectProperty(propId);
		
		
		
		for (Unit unit : other_property.getUnits()){
			System.out.println(unit.getUnitId()+ " "+ unit.getUnitNumber());
	
			
		}
		System.out.println(other_property.getPropAddress1());
		
		request.setAttribute("property", other_property);
		
		getServletContext().getRequestDispatcher("/WEB-INF/propertyDetail.jsp")
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
