<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<my:layout>
	<jsp:attribute name="body">
		<div class="content">
		    
		    
		    <div class="avalable">
		    <h2>Available Units</h2>
		   
		
		    <c:forEach var="property" items="${availableUnits}">
		 		<p>
		  		<strong>
		  			<c:out value="${property.propName}" /> 
	  			</strong>
	  			<br />
	  			<c:out value="${property.propAddress1}" /> 
		  		
		  		<br />
		  		<c:out value="${property.propCity}" />,  <c:out value="${property.propState}" />   
		  		<br />
		  		<c:out value="${property.description}" />
		    </p>
		    </c:forEach>
		    
		    </div>
		  
		    <h3>Logo Replacement</h3>
		    <p>An image placeholder was used in this layout in the .header where you'll likely want to place  a logo. It is recommended that you remove the placeholder and replace it with your own linked logo. </p>
		    <p> Be aware that if you use the Property inspector to navigate to your logo image using the SRC field (instead of removing and replacing the placeholder), you should remove the inline background and display properties. These inline styles are only used to make the logo placeholder show up in browsers for demonstration purposes. </p>
		    <p>To remove the inline styles, make sure your CSS Styles panel is set to Current. Select the image, and in the Properties pane of the CSS Styles panel, right click and delete the display and background properties. (Of course, you can always go directly into the code and delete the inline styles from the image or placeholder there.)</p>
		    <h4>Backgrounds</h4>
		    <p>By nature, the background color on any div will only show for the length of the content. This means if you're using a background color or border to create the look of a side column, it won't extend all the way to the footer but will stop when the content ends. If the .content div will always contain more content, you can place a border on the .content div to divide it from the column.</p>
		<!-- end .content --></div>
	
	</jsp:attribute>
</my:layout>
