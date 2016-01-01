<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="body" fragment="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/main.css" />
<title>Austin Property Management</title>
</head>
<body>
<div class="container">
	<jsp:include page="/WEB-INF/navbar.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/sidebar1.jsp"></jsp:include>
    <jsp:invoke fragment="body"></jsp:invoke>

	<div class="footer">
		<footer>
			<p>
				Footer
			</p>
		</footer>
	<!-- end .footer --></div>


	<script src="/js/bootstrap.js"></script>
	<script src="/js/addrow.js"></script>
<!-- end .container --></div>
</body>
</html>



