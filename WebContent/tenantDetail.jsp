<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title><c:out value="${tenant.firstName}" /> <c:out value="${tenant.lastName}" /></title>

    <link href="main.css" rel="stylesheet" type="text/css" media="screen">
</head>
<body>
<div class="container">

<jsp:include page="maininsert.jsp" />



  <div class="content">
<p><a href='EditTenant?personId=<c:out value="${tenant.personId}" />'>Edit tenant</a>


  <h2><c:out value="${tenant.firstName}" /> <c:out value="${tenant.middleName}" /> <c:out value="${tenant.lastName}" /></h2>
 
 <p><c:out value="${tenant.unit.property.propAddress1}" />, # <c:out value="${tenant.unit.unitNumber}" /><br />
 <c:out value="${tenant.unit.property.propCity}" />, <c:out value="${tenant.unit.property.propState}" />  <c:out value="${tenant.unit.property.propZip}" /></p>

 
<h2>Email Addresses</h2>

 <c:forEach items="${tenant.emailAddresses}" var="email1"  varStatus="theCount">
<c:out value="${theCount.count}" /> <c:out value="${email1.emailAddressType}" /> <c:out value="${email1.emailAddress}" /><br />
</c:forEach>
 


<h2>Phone Numbers</h2>
     
 <c:forEach var="pNumber1" items="${tenant.phoneNumbers}">
<c:out value="${pNumber1.phoneType}" /> <c:out value="${pNumber1.phoneNumber}" /><br />
   </c:forEach>

   


    <!-- end .content --></div>
  <div class="footer">
    <p>This .footer contains the declaration position:relative; to give Internet Explorer 6 hasLayout for the .footer and cause it to clear correctly. If you're not required to support IE6, you may remove it.</p>
    <!-- end .footer --></div>
<!-- end .container --></div>


</body>
</html>