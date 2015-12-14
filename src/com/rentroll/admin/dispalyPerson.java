package com.rentroll.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rentroll.business.Person;
import com.rentroll.data.DbFunctions;
import com.rentroll.data.PersonDB;

/**
 * Servlet implementation class dispalyPerson
 */
@WebServlet("/dispalyPerson")
public class dispalyPerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dispalyPerson() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PersonDB perDB = new PersonDB();
		Person selectedPerson = perDB.selectPerson(2);
		System.out.println(selectedPerson.getFirstName());
		
		
		List<Person> persons = DbFunctions.selectActivePerons();
		System.out.println("Persons's Size is " + persons.size());
		
		
		List<Person> allPersons = DbFunctions.selectAllPerons();
		System.out.println("Total Persons is " + allPersons.size());
		
		
		request.setAttribute("allPersons", allPersons);
		
		getServletContext().getRequestDispatcher("/dispplayPersons.jsp")
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
