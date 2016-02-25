package com.rentroll.admin.propertymanager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rentroll.business.Contact;
import com.rentroll.data.DbFunctions;

/**
 * Servlet implementation class PropManagerView
 */
@WebServlet("/PropManagerView")
public class PropManagerView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PropManagerView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Contact> contacts = new ArrayList<>();
		contacts = DbFunctions.selectActiveContacts();
		System.out.println("Porop ManagerView line 83");
		request.setAttribute("contacts", contacts);
		System.out.println("contacts size "+ contacts.size());
		getServletContext().getRequestDispatcher("/WEB-INF/propManagerView.jsp")
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
