<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<my:tenant>
	<jsp:attribute name="body">
		
		<div class="content">
		    <h3>Welcome <c:out value="${tenant.firstName}" />. </h3>
		    <c:if test="${addedTotal < 0}"> 
		    <h5>
		    You owe <c:out value="${absValueTotal}" />
		    </h5>
		    </c:if>
		    
		    
		     <c:if test="${not empty tenant.unit.ledgerEntries}"> 
		     <h4>Rent Ledger</h4>
		     <table class="table table-hover">
				  <tr>
				    <th>Date</th>
				    <th>Account Name</th> 
				    <th>Reference</th> 
				    <th>Debit</th> 
				    <th>Credit</th> 
				    
				  </tr>			     
		     <c:forEach var="ledgerEntry" items="${tenant.unit.ledgerEntries}">
	     
		     
		     <tr>
			     <td> <c:out value="${ledgerEntry.date}" /> </td>
			     <td> <c:out value="${ledgerEntry.accountName}" />  </td>
			     <td><c:out value="${ledgerEntry.reference}" /> </td>
			     <td><c:out value="${ledgerEntry.debit}" /> </td>
			     <td><c:out value="${ledgerEntry.credit}" /> </td>
		     </tr>
		     </c:forEach>
		     <tr>
			     <td> </td>
			     <td>  </td>
			     <td> </td>
			     <td><c:out value="${debitTotal}" /> </td>
			     <td><c:out value="${creditTotal}" /> </td>
		     </tr>
		     </table>
		     
		     </c:if>
		    
		    <c:if test="${not empty tenant.unit.serviceCalls}"> 
		    <h4>Service Calls</h4>
		     	<h5>You have <c:out value="${fn:length(tenant.unit.serviceCalls)}" /> Service Call(s). </h5>
		     <table class="table table-hover">
				  <tr>
				    <th>ID</th>
				    <th>Description</th> 
				    <th>Date Open</th> 
				    <th>Status</th> 
				    <th>Assigned Vendor 
				    <br>Vendor Comments</th> 
				    <th>Vendor Picture</th>
				    
				  </tr>
				  <c:forEach var="serviceCall" items="${tenant.unit.serviceCalls}">
						  <tr >
						    <td><c:out value="${serviceCall.scId}" /></td>
						    <td><c:out value="${serviceCall.serviceCallDetail}" /></td>
						    <td><fmt:formatDate value="${serviceCall.initTime}" pattern="MM-dd-yyyy" /></td>
						    <td><c:out value="${serviceCall.status}" /><br><c:out value="${serviceCall.vendorComments}" /></td>
						    
						    <td>	
			    		    <c:if test="${serviceCall.vendors!=null}"> 
						    	<c:forEach var="vendor" items="${serviceCall.vendors}">
							    		<c:out value="${vendor.companyName}" /><br>
							    		<c:out value="${vendor.firstName}" /> <c:out value="${vendor.lastName}" />
							    </c:forEach>
							</c:if>
						   </td>
						   <td>
						     <c:forEach var="vendor" items="${serviceCall.vendors}">
								<img alt="<c:out value="${vendor.firstName}" />" src="displayImage?id=<c:out value="${vendor.picture.picId}" />" height="150">	<br>	
							</c:forEach>
							</td>
						  </tr>
			     	</c:forEach>
			</table>
		     
		  </c:if>		
		
		    
		<!-- end .content --></div>
	
	</jsp:attribute>
</my:tenant>