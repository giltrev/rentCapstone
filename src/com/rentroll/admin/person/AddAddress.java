package com.rentroll.admin.person;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rentroll.business.Address;
import com.rentroll.business.Owner;
import com.rentroll.data.DbFunctions;

/**
 * Servlet implementation class AddAddress
 */
@WebServlet("/AddAddress")
public class AddAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAddress() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int personId = Integer.parseInt(request.getParameter("personId"));
		Owner owner = DbFunctions.selectOwner(personId);
		
		String addressType=request.getParameter("addressType");
		String address1=request.getParameter("address1");
		String address2=request.getParameter("address2");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String zip=request.getParameter("zip");
		
		String primaryText="false";
		if (request.getParameter("primaryAddress")!=null){
		primaryText=request.getParameter("primaryAddress");
		}
		Boolean primaryAddress = Boolean.parseBoolean(primaryText);
		
		
		
		Address updateAddress= new Address();
			
			updateAddress.setAddress1(address1);
			updateAddress.setAddress2(address2);
			updateAddress.setAddressType(addressType);
			updateAddress.setCity(city);
			updateAddress.setState(state);
			updateAddress.setZip(zip);
			updateAddress.setPerson(owner);
			updateAddress.setPrimaryAddress(primaryAddress);
			
			
			DbFunctions.insert(updateAddress);
		}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
