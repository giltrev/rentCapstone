<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<my:propManager>
	<jsp:attribute name="body">
		<div class="content">
			<p><a href='EditOwnerRedirect?personId=<c:out value="${propManager.personId}" />'>edit Property Manger</a>
			<h2><c:out value="${propManager.firstName}" /> <c:out value="${propManager.middleName}" /> <c:out value="${propManager.lastName}" /></h2>
			<p>Company Name: <c:out value="${propManager.companyname}" /> <br />
			<p>Property Manger Type: <c:out value="${propManager.pmType}" /> </p>
			<h3>Addresses</h3>  

			<c:forEach var="address" items="${propManager.addresses}">
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
			<c:forEach var="address" items="${propManager.addresses}">
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
			<c:forEach var="email" items="${propManager.emailAddresses}">
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
			<c:forEach var="pNumber" items="${propManager.phoneNumbers}">
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
			
			 


		<!-- end .content --></div>
	</jsp:attribute>
</my:propManager>