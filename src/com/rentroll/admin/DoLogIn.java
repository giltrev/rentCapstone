package com.rentroll.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthSeparatorUI;

import com.rentroll.business.Vendor;
import com.rentroll.data.DbFunctions;

/**
 * Servlet implementation class LogIn
 */
@WebServlet("/doLogin")
public class DoLogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoLogIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		if (request.getParameter("userId")== null|| request.getParameter("password")==null ||request.getParameter("userId").isEmpty() || request.getParameter("password").isEmpty() ){
			request.setAttribute("loginMessage", "The UserId and Password combination did not match or empty, Please try again");
			getServletContext().getRequestDispatcher("/login")
			.forward(request, response);
//			RequestDispatcher dispatcher=getServletContext().getRequestDispatcher( "/WEB-INF/login.jsp" );
//			dispatcher.forward( request, response );
			return;
		}
		HttpSession session = request.getSession();
		String userId = request.getParameter("userId");
		String password =request.getParameter("password");
		System.out.println("userId" + userId);
		System.out.println("password" + password);
		
		String ownerPassword="";
		String tenantPassword="";
		String vendorPassword="";
		String propManagerPassword="";
		
		if (DbFunctions.ownerLogin(userId)!=null){
			System.out.println("its a owner");
			ownerPassword = DbFunctions.ownerLogin(userId);
			System.out.println("Password"+ DbFunctions.hashPassword(password, DbFunctions.getOwnerUserName(userId).getSalt()));
			System.out.println("ownerPassword "+ownerPassword);
			if (ownerPassword.equals(DbFunctions.hashPassword(password, DbFunctions.getOwnerUserName(userId).getSalt() )) ){
				session.setAttribute("userId", userId);
				session.setAttribute("pType", "owner");
				session.setAttribute("owner", DbFunctions.getOwnerUserName(userId));
				getServletContext().getRequestDispatcher("/WEB-INF/ownerView.jsp")
				.forward(request, response);
				
			}
			else {
				request.setAttribute("loginMessage", "The UserId and Password combination did not match, Please try again");
				getServletContext().getRequestDispatcher("/login")
				.forward(request, response);
			}
			return;
		}
		if (DbFunctions.tenantLogin(userId)!=null){
			tenantPassword = DbFunctions.tenantLogin(userId);
			if (tenantPassword.equals(DbFunctions.hashPassword(password, DbFunctions.getTenantUserName(userId).getSalt() ))  ){
				session.setAttribute("userId", userId);
				session.setAttribute("pType", "tenant");
				session.setAttribute("tenant", DbFunctions.selectTenantUserName(userId));
				getServletContext().getRequestDispatcher("/TenantView")
				.forward(request, response);
			}
			else {
				request.setAttribute("loginMessage", "The UserId and Password combination did not match, Please try again");
				getServletContext().getRequestDispatcher("/login")
				.forward(request, response);
			}
			return;
			
		}
		if (DbFunctions.vendorLogin(userId)!=null){
			vendorPassword = DbFunctions.vendorLogin(userId);
			if (vendorPassword.equals(DbFunctions.hashPassword(password, DbFunctions.getVendorUserName(userId).getSalt() ))  ){
				session.setAttribute("vendorUserId", userId);
				System.out.println("DoLogin line 96 "+ userId);
//				Vendor vendor = DbFunctions.selectVendorUserName(userId);
//				request.setAttribute("vendor",vendor );
//				getServletContext().getRequestDispatcher("/VendorView")
//				.forward(request, response);
				response.sendRedirect("VendorView"); 
			}
			else {
				request.setAttribute("loginMessage", "The UserId and Password combination did not match, Please try again");
				getServletContext().getRequestDispatcher("/login")
				.forward(request, response);
			}
			return;
		}
		if (DbFunctions.propManagerLogin(userId)!=null){
			propManagerPassword = DbFunctions.propManagerLogin(userId);
			if (propManagerPassword.equals(DbFunctions.hashPassword(password, DbFunctions.getPropManagerUserName(userId).getSalt() ))  ){
				session.setAttribute("userId", userId);
				session.setAttribute("pType", "propManager");
				session.setAttribute("propManager", DbFunctions.getPropManagerUserName(userId));
				getServletContext().getRequestDispatcher("/PropManagerView")
				.forward(request, response);
			}
			else {
				request.setAttribute("loginMessage", "The UserId and Password combination did not match, Please try again");
				getServletContext().getRequestDispatcher("/login")
				.forward(request, response);
			}
			return;
		}
//		if (ownerPassword.equals(password)  ){
//			session.setAttribute("userId", userId);
//			session.setAttribute("pType", "owner");
//			session.setAttribute("owner", DbFunctions.getOwnerUserName(userId));
//			getServletContext().getRequestDispatcher("/WEB-INF/ownerView.jsp")
//			.forward(request, response);
//			return;
//		}
//		if (tenantPassword.equals(password)  ){
//			
//			session.setAttribute("userId", userId);
//			session.setAttribute("pType", "tenant");
//			session.setAttribute("tenant", DbFunctions.selectTenantUserName(userId));
//			getServletContext().getRequestDispatcher("/WEB-INF/tenantView.jsp")
//			.forward(request, response);
//			return;
//		}
//		if (vendorPassword.equals(password)  ){
//			session.setAttribute("userId", userId);
//			session.setAttribute("pType", "vendor");
//			session.setAttribute("vendor", DbFunctions.selectVendorUserName(userId));
//			getServletContext().getRequestDispatcher("/WEB-INF/vendorView.jsp")
//			.forward(request, response);
//		}
//		if (propManagerPassword.equals(password)  ){
//			session.setAttribute("userId", userId);
//			session.setAttribute("pType", "propManager");
//			session.setAttribute("propManager", DbFunctions.getPropManagerUserName(userId));
//			getServletContext().getRequestDispatcher("/WEB-INF/propManagerView.jsp")
//			.forward(request, response);
//		}
		else {
			request.setAttribute("loginMessage", "The UserId and Password combination did not match, Please try again");
			getServletContext().getRequestDispatcher("/login")
			.forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
