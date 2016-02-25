package com.rentroll.admin.propertymanager;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import com.rentroll.business.Picture;
import com.rentroll.business.ServiceCall;
import com.rentroll.business.Tenant;
import com.rentroll.business.Vendor;
import com.rentroll.data.DbFunctions;

/**
 * Servlet implementation class CreateServiceCall
 */
@WebServlet("/CreateServiceCallPM")
@MultipartConfig(maxFileSize = 16177215)
public class CreateServiceCallPM extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServiceCallPM() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
		String serviceCallDetail = request.getParameter("serviceCallDetail");
		int tenantId = Integer.parseInt(request.getParameter("tenantId"));
		int vendorId = Integer.parseInt(request.getParameter("vendorId"));
		Vendor vendor = DbFunctions.selectVendor(vendorId);
		Tenant tenant = DbFunctions.selectTenant(tenantId);
        String reachTime = request.getParameter("reachTime");
        
		ServiceCall serviceCall = new ServiceCall();
		System.out.println(vendor.getFirstName());
		Set <Vendor> vendors = new HashSet<>();
		vendors.add(vendor);
		serviceCall.setVendors(vendors);;
		serviceCall.setServiceCallDetail(serviceCallDetail);
		serviceCall.setUnit(tenant.getUnit());
		serviceCall.setReportedBy(tenant);
		serviceCall.setReachTime(reachTime);
		
		DbFunctions.insert(serviceCall);
		
		tenant.getUnit().getServiceCalls().add(serviceCall);
		
		DbFunctions.update(tenant);
		
		vendor.getServiceCalls().add(serviceCall);
		DbFunctions.update(vendor);
		
		
		request.setAttribute("serviceCall", serviceCall);
		getServletContext().getRequestDispatcher("/WEB-INF/serviceCallDetailPM.jsp")
		.forward(request, response);
	}

}
