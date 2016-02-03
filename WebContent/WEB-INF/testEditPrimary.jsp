<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<my:layout>
	<jsp:attribute name="body">
		<div class="content">
			<h2>Edit Owner</h2>
			<form action="EditOwner" method="post">
				<p>First Name:<br /><input name="firstName" type="text" value="<c:out value="${owner.firstName}" />" size="40" /><br />
				Middle Name:<br /><input name="middleName" type="text" value="<c:out value="${owner.middleName}" />" size="40" /><br />
				Last name:<br /><input name="lastName" type="text" value="<c:out value="${owner.lastName}" />" size="40" /><br />
				Payment Method: <br /><input name="paymentMethod" type="text" value="<c:out value="${owner.paymentMethod}" />" size="40" /><br />
				
				<input type="hidden" name="personId" value="<c:out value="${owner.personId}"/>" />
				
				Active<input type="radio" name="activePerson" value="true" <c:if test="${owner.activePerson==true}"> checked</c:if> />
				Inactive<input type="radio" name="activePerson" value="false" <c:if test="${owner.activePerson==false}"> checked </c:if> />  
				
				
				</p>
				<p><input type="submit" value="submit" /></p>
			
			</form>

		<!-- end .content --></div>
	</jsp:attribute>
</my:layout>