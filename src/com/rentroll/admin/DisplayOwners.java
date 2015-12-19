package com.rentroll.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rentroll.business.EmailAddress;
import com.rentroll.business.Owner;
import com.rentroll.business.PhoneNumber;
import com.rentroll.business.Property;
import com.rentroll.business.Tenant;
import com.rentroll.business.Unit;
import com.rentroll.data.DbFunctions;


/**
 * Servlet implementation class DisplayOwners
 */
@WebServlet("/DisplayOwners")
public class DisplayOwners extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayOwners() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Owner joe = new Owner("Joe","Jack","Jackson");
		Owner jack = new Owner("Jack","Richard","Cranial");
		DbFunctions.insert(jack);
		DbFunctions.insert(joe);
		
		
		Property joeProp = new Property();
		joeProp.setAddress1("6649 N Blue Gum St");
		joeProp.setCity("Austin");
		joeProp.setOwner(joe);
		joeProp.setPropertyType("Duplex");
		joeProp.setNumberOfUnits(2);
		joeProp.setZip("78704");
		
		Property joeProp2 = new Property();
		joeProp2.setAddress1("74874 Atlantic Ave");
		joeProp2.setCity("Austin");
		joeProp2.setOwner(joe);
		joeProp2.setPropertyType("Apratment");
		joeProp2.setNumberOfUnits(102);
		joeProp2.setZip("78774");
		
		
		
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
		jackProp2.setAddress1("7 W Jackson Blvd");
		jackProp2.setCity("Austin");
		jackProp2.setOwner(joe);
		jackProp2.setPropertyType("Apratment");
		jackProp2.setNumberOfUnits(102);
		jackProp2.setZip("78774");
		
		DbFunctions.insert(jackProp2);
		

		
		EmailAddress joeEmail = new EmailAddress(joe, true, "Home", "joe@aol.com");
		EmailAddress joeEmail2 = new EmailAddress(joe, false, "Work", "joe@business.com");
		EmailAddress jackEmail = new EmailAddress(jack, false, "Home", "joe@aol.com");
		EmailAddress jackEmail2 = new EmailAddress(jack, true, "Work", "joe@business.com");
		
		PhoneNumber joePhone = new PhoneNumber(joe, true , "Home", "512-463-4756");
		PhoneNumber joePhone2 = new PhoneNumber(joe, false , "work", "512-463-4756");
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
		
		
		
		List<Owner> allOwners = DbFunctions.selectAllOwners();
		System.out.println("Total Persons is " + allOwners.size());
		
		
		request.setAttribute("allPersons", allOwners);
		
		getServletContext().getRequestDispatcher("/displayOwners.jsp")
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
