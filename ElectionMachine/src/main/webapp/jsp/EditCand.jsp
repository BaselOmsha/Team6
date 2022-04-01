<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="app.model.Candidate" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action='./editcand' method='post'>
		id: <input type='text' name='id' value='${sessionScope.candidate.candidate_id }'readonly><br>
		FirstName: <input type='text' name='firstname' value='${sessionScope.candidate.fname }'><br>
		LasttName: <input type='text' name='lastname' value='${sessionScope.candidate.lname }'><br>	
		Ssn:<input type='text' name='ssn' value='${sessionScope.candidate.ssn }'><br>
		Party:<input type='text' name='party' value='${sessionScope.candidate.party }'><br>	
		Email:<input type='text' name='email' value='${sessionScope.candidate.email }'><br>	
		Username:<input type='text' name='uname' value='${sessionScope.candidate.uname }'><br>
		Age:<input type='number' name='age' value='${sessionScope.candidate.age }'><br>
		Why are you running in the election?:<input type='text' name='question' value='${sessionScope.candidate.Why_running }'><br>
		What problems do you want to debate?:<input type='text' name='question' value='${sessionScope.candidate.What_things_do_you_wnat_to_represent }'><br>
		Profession:<input type='text' name='profession' value='${sessionScope.candidate.profession }'><br>
		Password:<input type='text' name='paswd' value='${sessionScope.candidate.paswd }'><br>
				
		<input type='submit' name='ok' value='Edit'>
	</form>

</body>
</html>