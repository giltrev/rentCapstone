package com.rentroll.admin.servicecall;

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
import com.rentroll.data.DbFunctions;

/**
 * Servlet implementation class CreateServiceCall
 */
@WebServlet("/CreateServiceCall")
@MultipartConfig(maxFileSize = 16177215)
public class CreateServiceCall extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServiceCall() {
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
		HttpSession session = request.getSession();
		String serviceCallDetail = request.getParameter("serviceCallDetail");
//		Tenant tenant = DbFunctions.selectTenant((Integer)session.getAttribute("userId"));
		Tenant tenant = (Tenant)session.getAttribute("tenant");
        InputStream inputStream = null; // input stream of the upload file
        
        // obtains the upload file part in this multipart request
//        Part filePart = request.getPart("photo");
        Set <Picture> pictures = new HashSet<>();
        
        List<Part> fileParts = (List<Part>) request.getParts();
//        Part[] fileParts=(Part[])request.getParameter("file");
//        Part[] fileParts=(Part[])request.getAttribute("photo");
        
        for (Part filePart : fileParts) {
            if (filePart != null && filePart.getName().equals("photo")&& filePart.getContentType().equals("image/jpeg") ) {
                // prints out some information for debugging
                System.out.println(filePart.getName());
                System.out.println(filePart.getSize());
                System.out.println(filePart.getContentType());
                 
                // obtains input stream of the upload file
                inputStream = filePart.getInputStream();
                
                
            
            Picture picture = new Picture();
            byte[] imageFile = IOUtils.toByteArray(inputStream);
            picture.setImageFile(imageFile);
            
            
            

            	
            DbFunctions.insert(picture);
            pictures.add(picture);
            }
		}
        

        
        Calendar calendar = Calendar.getInstance();
        Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
        
        
        
        
        
        
		System.out.println("Service Call Detail"+ serviceCallDetail);
		ServiceCall serviceCall = new ServiceCall();
		serviceCall.setServiceCallDetail(serviceCallDetail);
		serviceCall.setInitTime(currentTimestamp);
		serviceCall.setUnit(tenant.getUnit());
		serviceCall.setStatus("Opened");
		
		
		
		serviceCall.setPictures(pictures);
		DbFunctions.insert(serviceCall);
		
		request.setAttribute("serviceCall", serviceCall);
		
		getServletContext().getRequestDispatcher("/WEB-INF/serviceCallDetail.jsp")
		.forward(request, response);
	}

}
