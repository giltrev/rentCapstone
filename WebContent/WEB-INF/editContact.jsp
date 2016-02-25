<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<my:propManager>
	<jsp:attribute name="body">
		<div class="content">
		<h4>Logged in as <c:out value="${propManager.firstName}" /> <c:out value="${propManager.lastName}" /></h4>
		    
		 <h4>Contact <c:out value="${contact.contactId}" /></h4>
			<blockquote>
			<strong><c:out value="${contact.fullName}" /> </strong> <br>
		    <c:out value="${contact.email}" /> <br>
		    <c:out value="${contact.phone}" /> <br>
		    <c:out value="${contact.city}" />  <c:out value="${contact.state}" /> <br>
		    <label  for="servicesComments">Comments</label>
		    <c:out value="${contact.comments}" /> <br>
		     </blockquote>
		 
			<div class="row-fluid">
			<form method="post" action="EditContactDo"> 
			<input type="hidden" name="contactId" value="<c:out value="${contact.contactId}" />"> 
			
			

				
				<div class="form-group">
					<button type="submit" class="btn btn-primary">Close Contact</button>
				</div>
				
			</form>
		    </div>
		<!-- end .content -->
		</div>
	
	</jsp:attribute>
</my:propManager>