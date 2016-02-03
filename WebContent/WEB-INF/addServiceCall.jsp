<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<my:person>
	<jsp:attribute name="body">
		<div class="content">
		    
		    
		    Welcome <c:out value="${tenant.firstName}" /> <c:out value="${tenant.lastName}" /><br>
		    <c:out value="${tenant.unit.property.propAddress1}" /> # <c:out value="${tenant.unit.unitNumber}" /><br>
		    <c:out value="${tenant.unit.property.propCity}" /> <c:out value="${tenant.unit.property.propState}" /> <c:out value="${tenant.unit.property.propZip}" />
		     
		    
		    <form method="post" action="CreateServiceCall" enctype="multipart/form-data">
          
                Best time to reach you<br>
                <input type="radio" name="reachTime" value="ASAP" /> ASAP
                <input type="radio" name="reachTime" value="Morning" /> Morning
                <input type="radio" name="reachTime" value="Afternoon" /> Afternoon
                <input type="radio" name="reachTime" value="Night" /> Night<br>
                
                Services Needed / Comments <br>
                <textarea name='serviceCallDetail'  tabindex='12' rows='10' cols='100' ></textarea><br>
                    
                Portrait Photo: <br>
                    <input type="file" name="photo" size="50"/><br>
                    <input type="file" name="photo" size="50"/><br>
                    <input type="file" name="photo" size="50"/><br>
              

                
               
                        <input type="submit" value="Save">
		 
		    
		    </form>
		    
		    
		    
		    
		<!-- end .content --></div>
	
	</jsp:attribute>
</my:person>