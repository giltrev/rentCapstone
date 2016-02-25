<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<my:propManager>
	<jsp:attribute name="body">
		<div class="content">
		<h4>Logged in as <c:out value="${propManager.firstName}" /> <c:out value="${propManager.lastName}" /></h4>
		   
		    
		    
		   <c:if test="${not empty contacts}">  
		    <h3>Current Messages</h3>
		    
		    	<table class="table table-hover">
				  <tr>
				    <th>ID</th>
				    <th>Full Name</th> 
				    <th>Email</th>
				    <th>Phone</th>
				    <th>City</th>
				    <th>State</th>
				    <th>Message</th>
				  </tr>
				  <c:forEach var="contact" items="${contacts}">
				  <tr class='clickable-row' data-href='EditContact?contactId=<c:out value="${contact.contactId}" />'>
				    <td><c:out value="${contact.contactId}" /></td>
				    <td><c:out value="${contact.fullName}" /></td> 
				    <td><c:out value="${contact.email}" /></td>
				    <td><c:out value="${contact.phone}" /></td>
				    <td><c:out value="${contact.city}" /></td>
				    <td><c:out value="${contact.state}" /></td>
				    <td><c:out value="${contact.comments}" /></td>
				  </tr>
				</c:forEach>
				</table>

			</c:if>
		    
		<!-- end .content --></div>
	
	</jsp:attribute>
</my:propManager>