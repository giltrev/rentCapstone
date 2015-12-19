<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Display Owners</title>
  	<meta name="robots" content="noindex,nofollow">
	<meta name="description" content="Class Assignemnt.">
	<meta name="keywords" content="homework, assignments">
    <link href="main.css" rel="stylesheet" type="text/css" media="screen">
</head>
<body>
<div class="header">
  
      <h1>Property management</h1>
  
  </div>
  
  <div class="nav"> 
      Home Screen | Owners | Properties | Units | Tennants | Service Calls | Vendors</a>
  </div>

  <div class="content">
<c:forEach var="item" items="${allPersons}">
  <c:out value="${item.personId}" />  <c:out value="${item.firstName}" /> <c:out value="${item.middleName}" /> <c:out value="${item.lastName}" /><br />
   <c:forEach var="email" items="${item.emailAddresses}">
  <c:out value="${email.emailAddressType}" /> <c:out value="${email.emailAddress}" /><br />
   </c:forEach>
</c:forEach>
  </div>


</body>
</html>