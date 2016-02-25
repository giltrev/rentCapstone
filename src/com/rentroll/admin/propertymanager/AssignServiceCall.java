package com.rentroll.admin.propertymanager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
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
 * Servlet implementation class AssignServiceCall
 */
@WebServlet("/AssignServiceCall")
public class AssignServiceCall extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignServiceCall() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Service Call Id" +request.getParameter("scId"));
		System.out.println("Vendor Id "+request.getParameter("vendorId"));
		
		int scId = Integer.parseInt(request.getParameter("scId"));
		int vendorId = Integer.parseInt(request.getParameter("vendorId"));
		String serviceCallDetail = request.getParameter("serviceCallDetail");
		ServiceCall serviceCall = DbFunctions.selectServiceCall(scId);
		Vendor vendor = DbFunctions.selectVendor(vendorId);
		serviceCall.setStatus("Assigned");
		serviceCall.setServiceCallDetail(serviceCallDetail);
		serviceCall.getVendors().add(vendor);
		DbFunctions.update(serviceCall);
		vendor.getServiceCalls().add(serviceCall);
		DbFunctions.update(vendor);
		request.setAttribute("serviceCall", serviceCall);
		getServletContext().getRequestDispatcher("/DisplayServiceCalls")
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
