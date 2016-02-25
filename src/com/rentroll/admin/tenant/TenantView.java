package com.rentroll.admin.tenant;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rentroll.business.LedgerEntry;
import com.rentroll.business.Tenant;

/**
 * Servlet implementation class TenantVeiw
 */
@WebServlet("/TenantView")
public class TenantView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TenantView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		
		
		
		Tenant tenant = (Tenant)session.getAttribute("tenant");
		
		
		
		BigDecimal addedTotal  = new BigDecimal(0);
		BigDecimal creditTotal  = new BigDecimal(0);
		BigDecimal debitTotal  = new BigDecimal(0);
//		BigDecimal absValueTotal  = new BigDecimal(0);
		
		if (tenant.getUnit().getLedgerEntries() !=null){
			
			List <LedgerEntry> ledgerEntires = new ArrayList<>();
			ledgerEntires.addAll(tenant.getUnit().getLedgerEntries()) ;
			
			
			for (Iterator<LedgerEntry> iterator = ledgerEntires.iterator(); iterator.hasNext();) {
				LedgerEntry ledgerEntry = (LedgerEntry) iterator.next();
				creditTotal = creditTotal.add(ledgerEntry.getCredit())  ;
				debitTotal = debitTotal.add(ledgerEntry.getDebit());
			}	
		}
		
		addedTotal = addedTotal.subtract(debitTotal);
		addedTotal = addedTotal.add(creditTotal);
		BigDecimal absValueTotal  = addedTotal.abs();
		
		
		System.out.println("debitTotal" + debitTotal);
		System.out.println("creditTotal" + creditTotal);
		System.out.println("addedTotal" + addedTotal);
		System.out.println("absValueTotal" + absValueTotal);
		
		
		
		request.setAttribute("absValueTotal", absValueTotal);
		request.setAttribute("addedTotal", addedTotal);
		request.setAttribute("creditTotal", creditTotal);
		request.setAttribute("debitTotal", debitTotal);
		
		getServletContext().getRequestDispatcher("/WEB-INF/tenantView.jsp")
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
