<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.Candidate"%>
<%@ page import="model.Kysymykset"%>
<%@ page import="model.Vastaukset"%>
<%@ page import="model.VastauksetPK"%>


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
	content="Team 14 project work. The website contains basic web development guides utilizing HTML5, CSS, JavaScript and Bootstrap">
<title>Edit Answers</title>
<!--Link to bootstrap.-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/style.css">
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
	color: red;
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

#button1, #button2 {
	display: inline-block;
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
					<a class="navbar-brand" href="/index.html"
						style="color: #0000ff; font-family: 'Dosis', sans-serif; font-size: 35px;"><b
						Style="color: #0693e3;">Election</b> <b
						Style="color: rgb(207, 46, 46);">Machine</b> <b>2022</b></a>
					<div id="navbarNav">
						<ul class="navbar-nav">
							<!-- 	<li class="nav-item"><a class="nav-link active"
								aria-current="page" href="votRegForm.html" style=" font-size: 20px"><b>Voter Registration</b></a></li>
							<li class="nav-item"><a class="nav-link active" href="./staticRegForm/candRegForm.html" style=" font-size: 20px"><b>Candidate Registration</b></a>
							</li> -->
							<li class="nav-item"><a class="nav-link active"
								style="font-size: 20px"><b> <%
 session.getAttribute("LoggedUser");
 if (session.getAttribute("LoggedUser") != null) {
 	String uname = null;
 	String sessionID = null;
 	Cookie[] cookies = request.getCookies();
 	if (cookies != null) {
 		for (int i = 0; i < cookies.length; i++) {

 	if (cookies[i].getName().equals("LoggedUser"))
 		uname = cookies[i].getValue();
 	if (cookies[i].getName().equals("JSESSIONID"))
 		sessionID = cookies[i].getValue();
 		}
 		out.println("Welcome, " + uname);
 	} else {
 		sessionID = session.getId();
 	}
 } else if (session.getAttribute("LoggedUser") == null) {
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
			<!-- /#header -->
		</header>
		<main>

			<div class="box">
				<h1>Edit Questions Form</h1>
				<br>
				<form action='/rest/service/editAnswer' method='post'>
					<%-- <input type="text" name="candidate_id"
						value="${sessionScope.LoggedUser.candidate_id}"> --%>
					<table>
						<tr>
							<th>CandidateID</th>
							<th>QuestionsID</th>
							<th>Answers</th>
							<th></th>
							<th></th>
							<th>Explanation</th>
							<th></th>
							<th></th>
							<th>Edit</th>

						</tr>
						<c:forEach var="Vastaus" items="${requestScope.Vastauslista}">
							<tr>
								<td><input type="text" name="candidate_id"
									value="${sessionScope.LoggedUser.candidate_id}" hidden>${sessionScope.LoggedUser.candidate_id}</td>
								<td><input type="text" name="kysymys_ID${Vastaus.id.kysymys_ID}"
									value="${Vastaus.id.kysymys_ID}" hidden>${Vastaus.id.kysymys_ID}</td>
								<td></td>
								<td>${Vastaus.vastaus}</td>
								<td></td>
								<td></td>
							
								<td>${Vastaus.kommentti}</td>
								<td></td>
								<td><input type="radio" id="q1${Vastaus.id.kysymys_ID}"
									name="vastaus${Vastaus.id.kysymys_ID}" value="1"> <label
									for="q1${Vastaus.id.kysymys_ID}">1</label><br></td>

								<td><input type="radio" id="q2${Vastaus.id.kysymys_ID}"
									name="vastaus${Vastaus.id.kysymys_ID}" value="2"> <label
									for="q2${Vastaus.id.kysymys_ID}">2</label><br></td>

								<td><input type="radio" id="q3${Vastaus.id.kysymys_ID}"
									name="vastaus${Vastaus.id.kysymys_ID}" value="3"> <label
									for="q3${Vastaus.id.kysymys_ID}">3</label><br></td>

								<td><input type="radio" id="q4${Vastaus.id.kysymys_ID}"
									name="vastaus${Vastaus.id.kysymys_ID}" value="4"> <label
									for="q4${Vastaus.id.kysymys_ID}">4</label><br></td>

								<td><input type="radio" id="q5${Vastaus.id.kysymys_ID}"
									name="vastaus${Vastaus.id.kysymys_ID}" value="5"> <label
									for="q5${Vastaus.id.kysymys_ID}">5</label><br></td>

								<td><input type="text" id="kommentti${Vastaus.id.kysymys_ID}"
									name="kommentti${Vastaus.id.kysymys_ID}" placeholder="Add an Explanation">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</c:forEach>
					</table>

					<br> <br>
					<table>
						<tr>
							<td><input type='submit' name='ok' value='Update'
								style="font-size: 30px"></td>
							<td><input style="font-size: 30px;" type='reset'
								name='reset' value='Reset' id="button2"></td>
							<td><input style='font-size: 30px' type='button'
								name='cancel' value='Cancel' onclick='window.history.back()'></td>

						</tr>
					</table>
				</form>
			</div>
		</main>
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