package com.rentroll.admin.vendor;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rentroll.business.Address;
import com.rentroll.business.EmailAddress;
import com.rentroll.business.PhoneNumber;
import com.rentroll.business.PropertyManager;
import com.rentroll.business.Vendor;
import com.rentroll.data.DbFunctions;

/**
 * Servlet implementation class AddVenor
 */
@WebServlet("/AddVenor")
public class AddVenor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVenor() {
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
		String paymentType = request.getParameter("paymentType");
		String vendorType = request.getParameter("vendorType");
		String companyName = request.getParameter("companyName");
		String activeTxt = request.getParameter("active");
		boolean activePerson;
		if (activeTxt=="true"){
			activePerson=true;
		} else{
			activePerson=false;
		}
		
		Vendor vendor = new Vendor();
		vendor.setActivePerson(activePerson);
		vendor.setFirstName(firstName);
		vendor.setMiddleName(middleName);
		vendor.setLastName(lastName);
		vendor.setPaymentType(paymentType);
		vendor.setVendorType(vendorType);
		vendor.setCompanyName(companyName);
		
//		DbFunctions.insert(owner);
//		Object id = DbFunctions.insertObjectId(owner);
//		Integer printid = Integer.parseInt(id.toString());
		
//		request.getSession().setAttribute("ownerid", id);
//		System.out.println(10+printid);
//		owner.setPersonId(printid);
		HttpSession session = request.getSession();
		vendor.setCreatedBy((PropertyManager)session.getAttribute("propManager"));
		System.out.println(vendor.getCreatedBy().getFirstName());
		DbFunctions.insert(vendor);
		
		int emailPrimarytxt=0;
		if (request.getParameter("primaryEmail")!=null){
			emailPrimarytxt= Integer.parseInt(request.getParameter("primaryEmail"));
		}
	
		
		

		String[] emailAddressType=request.getParameterValues("emailAddressType");
		String[] emailAddress=request.getParameterValues("emailAddress");
		
		Set<EmailAddress> emailAddresses = new HashSet<>();
		
		if (request.getParameter("emailAddressType")!=null){
			for (int i = 0; i < emailAddress.length; i++) {
				if (emailAddress[i].length()>6 ){
					EmailAddress updateEmailAddress = new EmailAddress();
					updateEmailAddress.setEmailAddress(emailAddress[i]);
					updateEmailAddress.setEmailAddressType(emailAddressType[i]);
					
					if (emailPrimarytxt ==i){
						updateEmailAddress.setPrimaryEmail(true);	
					} else {
						updateEmailAddress.setPrimaryEmail(false);
					}
					emailAddresses.add(updateEmailAddress);
					DbFunctions.insert(updateEmailAddress);
					}
			}
		}
		
		int primaryNumberInt=-1;
		if (request.getParameter("primaryNumber")!=null){
			primaryNumberInt= Integer.parseInt(request.getParameter("primaryNumber"));
		}
		
		
		String[] phoneType=request.getParameterValues("phoneType");
		String[] phoneNumber=request.getParameterValues("phoneNumber");

		Set<PhoneNumber> phoneNumbers = new HashSet<>();
		for (int i = 0; i < phoneNumber.length; i++) {
			if (phoneNumber[i].length()>9 ){
				PhoneNumber updatePhoneNumber = new PhoneNumber();
				updatePhoneNumber.setPhoneType(phoneType[i]);
				updatePhoneNumber.setPhoneNumber(phoneNumber[i]);
				
				if (primaryNumberInt ==i){
					updatePhoneNumber.setPrimaryNumber(true);
				} else {
					updatePhoneNumber.setPrimaryNumber(false);
				}
				phoneNumbers.add(updatePhoneNumber);
				DbFunctions.insert(updatePhoneNumber);
			}
		}
		
		
		int primaryAddressInt=-1;
		if (request.getParameter("primaryAddress")!=null){
			primaryAddressInt= Integer.parseInt(request.getParameter("primaryAddress"));
		}
		

		String[] addressType=request.getParameterValues("addressType");
		String[] address1=request.getParameterValues("address1");
		String[] address2=request.getParameterValues("address2");
		String[] city=request.getParameterValues("city");
		String[] state=request.getParameterValues("state");
		String[] zip=request.getParameterValues("zip");
		
		
		Set <Address> addresses = new HashSet<>();
		for (int i = 0; i < addressType.length; i++) {
			if (address1[i].length()>4 ){
			Address updateAddress = new Address();
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
			addresses.add(updateAddress);
			DbFunctions.insert(updateAddress);
			}
		}
		
		

		
		vendor.setEmailAddresses(emailAddresses);
		vendor.setPhoneNumbers(phoneNumbers);
		vendor.setAddresses(addresses);
		DbFunctions.update(vendor);
		
		request.setAttribute("vendor", vendor);
		
		getServletContext().getRequestDispatcher("/WEB-INF/vendorDetail.jsp")
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
