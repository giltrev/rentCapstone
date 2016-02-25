<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<my:layout>
	<jsp:attribute name="body">

		<div class="content">
		<h2>Welcome</h2>
			<p class="lead.less">Austin Property Management is a full service real estate office providing services throughout the Austin vicinity. 
			We assist Real Estate investors with management and sales of rental homes and Prospective 
			Tenants/ Renters with placement into a home or assisting them in buying a home! 
			Whatever the Real Estate need, Austin Property Management wishes to help. 
			We are an Austin Based Family owned Small business.</p>
			<p class="lead.less">We create an online portal for our Property investors along with our Residents.</p>
			<p class="lead.less">This allows for faster processing time and an ease to paying rent and more. </p>
			<p class="lead.less">Want our help? Call us today!</p>
		</div>
			
		
		
		    <h3 class="bottomBorder">Available Units</h3>
		    <div class="row">
				    <c:forEach var="property" items="${availableUnits}">
				    <div class="col-xs-6 col-md-6">
				    
				 		
					  		<strong>
					  			<c:out value="${property.propName}" /> 
				  			</strong>
				  			<br />
				  			<c:out value="${property.propAddress1}" /> 
					  		
					  		<br />
					  		<c:out value="${property.propCity}" />,  <c:out value="${property.propState}" />   
					  		<br />
					  		<small><c:out value="${property.description}" /></small>
				      </div>
				    </c:forEach>
		    </div>
		

	
	
	</jsp:attribute>
</my:layout>
