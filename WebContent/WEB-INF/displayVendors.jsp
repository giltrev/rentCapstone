<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<my:propManager>
	<jsp:attribute name="body">
		<div class="content">
			<h3>Vendors</h3>


		
					<table class="table table-hover">
				  <tr>
				   
				    <th>Company Name<br> Name</th> 
				    <th>Vendor Type</th>
				   <!--  <th>Address</th> -->
				    <th>Phone Number</th>
				    <th>Email Address</th>
				  </tr>
				  <c:forEach var="vendor" items="${allVendors}">
				  <tr class='clickable-row' data-href='VendorDetail?personId=<c:out value="${vendor.personId}" />'>
				    <td><c:out value="${vendor.companyName}" /><br>
				    <c:out value="${vendor.firstName}" /> <c:out value="${vendor.lastName}" /></td> 
<%-- 				    <td>
					    <c:forEach var="address" items="${vendor.addresses}">
					    	<c:if test="${address.primaryAddress}"> 
					    		<c:out value="${address.address1}" /><br>
					    			<c:if test="not empty ${address.address2}">
					    				<c:out value="${address.address2}" /><br>
					    			</c:if>
					    		<c:out value="${address.city}" />, <c:out value="${address.state}" />  <c:out value="${address.zip}" />
					    		
					    	</c:if> 
					    </c:forEach>
				    </td> --%>
				    
				    <td><c:out value="${vendor.vendorType}" /></td>
				    <td>				    
					    <c:forEach var="phoneNumber" items="${vendor.phoneNumbers}">
					    	<c:if test="${phoneNumber.primaryNumber}">
					    		<c:out value="${phoneNumber.phoneNumber}" />
					    	</c:if>
					    </c:forEach>
				    </td>
				   	<td>				    
					    <c:forEach var="email" items="${vendor.emailAddresses}">
					    	<c:if test="${email.primaryEmail}">
					    		<c:out value="${email.emailAddress}" />
					    	</c:if>
					    </c:forEach>
				    </td>
				  </tr>
				</c:forEach>
			</table>
		
		<!-- end .content --></div>		
		
	</jsp:attribute>
</my:propManager>