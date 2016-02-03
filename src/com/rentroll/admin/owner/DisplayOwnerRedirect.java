package com.rentroll.admin.owner;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rentroll.business.Owner;
import com.rentroll.data.DbFunctions;

/**
 * Servlet implementation class AddOwnerRedirect
 */
@WebServlet("/DisplayOwnerRedirect")
public class DisplayOwnerRedirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayOwnerRedirect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if (request.getSession().getAttribute("id")==null){
			getServletContext().getRequestDispatcher("/index.html")
			.forward(request, response);
		}
		
		Object id = (Object)request.getSession().getAttribute("id");
		int ownerId1 = Integer.parseInt(id.toString());
		Owner DisplayOwner = DbFunctions.selectOwner(ownerId1);
		
		request.setAttribute("owner", DisplayOwner);
		
		getServletContext().getRequestDispatcher("/ownerDetail.jsp")
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
