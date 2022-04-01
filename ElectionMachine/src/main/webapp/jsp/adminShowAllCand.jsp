<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="app.model.Candidate" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All datatable rows</title>
</head>
<body>

<table>
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Lastname</th>
    <th>Social security number</th>
    <th>Party</th>
    <th>Email</th>
    <th>Username</th>
    <th>Age</th>
    <th>Why running?</th>
    <th>What things do you want to represent</th>
    <th>Profession</th>
    
</tr>
<c:forEach var="candidate" items="${sessionScope.ReadAllCandidates }">
    <tr>
        <td>${candidate.candidate_id }</td>
        <td>${candidate.fname }</td>
        <td>${candidate.lname }</td>
        <td>${candidate.ssn }</td>
        <td>${candidate.party }</td>
        <td>${candidate.email }</td>
        <td>${candidate.uname }</td>
        <td>${candidate.age }</td>
        <td>${candidate.why_running }</td>
        <td>${candidate.what_things_do_you_want_to_represent }</td>
		<td>${candidate.profession }</td>
		<td>${candidate.paswd }</td>   
		
	 <td>
            <a href="/EditCand?candidate_id=${candidate.candidate_id }">Edit</a>
            <a href="#"> - </a>
            <a href="/deleteCand?candidate_id=${candidate.candidate_id }">Delete</a>
        </td>
    </tr>
</c:forEach>
</table>

</body>
</html>