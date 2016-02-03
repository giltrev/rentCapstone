<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<my:layout>
	<jsp:attribute name="body">
		<div class="content">
			<p><a href='EditOwnerRedirect?personId=<c:out value="${owner.personId}" />'>editOwner</a>
			<h2><c:out value="${owner.firstName}" /> <c:out value="${owner.middleName}" /> <c:out value="${owner.lastName}" /></h2>
			
			<h3>Addresses</h3>  

			<c:forEach var="address" items="${owner.addresses}">
				<c:if test="${address.primaryAddress==true}">
					<p class = "primary">
					<c:out value="${address.addressType}" /> Address<br />
					<c:out value="${address.address1}" /> <br />
					<c:if test="${address.address2.length() != 0}">
						<c:out value="${address.address2}" /><br />
					</c:if>
					<c:out value="${address.city}" />, <c:out value="${address.state}" />  <c:out value="${address.zip}" />  </p>
				</c:if>
			</c:forEach>
						<c:forEach var="address" items="${owner.addresses}">
				<c:if test="${address.primaryAddress!=true}">
					<p>
					<c:out value="${address.addressType}" /> Address<br />
					<c:out value="${address.address1}" /> <br />
					<c:if test="${address.address2.length() != 0}">
						<c:out value="${address.address2}" /><br />
					</c:if>
					<c:out value="${address.city}" />, <c:out value="${address.state}" />  <c:out value="${address.zip}" />  </p>
				</c:if>
			</c:forEach>
			 
			<h3>Email Addresses</h3>
			<c:forEach var="email" items="${owner.emailAddresses}">
				<c:if test="${email.primaryEmail==true}">
				<p class = "primary" >
				<c:out value="${email.emailAddressType}" /> <c:out value="${email.emailAddress}" /></p>
				</c:if>
			</c:forEach>
				<c:forEach var="email" items="${owner.emailAddresses}">
				<c:if test="${email.primaryEmail!=true}">
				<p>
				<c:out value="${email.emailAddressType}" /> <c:out value="${email.emailAddress}" /></p>
				</c:if>
			</c:forEach>
			
			<h3>Phone Numbers</h3>
			<c:forEach var="pNumber" items="${owner.phoneNumbers}">
				<c:if test="${pNumber.primaryNumber==true}">
				<p class = "primary">
					<c:out value="${pNumber.phoneType}" /> <c:out value="${pNumber.phoneNumber}" /></p>
				</c:if>
			</c:forEach>
			<c:forEach var="pNumber" items="${owner.phoneNumbers}">
				<c:if test="${pNumber.primaryNumber!=true}">
				<p>
					<c:out value="${pNumber.phoneType}" /> <c:out value="${pNumber.phoneNumber}" /></p>
				</c:if>
			</c:forEach>
			
			 
			<h3>Properties</h3>
			<c:forEach var="property" items="${owner.properties}">
				<p><c:out value="${property.propertyType}" /> at <c:out value="${property.propAddress1}" /> </p>
			</c:forEach>

		<!-- end .content --></div>
	</jsp:attribute>
</my:layout>