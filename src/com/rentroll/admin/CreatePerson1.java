package com.rentroll.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rentroll.business.EmailAddress;
import com.rentroll.business.Person1;
import com.rentroll.business.PhoneNumber;
import com.rentroll.data.DbFunctions;

/**
 * Servlet implementation class CreatePerson1
 */
@WebServlet("/CreatePerson1")
public class CreatePerson1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePerson1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Person1 person1 = new Person1();
		
		
		person1.setFirstName("Gilbert");
		person1.setLastName("Trevino");
		person1.setMiddleName("jose");
		person1.setCompanyName("HEB");
		
		
		PhoneNumber joehomephone =new PhoneNumber(person1, false, "Home","5124473748");
		PhoneNumber roberthomephone =new PhoneNumber(person1,false , "Home","5124473748");
		
		DbFunctions.insert(person1);
		DbFunctions.insert(joehomephone);
		DbFunctions.insert(roberthomephone);
		
		
		EmailAddress joeHome= new EmailAddress(person1,false, "home", "joe@aol.com");
		EmailAddress joeWork= new EmailAddress(person1,true, "work", "joe@aol.com");
		EmailAddress joeOther= new EmailAddress(person1,false, "other", "joe@aol.com");
		
		DbFunctions.insert(joeHome);
		DbFunctions.insert(joeWork);
		DbFunctions.insert(joeOther);
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
