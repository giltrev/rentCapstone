<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="body" fragment="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
  	<meta charset="UTF-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="css/bootstrap.min.css">
  	<link rel="stylesheet" href="css/styles.css">
	<title>Trevino Property Management</title>
</head>
<body>
<jsp:include page="/WEB-INF/header.jsp"></jsp:include>
<div class="main container">
			<div class="row">
							<jsp:include page="/WEB-INF/sidebar1.jsp"></jsp:include>
						<section class="col-md-8">
							<jsp:invoke fragment="body"></jsp:invoke>
						</section>
			</div>
</div>	


    <footer class="footer">
      <div class="container">
        <p class="text-muted">Trevino Property Management | 123 Main St., Austin Texas 78701 | 512.459.2222 | <a href="Mailto:#">info@TrevinoProperties.com</a></p>
      </div>
    </footer>
			
		
	<script src="js/functions.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/addrow.js"></script>
	<script src="js/jquery-2.2.0.min.js"></script>


</body>
</html>



