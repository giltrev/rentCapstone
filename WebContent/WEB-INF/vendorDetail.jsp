<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<my:propManager>
	<jsp:attribute name="body">
		<div class="content">
			<p>
				<a href='EditVendor?personId=<c:out value="${vendor.personId}" />'>Edit Vendor</a>
			</p>
			<h2><c:out value="${vendor.firstName}" /> <c:out value="${vendor.middleName}" /> <c:out value="${vendor.lastName}" /></h2>
			<c:out value="${vendor.companyName}" /> <br />
			<c:out value="${vendor.vendorType}" /> 
			 
			<h2>Addresses</h2>  
			<c:forEach var="address" items="${vendor.addresses}">
				<p>
					<c:if test="${address.primaryAddress==true}">
						Primary Address<br />
					</c:if>
					<c:out value="${address.addressType}" /> Address<br />
					<c:out value="${address.address1}" /> <br />
					<c:if test="${address.address2.length() != 0}">
						<c:out value="${address.address2}" /><br />
					</c:if>
					<c:out value="${address.city}" />, <c:out value="${address.state}" />  <c:out value="${address.zip}" />  
				</p>
			</c:forEach>
			 
			<h2>Email Addresses</h2>
			<c:forEach var="email" items="${vendor.emailAddresses}">
				<c:out value="${email.emailAddressType}" /> <c:out value="${email.emailAddress}" /><br />
			</c:forEach>
			
			<h2>Phone Numbers</h2>
			<c:forEach var="pNumber" items="${vendor.phoneNumbers}">
				<c:out value="${pNumber.phoneType}" /> <c:out value="${pNumber.phoneNumber}" /><br />
			</c:forEach>
   
		<!-- end .content --></div>
	</jsp:attribute>
</my:propManager>