package com.rentroll.admin.owner;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rentroll.business.Owner;
import com.rentroll.business.Person;
import com.rentroll.data.DbFunctions;

/**
 * Servlet implementation class OwnerDetails
 */
@WebServlet("/OwnerDetails")
public class OwnerDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OwnerDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int personId = Integer.parseInt(request.getParameter("personId"));
		
		Owner owner = DbFunctions.selectOwner(personId);
		
		Person person = (Person)owner;
		request.setAttribute("person", person);
		request.setAttribute("owner", owner);
		
		
		
		getServletContext().getRequestDispatcher("/WEB-INF/ownerDetail.jsp")
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
