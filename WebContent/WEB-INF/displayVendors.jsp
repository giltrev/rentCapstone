<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<my:layout>
	<jsp:attribute name="body">
		<div class="content">
			<h2>Vendors</h2>
			<ul>
				<c:forEach var="vendor" items="${allVendors}">
					<li><a href="VendorDetail?personId=<c:out value="${vendor.personId}" />">  <c:out value="${vendor.firstName}" /> <c:out value="${vendor.middleName}" /> <c:out value="${vendor.lastName}" /></a></li>
				</c:forEach>
			</ul>
		<!-- end .content --></div>
	</jsp:attribute>
</my:layout>