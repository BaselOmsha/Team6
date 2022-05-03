<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="app.model.Candidate"%>
<%
//requires revalidation after logging out
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
response.setHeader("Expires", "0"); // Proxies
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<meta charset="UTF-8">
<meta http-equiv="content-type"
	content="application/xhtml+xml; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="">
<meta name="description"
	content="Team 6 project work. The website contains basic web development guides utilizing HTML5, CSS, JavaScript and Bootstrap">
<title>Candidate page</title>
<!--Link to bootstrap.-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<!--Link to local css file.-->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Dosis&display=swap"
	rel="stylesheet">
<style>
.div1 {
	color: rgb(207, 46, 46);
}

.div2 {
	color: #0693e3;
}

.div3 {
	color: #ffe02f;
}

a {
color:red;

}
/* mouse over link */
a:hover {
	color: #000000;
	
}

/* selected link */
a:active {
	color: blue;
}

.box {
	background-color: #ffffffea;
	width: auto;
	height: auto;
	position: relative;
	flex-direction: column;
	display: flex;
	flex-wrap: wrap;
	justify-content: center;
	align-items: center;
	background-repeat: no-repeat;
	background-size: cover;
	background-attachment: fixed;
	overflow: scroll;
}

table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: auto;
	flex-direction: column;
	display: flex;
	flex-wrap: wrap;
	justify-content: center;
	align-items: center;
}

td, th {
	border: 1px solid;
	text-align: left;
	padding: 8px;
	color: #000000;
	background-color: #eeeeef;
	border: none;
	font-size: 20px;
}

tr:nth-child(even) {
	background-color: rgb(0, 0, 255);
}

#button1 , #button2 {
display:inline-block;
/* additional code */
}

</style>

</head>
<body>
	<div id="wrapper">
		<header>
			<!--navigation bar starts here.-->
			<nav class="navbar navbar-expand-lg navbar-light">
				<div class="container-fluid">
					<a class="navbar-brand" href="index.html"
						style="color: #0000ff; font-family: 'Dosis', sans-serif; font-size: 35px;"><b
						Style="color: #0693e3;">Election</b> <b
						Style="color: rgb(207, 46, 46);">Machine</b> <b>2022</b></a>
					<div id="navbarNav">
						<ul class="navbar-nav">
							<li class="nav-item"><a class="nav-link active"
								aria-current="page" href="rest/service/readAllAnswers" style=" font-size: 20px"><b>Your Answers</b></a></li>
							<li class="nav-item"><a class="nav-link active" href="rest/service/readAllQuestions" style=" font-size: 20px"><b>Answer Survey</b></a>
							</li> 
							<li class="nav-item"><a class="nav-link active" 
								style="font-size: 20px"><b> 
								<%
								session.getAttribute("LoggedUser");
								if(session.getAttribute("LoggedUser") != null){
								String uname = null;
								String sessionID = null;
								 Cookie[] cookies = request.getCookies();
								 if (cookies != null) {
								 	for (int i = 0; i < cookies.length; i++) {
								
								 		if (cookies[i].getName().equals("LoggedUser")) uname = cookies[i].getValue();
								 		if(cookies[i].getName().equals("JSESSIONID")) sessionID = cookies[i].getValue();
								 	}
								 	out.println("Welcome, " + uname);
								 }else{
										sessionID = session.getId();
									}
								} else if (session.getAttribute("LoggedUser") == null){
								 	response.sendRedirect("/CandLogIn.html");
								}
								 %>
								</b></a></li>
							<li class="nav-item"><a class="nav-link active"
								href="/candlogout" style="font-size: 20px"><b>Log out</b></a></li>
						</ul>
					</div>
				</div>
			</nav>
			</nav>
			<!-- /#header -->
		</header>
		<main>

			<div class="box">
			<br><br>
			<h1>Candidate info</h1><br>
				
					<table>
						
						<tr>
							<td>ID</td>
							<td>${sessionScope.readCandidatesInfo.candidate_id }<br></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>First name</td>
							<td>${sessionScope.readCandidatesInfo.fname }</td>
							<br>
						</tr>
						<tr>
							<td></td>
							<td><br></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></input></td>
							<br>
						</tr>
						<tr>
							<td>Last name</td>
							<td>${sessionScope.readCandidatesInfo.lname }<br></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>Social security number</td>
							<td>${sessionScope.readCandidatesInfo.ssn }</td>
						</tr>
						<tr>
							<td></td>
							<td><br></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></input></td>
							<br>
						</tr>
						<tr>
							<td>Party</td>
							<td>${sessionScope.readCandidatesInfo.party }<br></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>Email:</td>
							<td>${sessionScope.readCandidatesInfo.email }</td>
						</tr>
						<tr>
							<td></td>
							<td><br></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<br>
						</tr>
						<tr>
							<td>Username</td>
							<td>${sessionScope.readCandidatesInfo.uname }<br></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>Age</td>
							<td>${sessionScope.readCandidatesInfo.age }</td>
							</td>
						</tr>
						<td>
						<td><br></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<br>
						</tr>
						<tr>
							<td>Why are you running?</td>
							<td>${sessionScope.readCandidatesInfo.why_running }<br></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>What things do you want to represent?</td>
							<td>${sessionScope.readCandidatesInfo.what_things_do_you_want_to_represent }</td>
							</td>
						</tr>
						<tr>
							<td></td>
							<td><br></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<br>
						</tr>
						<tr>
							<td>Profession</td>
							<td>${sessionScope.readCandidatesInfo.profession }<br></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							</td>
						</tr>
					</table>
					<br>
					<table>
					<tr>
					<td><a style=" font-size: 30px; border: solid black;" href="/EditCandApp?candidate_id=${sessionScope.readCandidatesInfo.candidate_id }">Edit</a></td>
					</tr>
					
					</table>
				

			</div>
			<div class="stripe"></div>
			<footer>
				<div class="container">
					<div class="py-3 my-4">
						<ul class="nav justify-content-center border-bottom pb-3 mb-3">
							<li class="nav-item"><a class="nav-link px-2 text-muted">Facebook</a></li>
							<li class="nav-item"><a class="nav-link px-2 text-muted">Instagram</a></li>
							<li class="nav-item"><a class="nav-link px-2 text-muted">LinkedIn</a></li>
							<li class="nav-item"><a class="nav-link px-2 text-muted">Discord</a></li>
						</ul>
						<p class="text-center text-muted">&copy; 2022 HAMK, Team2</p>
					</div>
				</div>
			</footer>
</body>
</html>