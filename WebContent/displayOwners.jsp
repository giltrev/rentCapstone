<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>--All Persons--</p>



<c:forEach var="item" items="${allPersons}">
  <c:out value="${item.personId}" />  <c:out value="${item.firstName}" /> <c:out value="${item.middleName}" /> <c:out value="${item.lastName}" /><br />
   <c:forEach var="email" items="${item.emailAddresses}">
  <c:out value="${email.emailAddressType}" /> <c:out value="${email.emailAddress}" /><br />
   </c:forEach>
</c:forEach>
</body>
</html>