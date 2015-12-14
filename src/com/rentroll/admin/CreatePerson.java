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
 * Servlet implementation class CreatePerson
 */
@WebServlet("/CreatePerson")
public class CreatePerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePerson() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String middleName = request.getParameter("middleName");
		String lastName = request.getParameter("lastName");
		String isActiveTxt = request.getParameter("isActive");
		boolean isActive;
		if (isActiveTxt=="true"){
			isActive=true;
		} else{
			isActive=false;
		}
		
		
		String emailPrimarytxt= request.getParameter("emailPrimary");
		String emailAddressType = request.getParameter("emailAddressType");
		String emailAddress = request.getParameter("emailAddress");
		boolean emailPrimary;
		if (emailPrimarytxt=="true"){
			emailPrimary=true;
		} else{
			emailPrimary=false;
		}
		
		String addressPrimarytxt= request.getParameter("emailPrimary");
		String addressType = request.getParameter("emailAddressType");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		boolean addressPrimary;
		if (addressPrimarytxt=="true"){
			addressPrimary=true;
		} else{
			addressPrimary=false;
		}
		
		
		String phonePrimarytxt= request.getParameter("phonePrimary");
		String phoneType = request.getParameter("phoneType");
		String phoneNumber = request.getParameter("phoneNumber");
		boolean phonePrimary;
		if (phonePrimarytxt=="ture"){
			phonePrimary=true;
		} else{
			phonePrimary=false;
		}
		Person person = new Person(firstName, middleName, lastName);
		person.setActive(isActive);
		EmailAddress emailaddress1 = new EmailAddress(person, emailPrimary, emailAddressType, emailAddress);
		PhoneNumber phone = new PhoneNumber(person, phonePrimary, phoneType, phoneNumber);
		Address address = new Address(person, addressPrimary, addressType, address1, address2, city, state, zip);
		
		DbFunctions.insert(person);
		DbFunctions.insert(emailaddress1);
		DbFunctions.insert(phone);
		DbFunctions.insert(address);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
