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
@WebServlet("/AddOwner")
public class AddOwner extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOwner() {
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
		String activeTxt = request.getParameter("active");
		boolean activePerson;
		if (activeTxt=="true"){
			activePerson=true;
		} else{
			activePerson=false;
		}
		
		Owner owner = new Owner();
		owner.setActivePerson(activePerson);
		owner.setFirstName(firstName);
		owner.setMiddleName(middleName);
		owner.setLastName(lastName);
		owner.setPaymentMethod(paymentMethod);
		
//		DbFunctions.insert(owner);
		Object id = DbFunctions.insertObjectId(owner);
		Integer printid = Integer.parseInt(id.toString());
		
		request.getSession().setAttribute("id", id);
		System.out.println(10+printid);
		owner.setPersonId(printid);
		
			int emailPrimarytxt=0;
			if (request.getParameter("primaryEmail")!=null){
				emailPrimarytxt= Integer.parseInt(request.getParameter("primaryEmail"));
			}
	
		
		

		String[] emailAddressType=request.getParameterValues("emailAddressType");
		String[] emailAddress=request.getParameterValues("emailAddress");

		if (request.getParameter("emailAddressType")!=null){
			for (int i = 0; i < emailAddress.length; i++) {
				EmailAddress updateEmailAddress = new EmailAddress();
				updateEmailAddress.setPerson(owner);
				updateEmailAddress.setEmailAddress(emailAddress[i]);
				updateEmailAddress.setEmailAddressType(emailAddressType[i]);
				
				if (emailPrimarytxt ==i){
					updateEmailAddress.setPrimaryEmail(true);	
				} else {
					updateEmailAddress.setPrimaryEmail(false);
				}
				
				DbFunctions.insert(updateEmailAddress);
			}
		}
		
		int primaryNumberInt=0;
		if (request.getParameter("primaryNumber")!=null){
			primaryNumberInt= Integer.parseInt(request.getParameter("primaryNumber"));
		}
		
		
		String[] phoneType=request.getParameterValues("phoneType");
		String[] phoneNumber=request.getParameterValues("phoneNumber");

		
		for (int i = 0; i < phoneNumber.length; i++) {
			PhoneNumber updatePhoneNumber = new PhoneNumber();
			updatePhoneNumber.setPerson(owner);
			updatePhoneNumber.setPhoneType(phoneType[i]);
			updatePhoneNumber.setPhoneNumber(phoneNumber[i]);
			
			if (primaryNumberInt ==i){
				updatePhoneNumber.setPrimaryNumber(true);
			} else {
				updatePhoneNumber.setPrimaryNumber(false);
			}
			
			DbFunctions.insert(updatePhoneNumber);
		}
	
		
		
		int primaryAddressInt=0;
		if (request.getParameter("primaryAddress")!=null){
			primaryAddressInt= Integer.parseInt(request.getParameter("primaryAddress"));
		}
		

		String[] addressType=request.getParameterValues("addressType");
		String[] address1=request.getParameterValues("address1");
		String[] address2=request.getParameterValues("address2");
		String[] city=request.getParameterValues("city");
		String[] state=request.getParameterValues("state");
		String[] zip=request.getParameterValues("zip");
		
		
		
		for (int i = 0; i < addressType.length; i++) {
			Address updateAddress = new Address();
			updateAddress.setPerson(owner);
			updateAddress.setAddress1(address1[i]);
			updateAddress.setAddress2(address2[i]);
			updateAddress.setAddressType(addressType[i]);
			updateAddress.setCity(city[i]);
			updateAddress.setState(state[i]);
			updateAddress.setZip(zip[i]);
			
			
			
			
			if (primaryAddressInt ==i){
				updateAddress.setPrimaryAddress(true); 
			} else {
				updateAddress.setPrimaryAddress(false); 
			}
			
			DbFunctions.insert(updateAddress);
		}
		
		request.setAttribute("printid", printid);
		
		getServletContext().getRequestDispatcher("/DisplayOwnerRedirect")
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
