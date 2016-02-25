<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<my:layout>
	<jsp:attribute name="body">
		<div class="content">
				<c:out value="${loginMessage}"></c:out>
				<form action="doLogin" method="post">
					Enter User Name <br />
					<input type="text" name="userId" value="<c:out value="${userId}"></c:out>"><br />
					Enter Password <br />
					<input type="password" name="password" maxlength="15"><br />
					<input type="submit" value="Submit">
				</form>
				
		<!-- end .content --></div>
	</jsp:attribute>
</my:layout>

