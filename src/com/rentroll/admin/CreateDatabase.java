package com.rentroll.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rentroll.business.Address;
import com.rentroll.business.EmailAddress;
import com.rentroll.business.Owner;
import com.rentroll.business.PhoneNumber;
import com.rentroll.business.Property;
import com.rentroll.business.Tenant;
import com.rentroll.business.Unit;
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
		Owner robert= new Owner("Robert", "Joseph","Hogan");
		Owner joe= new Owner("Joe","Jack", "Shmuck");
		Owner jane= new Owner("Jane","Rose", "Smith");
		
		DbFunctions.insert(joe);
		DbFunctions.insert(robert);
		DbFunctions.insert(jane);
		
		
		PhoneNumber joehome =new PhoneNumber(joe, false, "Home","5124473748");
		PhoneNumber roberthome =new PhoneNumber(jane,false , "Home","5124473748");
		PhoneNumber robertcell =new PhoneNumber(robert,true , "Cell","5124473748");
		PhoneNumber robertcell1 =new PhoneNumber(robert,false , "Home","512412344");
		PhoneNumber robertcell2 =new PhoneNumber(robert,false , "Work","512443248");
		
		DbFunctions.insert(joehome);
		DbFunctions.insert(roberthome);
		DbFunctions.insert(robertcell);
		DbFunctions.insert(robertcell1);
		DbFunctions.insert(robertcell2);
		
		
		EmailAddress joeHome= new EmailAddress(joe,false, "home", "joe@aol.com");
		EmailAddress joeWork= new EmailAddress(joe,true, "work", "joe@aol.com");
		EmailAddress joeOther= new EmailAddress(joe,false, "other", "joe@aol.com");
		

		DbFunctions.insert(joeHome);
		DbFunctions.insert(joeWork);
		DbFunctions.insert(joeOther);
		
		Address joehomeAddress = new Address(joe,false,"home", "123 Main St", "","Austin", "Texas", "78704");
		Address joeworkAddress = new Address(joe,true,"work", "123 Main St", "","Austin", "Texas", "78704");
		joeworkAddress.setPrimaryAddress(true);

		DbFunctions.insert(joehomeAddress);
		DbFunctions.insert(joeworkAddress);
		
		Owner joey = new Owner("Joey","Jack","Jackson");
		Owner jack = new Owner("Jack","Richard","Cranial");
		DbFunctions.insert(jack);
		DbFunctions.insert(joey);
		
		
		Property joeProp = new Property();
		joeProp.setPropAddress1("6649 N Blue Gum St");
		joeProp.setPropCity("Austin");
		joeProp.setOwner(joey);
		joeProp.setPropertyType("Duplex");
		joeProp.setNumberOfUnits(2);
		joeProp.setPropZip("78704");
		
		Property joeProp2 = new Property();
		joeProp2.setPropAddress1("74874 Atlantic Ave");
		joeProp2.setPropCity("Austin");
		joeProp2.setOwner(joey);
		joeProp2.setPropertyType("Apratment");
		joeProp2.setNumberOfUnits(102);
		joeProp2.setPropZip("78774");
		
		
		
		DbFunctions.insert(joeProp);
		DbFunctions.insert(joeProp2);
		
		
		
		
		
		Unit joePropUnit1 = new Unit();
		joePropUnit1.setProperty(joeProp2);
		joePropUnit1.setNumberOfBathrooms(2);
		
		DbFunctions.insert(joePropUnit1);
		
		
		Tenant roger = new Tenant();
		roger.setFirstName("Willard");
		roger.setMiddleName("Roger");
		roger.setLastName("Kolmetz");
		roger.setUnit(joePropUnit1);
		
		DbFunctions.insert(roger);
		
		Property jackProp2 = new Property();
		jackProp2.setPropAddress1("7 W Jackson Blvd");
		jackProp2.setPropCity("Austin");
		jackProp2.setOwner(joe);
		jackProp2.setPropertyType("Apratment");
		jackProp2.setNumberOfUnits(102);
		jackProp2.setPropZip("78774");
		
		DbFunctions.insert(jackProp2);
		

		
		EmailAddress joeEmail = new EmailAddress(joey, true, "Home", "joe@aol.com");
		EmailAddress joeEmail2 = new EmailAddress(joey, false, "Work", "joe@business.com");
		EmailAddress jackEmail = new EmailAddress(jack, false, "Home", "joe@aol.com");
		EmailAddress jackEmail2 = new EmailAddress(jack, true, "Work", "joe@business.com");
		
		PhoneNumber joePhone = new PhoneNumber(joey, true , "Home", "512-463-4756");
		PhoneNumber joePhone2 = new PhoneNumber(joey, false , "work", "512-463-4756");
		PhoneNumber jackPhone = new PhoneNumber(jack, true , "Home", "512-463-4756");
		PhoneNumber jackPhone2 = new PhoneNumber(jack, false , "work", "512-463-4756");
		
		DbFunctions.insert(joePhone);
		DbFunctions.insert(joePhone2);
		DbFunctions.insert(jackPhone);
		DbFunctions.insert(jackPhone2);
		
		
		DbFunctions.insert(joeEmail);
		DbFunctions.insert(joeEmail2);
		DbFunctions.insert(jackEmail);
		DbFunctions.insert(jackEmail2);
		
		
		
		getServletContext().getRequestDispatcher("/index.html")
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
