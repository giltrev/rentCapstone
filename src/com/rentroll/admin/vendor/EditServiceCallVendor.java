package com.rentroll.admin.vendor;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

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
@WebServlet("/EditServiceCallVendor")
public class EditServiceCallVendor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServiceCallVendor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		
//		getServletContext().getRequestDispatcher("/WEB-INF/vendorView.jsp")
//		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String status = request.getParameter("status");
		String vendorComments = request.getParameter("vendorComments");
		
		int scId = Integer.parseInt(request.getParameter("scId"));
		ServiceCall serviceCall = DbFunctions.selectServiceCall(scId);
		
		if (request.getParameter("partsCost")!= null){
			String partsCost = request.getParameter("partsCost");
			BigDecimal partsCostBD = new BigDecimal(partsCost);
			serviceCall.setPartsCost(partsCostBD);
		}
		
		if (request.getParameter("laborCost")!= null){
			String laborCost = request.getParameter("laborCost");
			System.out.println("laborCost "+ laborCost);
			BigDecimal laborCostBD = new BigDecimal(laborCost);
			serviceCall.setLaborCost(laborCostBD);
		}
		
		serviceCall.setVendorComments(vendorComments);
		serviceCall.setStatus(status);
		
		if (status.equals("Complete")){
			serviceCall.setActive(false);
			Date today= new java.util.Date();
			serviceCall.setEndTime(today);
		}
		
		DbFunctions.update(serviceCall);
		HttpSession session = request.getSession();
		String vendorUserId = (String) session.getAttribute("vendorId");
		
		Vendor nullVendor = new Vendor();
		Vendor vendor2 = DbFunctions.selectVendorUserName(vendorUserId);
		request.removeAttribute("vendor");
		
		
		request.setAttribute("serviceCall", serviceCall);
		request.setAttribute("vendor", nullVendor);
		request.removeAttribute("vendor");
		request.setAttribute("vendor", vendor2);
		
		
		response.sendRedirect("/Captsone/VendorView"); 
//		doGet(request, response);
	}

}
