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
import com.rentroll.data.DbFunctions;

/**
 * Servlet implementation class CreateOwner
 */
@WebServlet("/CreateOwner")
public class CreateOwner extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateOwner() {
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
		String paymentMethod = request.getParameter("paymentMethod");
		String isActiveTxt = request.getParameter("isActive");
		boolean isActive;
		if (isActiveTxt=="true"){
			isActive=true;
		} else{
			isActive=false;
		}
		
		
		
		String emailPrimarytxt= request.getParameter("emailAddressPrimary");
		String emailAddressType1 = request.getParameter("emailAddressType1");
		String emailAddress1 = request.getParameter("emailAddress1");
		
		boolean emailPrimary1;
		if (emailPrimarytxt.equals("1")){
			emailPrimary1=true;
		} else{
			emailPrimary1=false;
		}
		
		System.out.println(emailPrimarytxt);
		String emailAddressType2 = request.getParameter("emailAddressType2");
		String emailAddress2 = request.getParameter("emailAddress2");
		boolean emailPrimary2;
		if (emailPrimarytxt.equals("2")){
			emailPrimary2=true;
		} else{
			emailPrimary2=false;
		}
		
		
		String emailAddressType3 = request.getParameter("emailAddressType3");
		String emailAddress3 = request.getParameter("emailAddress3");
		boolean emailPrimary3;
		if (emailPrimarytxt.equals("3")){
			emailPrimary3=true;
		} else{
			emailPrimary3=false;
		}
		
		
		
		
		
		String addressPrimarytxt= request.getParameter("addressPrimary");
		
		
		String addressType1 = request.getParameter("emailAddressType1");
		String address1_1 = request.getParameter("address1_1");
		String address2_1 = request.getParameter("address1_2");
		String city1 = request.getParameter("city1");
		String state1 = request.getParameter("state1");
		String zip1 = request.getParameter("zip1");
		boolean addressPrimary1;
		if (addressPrimarytxt.equals("1")){
			addressPrimary1=true;
		} else{
			addressPrimary1=false;
		}
		
		String addressType2 = request.getParameter("emailAddressType2");
		String address1_2 = request.getParameter("address1_2");
		String address2_2 = request.getParameter("address2_2");
		String city2 = request.getParameter("city2");
		String state2 = request.getParameter("state2");
		String zip2 = request.getParameter("zip2");
		boolean addressPrimary2;
		if (addressPrimarytxt.equals("2")){
			addressPrimary2=true;
		} else{
			addressPrimary2=false;
		}
		
		String addressType3 = request.getParameter("emailAddressType3");
		String address1_3 = request.getParameter("address1_3");
		String address2_3 = request.getParameter("address2_3");
		String city3 = request.getParameter("city3");
		String state3 = request.getParameter("state3");
		String zip3 = request.getParameter("zip3");
		boolean addressPrimary3;
		if (addressPrimarytxt.equals("3")){
			addressPrimary3=true;
		} else{
			addressPrimary3=false;
		}
		
		
		String phonePrimarytxt= request.getParameter("phonePrimary");
		
		String phoneType1 = request.getParameter("phoneType1");
		String phoneNumber1 = request.getParameter("phoneNumber1");
		boolean phonePrimary1;
		if (phonePrimarytxt=="ture"){
			phonePrimary1=true;
		} else{
			phonePrimary1=false;
		}
		
		String phoneType2 = request.getParameter("phoneType2");
		String phoneNumber2 = request.getParameter("phoneNumber2");
		boolean phonePrimary2;
		if (phonePrimarytxt=="ture"){
			phonePrimary2=true;
		} else{
			phonePrimary2=false;
		}
		
		String phoneType3 = request.getParameter("phoneType3");
		String phoneNumber3 = request.getParameter("phoneNumber3");
		boolean phonePrimary3;
		if (phonePrimarytxt=="ture"){
			phonePrimary3=true;
		} else{
			phonePrimary3=false;
		}
		
		Owner owner = new Owner();
		owner.setActive(isActive);
		owner.setFirstName(firstName);
		owner.setMiddleName(middleName);
		owner.setLastName(lastName);
		owner.setPaymentMethod(paymentMethod);
		
		
		EmailAddress emailaddress1 = new EmailAddress(owner, emailPrimary1, emailAddressType1, emailAddress1);
		EmailAddress emailaddress2 = new EmailAddress(owner, emailPrimary2, emailAddressType2, emailAddress2);
		EmailAddress emailaddress3 = new EmailAddress(owner, emailPrimary3, emailAddressType3, emailAddress3);
		
		PhoneNumber phone1 = new PhoneNumber(owner, phonePrimary1, phoneType1, phoneNumber1);
		PhoneNumber phone2 = new PhoneNumber(owner, phonePrimary2, phoneType2, phoneNumber2);
		PhoneNumber phone3 = new PhoneNumber(owner, phonePrimary3, phoneType3, phoneNumber3);
		
		Address address1 = new Address(owner, addressPrimary1, addressType1, address1_1, address2_1, city1, state1, zip1);
		Address address2 = new Address(owner, addressPrimary2, addressType2, address1_2, address2_2, city2, state2, zip2);
		Address address3 = new Address(owner, addressPrimary3, addressType3, address1_3, address2_3, city3, state3, zip3);

		DbFunctions.insert(owner);
		System.out.println("email addres 1" +emailAddress1);
		if (emailAddress1.length() >2){
			DbFunctions.insert(emailaddress1);
		}
		
		System.out.println("email addres 2" +emailAddress2);
		if (emailAddress2.length() >2){
			DbFunctions.insert(emailaddress2);
		}
		System.out.println("email addres 3" +emailAddress3);
		if (emailAddress3.length() >2){
			DbFunctions.insert(emailaddress3);
		}
		if (phoneNumber1.length() >6){
			DbFunctions.insert(phone1);
		}
		if (phoneNumber2.length() >6){
			DbFunctions.insert(phone2);
		}
		if (phoneNumber3.length() >6){
			DbFunctions.insert(phone3);
		}
		if (address1_1.length() >3){
			DbFunctions.insert(address1);
		}
		if (address1_2.length() >3){
			DbFunctions.insert(address2);
		}
		
		if (address1_3.length() >3){
			DbFunctions.insert(address3);
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
