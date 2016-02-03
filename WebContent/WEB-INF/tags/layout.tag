<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="body" fragment="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
  	<meta charset="UTF-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/main.css" />
	<title>Austin Property Management</title>
</head>
<body>
<div class="container">
	<jsp:include page="/WEB-INF/header.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/sidebar1.jsp"></jsp:include>
    <jsp:invoke fragment="body"></jsp:invoke>

	<div class="footer">
		<footer>
			<p>
				Austin Property Management | 123 Main St., Austin Texas 78701 | 512.459.2222
			</p>
		</footer>
	<!-- end .footer --></div>

	<script src="/js/functions.js"></script>
	<script src="/js/bootstrap.min.js"></script>
	<script src="/js/addrow.js"></script>
	<script src="/js/jquery-2.2.0.min.js"></script>
<!-- end .container --></div>
</body>
</html>



