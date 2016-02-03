<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="body" fragment="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="css/main.css" />
<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
<script type="text/javascript"src="js/functions.js"></script>

<title>Austin Property Management</title>
</head>
<body>
<div class="container">
	<jsp:include page="/WEB-INF/header.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/navbar.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/sidebarPropManager.jsp"></jsp:include>
    <jsp:invoke fragment="body"></jsp:invoke>

	<div class="footer">
		<footer>
			<p>
				Austin Property Management | 123 Main St., Austin Texas 78701 | 512.459.2222
			</p>
		</footer>
	<!-- end .footer --></div>


	<script src="/js/bootstrap.js"></script>
	<script src="/js/addrow.js"></script>
<!-- end .container --></div>
</body>
</html>



