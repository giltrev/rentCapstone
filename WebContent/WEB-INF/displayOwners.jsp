<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<my:propManager>
	<jsp:attribute name="body">
		  	<div class="content">
			  	<h3>Owners</h3>
			<table class="table table-hover">
				  <tr>
				    <th>Name</th> 
				    <th>Address</th>
				    <th>Phone Number</th>
				    <th>Email Address</th>
				  </tr>
				  <c:forEach var="owner" items="${allOwners}">
				  <tr class='clickable-row' data-href='OwnerDetails?personId=<c:out value="${owner.personId}" />'>
				    <td><c:out value="${owner.firstName}" /> <c:out value="${owner.lastName}" /></td> 
				    <td>
					    <c:forEach var="address" items="${owner.addresses}">
					    	<c:if test="${address.primaryAddress}"> 
					    		<c:out value="${address.address1}" /><br>
					    			<c:if test="not empty ${address.address2}">
					    				<c:out value="${address.address2}" /><br>
					    			</c:if>
					    		<c:out value="${address.city}" />, <c:out value="${address.state}" />  <c:out value="${address.zip}" />
					    		
					    	</c:if> 
					    </c:forEach>
				    </td>
				    <td>				    
					    <c:forEach var="phoneNumber" items="${owner.phoneNumbers}">
					    	<c:if test="${phoneNumber.primaryNumber}">
					    		<c:out value="${phoneNumber.phoneNumber}" />
					    	</c:if>
					    </c:forEach>
				    </td>
				   	<td>				    
					    <c:forEach var="email" items="${owner.emailAddresses}">
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