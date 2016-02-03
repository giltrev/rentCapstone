<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<my:propManager>
	<jsp:attribute name="body">
		<div class="content">
		<h3><c:out value="${propManager.firstName}" /></h3>
		    <h1>Property Manager View</h1>
		    <c:out value="${propManagerMessage}"></c:out>
		    
		<!-- end .content --></div>
	
	</jsp:attribute>
</my:propManager>