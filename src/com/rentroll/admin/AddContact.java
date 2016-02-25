package com.rentroll.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rentroll.business.Contact;
import com.rentroll.data.DbFunctions;

/**
 * Servlet implementation class DoContact
 */
@WebServlet("/AddContact")
public class AddContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		RequestDispatcher dispatcher=getServletContext().getRequestDispatcher( "/WEB-INF/contactAdded.jsp" );
		dispatcher.forward( request, response );
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullName = request.getParameter("fullName");
		String comments = request.getParameter("comments");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		
		Contact contact = new Contact();
		contact.setFullName(fullName);
		contact.setEmail(email);
		contact.setPhone(phone);
		contact.setCity(city);
		contact.setPhone(phone);
		contact.setComments(comments);
		contact.setState(state);
		
		DbFunctions.insert(contact);
		
		request.setAttribute("fullName", fullName);
		doGet(request, response);
	}

}
