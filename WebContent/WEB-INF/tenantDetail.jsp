<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<my:propManager>
	<jsp:attribute name="body">
		<div class="content">

			<p>
				<a href='EditTenant?personId=<c:out value="${tenant.personId}" />'>Edit tenant</a>
			</p>
			
			<h4><c:out value="${tenant.firstName}" /> <c:out value="${tenant.middleName}" /> <c:out value="${tenant.lastName}" /></h4>
			 
			<p>
				<c:out value="${tenant.unit.property.propAddress1}" />, # <c:out value="${tenant.unit.unitNumber}" /><br />
				<c:out value="${tenant.unit.property.propCity}" />, <c:out value="${tenant.unit.property.propState}" />  <c:out value="${tenant.unit.property.propZip}" />
			</p>
			 
			<h4>Email Addresses</h4>
			<c:forEach items="${tenant.emailAddresses}" var="email1"  varStatus="theCount">
				<c:out value="${theCount.count}" /> <c:out value="${email1.emailAddressType}" /> <c:out value="${email1.emailAddress}" /><br />
			</c:forEach>
			
			<h4>Phone Numbers</h4>
			 <c:forEach var="pNumber1" items="${tenant.phoneNumbers}">
				<c:out value="${pNumber1.phoneType}" /> <c:out value="${pNumber1.phoneNumber}" /><br />
			</c:forEach>

		<!-- end .content --></div>
	</jsp:attribute>
</my:propManager>