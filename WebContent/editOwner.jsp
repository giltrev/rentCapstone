<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="main.css" rel="stylesheet" type="text/css" media="screen" />
    
<script language="javascript">
        function addRow(tableID) {
 
            var table = document.getElementById(tableID);
 
            var rowCount = table.rows.length;
            var row = table.insertRow(rowCount);
 
            var colCount = table.rows[0].cells.length;
 
            for(var i=0; i<colCount; i++) {
 
                var newcell = row.insertCell(i);
 
                newcell.innerHTML = table.rows[0].cells[i].innerHTML;
                //alert(newcell.childNodes);
                switch(newcell.childNodes[0].type) {
                    case "text":
                            newcell.childNodes[0].value = "";
                            break;
                    case "checkbox":
                            newcell.childNodes[0].checked = false;
                            break;
                    case "select-one":
                            newcell.childNodes[0].selectedIndex = 0;
                            break;
                }
            }
        }
 
        function deleteRow(tableID) {
            try {
            var table = document.getElementById(tableID);
            var rowCount = table.rows.length;
 
            for(var i=0; i<rowCount; i++) {
                var row = table.rows[i];
                var chkbox = row.cells[0].childNodes[0];
                if(null != chkbox && true == chkbox.checked) {
                    if(rowCount <= 1) {
                        alert("Cannot delete all the rows.");
                        break;
                    }
                    table.deleteRow(i);
                    rowCount--;
                    i--;
                }
 
 
            }
            }catch(e) {
                alert(e);
            }
        }
 
    </script>    
<title>Edit Owner</title>
</head>
<body>

<div class="header">
  
      <h1>Property management</h1>
  
  </div>
  
  <div class="nav"> 
      Home Screen | Owners | Properties | Units | Tenants | Service Calls | Vendors
  </div>

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




<h2>Email Addresses</h2>
<input type="button" value="Add Row" onclick="addRow('emailTable')" />
<input type="button" value="Delete Row" onclick="deleteRow('emailTable')" />

<table width="600" border="0" cellspacing="1" cellpadding="1">
  <tr>
    <th width="85" align="left" scope="col">Primary</th>
    <th width="120" align="left" scope="col">Email Type</th>
    <th width="385" align="left" scope="col">email Address</th>
  </tr>
</table>  
<table width="600" border="0" cellspacing="1" cellpadding="1">  
 <c:forEach var="email" varStatus="status" items="${owner.emailAddresses}">
 <input type="hidden" name ="emailAddressId"  value='<c:out value="${email.emailAddressId}"/>' />



	<tr>
  	    <td>
  	    <c:if test="${email.primaryEmail==true}"> Primary <br /></c:if>
  	    <input type="radio" name="primaryEmail"  value='<c:out value="${status.index}" />' <c:if test="${email.primaryEmail==true}"> checked</c:if> />
		
		</td>
	    <td>
		<select name="emailAddressType">
   			  <option value="Work" <c:if test="${email.emailAddressType=='Work' }"> selected</c:if>  >Work</option>
    		  <option value="Home" <c:if test="${email.emailAddressType=='Home' }"> selected</c:if>   >Home</option>
    		  <option value="Other" <c:if test="${email.emailAddressType=='Other' }"> selected</c:if>   >Other</option>
    	</select>
		
		</td>
		<td><input name="emailAddress" type="text" size="40" value='<c:out value="${email.emailAddress}" />' />
		</td>
   </tr>
  </c:forEach>
 
  </table>
    

<h2>Phone Numbers</h2>
<input type="button" value="Add Row" onclick="addRow('phoneTable')" />
<input type="button" value="Delete Row" onclick="deleteRow('phoneTable')" />

<table width="600" border="0" cellspacing="1" cellpadding="1">
  <tr>
    <th width="85" align="left" scope="col">Primary</th>
    <th width="123" align="left" scope="col">Phone Type</th>
    <th width="382" align="left" scope="col">Phone Number</th>
  </tr>
  </table>
<table id="phoneTable" width="600" border="0" cellspacing="1" cellpadding="1">
  <c:forEach var="phoneNumber" varStatus="status" items="${owner.phoneNumbers}">
  <input type="hidden" name ="phoneNumberId"  value='<c:out value="${phoneNumber.phoneNumberId}"/>' />
  <tr>
    <td>
    <c:if test="${phoneNumber.primaryNumber==true}"> primary<br /></c:if>
 	   <input type="radio" name="primaryPhone" value="<c:out value="${status.index}" />" <c:if test="${phoneNumber.primaryNumber==true}"> checked</c:if> />
    </td>
    <td>
		<select name="phoneType">
      			<option value="Work" <c:if test="${phoneNumber.phoneType=='Work' }"> selected</c:if>  >Work</option>
     	 		<option value="Home" <c:if test="${phoneNumber.phoneType=='Home' }"> selected</c:if>  >Home</option>
    		  	<option value="Other" <c:if test="${phoneNumber.phoneType=='Other' }"> selected</c:if>  >Other</option>
    	</select>
	</td>
    <td>
		<input name="phoneNumber" type="text" value='<c:out value="${phoneNumber.phoneNumber}" /> ' />
	</td>
  </tr>
</c:forEach>
    
</table>
<h2>Addresses</h2>
<input type="button" value="Add Row" onclick="addRow('addressTable')" />
<input type="button" value="Delete Row" onclick="deleteRow('addressTable')" />

<table width="696" border="0" cellspacing="10" cellpadding="4">
  <tr>
    <th width="69" align="left" scope="col">Primary</th>
    <th width="133" align="left" scope="col">Address Type</th>
    <th width="467" align="left" scope="col">Address</th>
  </tr>
  </table>
<table id="addressTable" width="696" border="0" cellspacing="10" cellpadding="4"> 
   <c:forEach var="address" varStatus="status" items="${owner.addresses}">
    <input type="hidden" name ="addressId"  value='<c:out value="${address.addressId}"/>' />
  <tr>
  
    <td align="center" valign="top">
    <c:if test="${address.primaryAddress==true}"> Primary<br /></c:if>
    <input type="radio" name="primaryAddress" value="<c:out value="${status.index}" />" <c:if test="${address.primaryAddress==true}"> checked</c:if> /></td>
   
   
  <td valign="top"><select name="addressType">
      <option value="Work" <c:if test="${address.addressType=='Work' }"> selected</c:if>>Work</option>
      <option value="Home" <c:if test="${address.addressType=='Home' }"> selected</c:if>>Home</option>
      <option value="Other" <c:if test="${address.addressType=='Other' }"> selected</c:if>>Other</option>
    </select></td> 
    <td valign="top">Address1 :
      <input type="text" name="address1" size="40" value='<c:out value="${address.address1}" />' />
      <br />
Address2 :
<input type="text" name="address2" size="40" value='<c:out value="${address.address2}" />' />
<br />
City:
<input type="text" name="city" size="40" value='<c:out value="${address.city}" />' />
<br />
State:
<input type="text" name="state" size="40" value='<c:out value="${address.state}" />' />
<br />
Zip:
<input type="text" name="zip" size="40" value='<c:out value="${address.zip}" />' /></td> 
  </tr>
  </c:forEach>
</table>





<p><input type="submit" value="submit" /></p>

</form>

  </div>
</body>
</html>