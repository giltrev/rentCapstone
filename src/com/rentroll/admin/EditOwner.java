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
 * Servlet implementation class EditOwner
 */
@WebServlet("/EditOwner")
public class EditOwner extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditOwner() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int personId = Integer.parseInt(request.getParameter("personId"));
		String firstName = request.getParameter("firstName");
		String middleName = request.getParameter("middleName");
		String lastName = request.getParameter("lastName");
		String paymentMethod = request.getParameter("paymentMethod");
		String activeTxt = request.getParameter("active");
		System.out.println(activeTxt);
		boolean activePerson;
		if (activeTxt=="true"){
			activePerson=true;
			System.out.println("true");
		} else{
			activePerson=false;
			System.out.println("false");
		}
		
		Owner owner = DbFunctions.selectOwner(personId);
		owner.setActivePerson(activePerson);
		owner.setFirstName(firstName);
		owner.setMiddleName(middleName);
		owner.setLastName(lastName);
		owner.setPaymentMethod(paymentMethod);
		
		DbFunctions.updateOwner(owner);
		
			int emailPrimarytxt=0;
			if (request.getParameter("primaryEmail")!=null){
				emailPrimarytxt= Integer.parseInt(request.getParameter("primaryEmail"));
			}
	
		
		
		String[] emailAddressId=request.getParameterValues("emailAddressId");
		String[] emailAddressType=request.getParameterValues("emailAddressType");
		String[] emailAddress=request.getParameterValues("emailAddress");

		
		
		if (request.getParameter("emailAddressId")=="0"){
			for (int i = 0; i < emailAddress.length; i++) {
				EmailAddress updateEmailAddress = DbFunctions.selectEmailAddress(Integer.parseInt(emailAddressId[i]));
				
				updateEmailAddress.setEmailAddress(emailAddress[i]);
				updateEmailAddress.setEmailAddressType(emailAddressType[i]);
				
				if (emailPrimarytxt ==i){
					updateEmailAddress.setPrimaryEmail(true);	
				} else {
					updateEmailAddress.setPrimaryEmail(false);
				}
				if (emailAddressId[i]==null){
					DbFunctions.insert(updateEmailAddress);
				}else {
					DbFunctions.update(updateEmailAddress);
				}
				
			}
		}
		
		int primaryNumberInt=0;
		if (request.getParameter("primaryNumber")!=null){
			primaryNumberInt= Integer.parseInt(request.getParameter("primaryNumber"));
		}
		
		String[] phoneNumberId=request.getParameterValues("phoneNumberId");
		String[] phoneType=request.getParameterValues("phoneType");
		String[] phoneNumber=request.getParameterValues("phoneNumber");

		
		for (int i = 0; i < phoneNumberId.length; i++) {
			PhoneNumber updatePhoneNumber = DbFunctions.selectPhoneNumber(Integer.parseInt(phoneNumberId[i]));
			
			updatePhoneNumber.setPhoneType(phoneType[i]);
			updatePhoneNumber.setPhoneNumber(phoneNumber[i]);
			
			if (primaryNumberInt ==i){
				updatePhoneNumber.setPrimaryNumber(true);
			} else {
				updatePhoneNumber.setPrimaryNumber(false);
			}
			
			DbFunctions.update(updatePhoneNumber);
		}
	
		
		
		int primaryAddressInt=0;
		if (request.getParameter("primaryAddress")!=null){
			primaryAddressInt= Integer.parseInt(request.getParameter("primaryAddress"));
		}
		
		String[] addressId=request.getParameterValues("addressId");
		String[] addressType=request.getParameterValues("addressType");
		String[] address1=request.getParameterValues("address1");
		String[] address2=request.getParameterValues("address2");
		String[] city=request.getParameterValues("city");
		String[] state=request.getParameterValues("state");
		String[] zip=request.getParameterValues("zip");
		
		
		
		for (int i = 0; i < addressId.length; i++) {
			Address updateAddress = DbFunctions.selectAddress(Integer.parseInt(addressId[i]));
			
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
			
			DbFunctions.update(updateAddress);
		}
		
		request.setAttribute("personId", owner.getPersonId());
		
		getServletContext().getRequestDispatcher("/OwnerDetails")
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
