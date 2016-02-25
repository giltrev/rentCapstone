package com.rentroll.admin.propertymanager;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rentroll.business.PropertyManager;
import com.rentroll.business.ServiceCall;
import com.rentroll.business.Vendor;
import com.rentroll.data.DbFunctions;

/**
 * Servlet implementation class AssignServiceCallRedirect
 */
@WebServlet("/AddVendorForward")
public class AddVendorForward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVendorForward() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int scId = Integer.parseInt(request.getParameter("scId"));
		Set <Vendor> vendors = new HashSet<>();
		vendors.addAll(DbFunctions.selectAllVendors());
		ServiceCall serviceCall = DbFunctions.selectServiceCall(scId);
		request.setAttribute("serviceCall", serviceCall);
		
		request.setAttribute("vendors", vendors);
		getServletContext().getRequestDispatcher("/WEB-INF/assignServiceCall.jsp")
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
