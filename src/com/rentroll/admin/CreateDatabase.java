package com.rentroll.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rentroll.business.Address;
import com.rentroll.business.EmailAddress;
import com.rentroll.business.Person;
import com.rentroll.business.PhoneNumber;
import com.rentroll.data.DbFunctions;

/**
 * Servlet implementation class CreateDatabase
 */
@WebServlet("/CreateDatabase")
public class CreateDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateDatabase() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Person robert= new Person("Robert", "Hogan");
		Person joe= new Person("Joe", "Shmuck");
		Person jane= new Person("Jane", "Smith");
		
		DbFunctions.insert(joe);
		DbFunctions.insert(robert);
		DbFunctions.insert(jane);
		
		
		PhoneNumber joehome =new PhoneNumber(joe, "Home","5124473748");
		PhoneNumber roberthome =new PhoneNumber(jane, "Home","5124473748");
		PhoneNumber robertcell =new PhoneNumber(robert, "Cell","5124473748");
		PhoneNumber robertcell1 =new PhoneNumber(robert, "Home","512412344");
		PhoneNumber robertcell2 =new PhoneNumber(robert, "Work","512443248");
		
		DbFunctions.insert(joehome);
		DbFunctions.insert(roberthome);
		DbFunctions.insert(robertcell);
		DbFunctions.insert(robertcell1);
		DbFunctions.insert(robertcell2);
		
		
		EmailAddress joeHome= new EmailAddress(joe, "home", "joe@aol.com");
		EmailAddress joeWork= new EmailAddress(joe, "work", "joe@aol.com");
		EmailAddress joeOther= new EmailAddress(joe, "other", "joe@aol.com");
		

		DbFunctions.insert(joeHome);
		DbFunctions.insert(joeWork);
		DbFunctions.insert(joeOther);
		
		Address joehomeAddress = new Address(joe,"home", "123 Main St", "","Austin", "Texas", "78704");
		Address joeworkAddress = new Address(joe,"work", "123 Main St", "","Austin", "Texas", "78704");
		joeworkAddress.setPrimaryAddress(true);

		DbFunctions.insert(joehomeAddress);
		DbFunctions.insert(joeworkAddress);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
