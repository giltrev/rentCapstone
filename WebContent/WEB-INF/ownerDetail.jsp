<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<my:layout>
	<jsp:attribute name="body">
		<div class="content">
			<p><a href='EditOwnerRedirect?personId=<c:out value="${owner.personId}" />'>editOwner</a>
			<h2><c:out value="${owner.firstName}" /> <c:out value="${owner.middleName}" /> <c:out value="${owner.lastName}" /></h2>
			
			<h2>Addresses</h2>  
			<c:forEach var="address" items="${owner.addresses}">
				<p><c:if test="${address.primaryAddress==true}">
					Primary Address<br />
				</c:if>
				<c:out value="${address.addressType}" /> Address<br />
				<c:out value="${address.address1}" /> <br />
				<c:if test="${address.address2.length() != 0}">
					<c:out value="${address.address2}" /><br />
				</c:if>
				<c:out value="${address.city}" />, <c:out value="${address.state}" />  <c:out value="${address.zip}" />  </p>
			</c:forEach>
			 
			<h2>Email Addresses</h2>
			<c:forEach var="email" items="${owner.emailAddresses}">
				<c:out value="${email.emailAddressType}" /> <c:out value="${email.emailAddress}" /><br />
			</c:forEach>
			
			<h2>Phone Numbers</h2>
			<c:forEach var="pNumber" items="${owner.phoneNumbers}">
				<c:out value="${pNumber.phoneType}" /> <c:out value="${pNumber.phoneNumber}" /><br />
			</c:forEach>
			 
			<h2>Properties</h2>
			<c:forEach var="property" items="${owner.properties}">
				<c:out value="${property.propertyType}" /> at <c:out value="${property.propAddress1}" /> <br />
			</c:forEach>

		<!-- end .content --></div>
	</jsp:attribute>
</my:layout>