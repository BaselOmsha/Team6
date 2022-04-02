<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="app.model.Candidate" %> 
    
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<meta charset="UTF-8">
<meta http-equiv="content-type"
	content="application/xhtml+xml; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="">
<meta name="description"
	content="Team 14 project work. The website contains basic web development guides utilizing HTML5, CSS, JavaScript and Bootstrap">
<title>Admin Page</title>
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
    padding-top: 40px;
    padding-bottom: 40px;
    width: auto;
    height: auto;
    position: relative;
    flex-direction: raw;
    display: flex;
    flex-wrap: wrap; 
    justify-content: center; 
    align-items: center;
    overflow: hidden;
    
    background-repeat: no-repeat;
    background-size: cover;
    background-attachment: fixed;
		
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
						style="color: #0000ff; font-family: 'Dosis', sans-serif; font-size: 35px;"><b Style="color: #0693e3;">Election</b> <b Style="color: rgb(207, 46, 46);">Machine</b> <b>2022</b></a>
					<div id="navbarNav">
						<ul class="navbar-nav">
						<!-- 	<li class="nav-item"><a class="nav-link active"
								aria-current="page" href="votRegForm.html" style=" font-size: 20px"><b>Voter Registration</b></a></li>
							<li class="nav-item"><a class="nav-link active" href="./staticRegForm/candRegForm.html" style=" font-size: 20px"><b>Candidate Registration</b></a>
							</li> -->
							<li class="nav-item"><a class="nav-link active" href="#" style=" font-size: 20px"><b><%
//get the cockies
Cookie[] cookies = request.getCookies();
String uname = null;
if(cookies !=null){
	for (int i = 0; i < cookies.length; i++) {
		
	if(cookies[i].getName().equals("Welcome")) uname = cookies[i].getValue();
	out.println("Welcome " + uname);
}
}
if(uname == null) response.sendRedirect("/AdminLogIn.html");
%></b></a>
							</li>
							<li class="nav-item"><a class="nav-link active" href="/adminlogout" style=" font-size: 20px"><b>Log out</b></a>
							</li>
						</ul>
					</div>
				</div>
			</nav>
			</nav>
			<!-- /#header -->
		</header>
		<main>

<div class="box">

	<form action='./deleteCand' method='post'>
		id: <input type='text' name='candidate_id' value='${sessionScope.candidate.candidate_id }'readonly><br>
        FirstName: <input type='text' name='firstname' value='${sessionScope.candidate.fname }'><br>
        LasttName: <input type='text' name='lastname' value='${sessionScope.candidate.lname }'><br>
        Ssn:<input type='text' name='ssn' value='${sessionScope.candidate.ssn }'><br>
        Party:<input type='text' name='party' value='${sessionScope.candidate.party }'><br>
        Email:<input type='text' name='email' value='${sessionScope.candidate.email }'><br>
        Username:<input type='text' name='uname' value='${sessionScope.candidate.uname }'><br>
        Age:<input type='number' name='age' value='${sessionScope.candidate.age }'><br>
        Why are you running in the election?:<input type='text' name='question1' value='${sessionScope.candidate.why_running }'><br>
        What problems do you want to debate?:<input type='text' name='question2' value='${sessionScope.candidate.what_things_do_you_want_to_represent }'><br>
        Profession:<input type='text' name='profession' value='${sessionScope.candidate.profession }'><br>
        Password:<input type='text' name='paswd' value='${sessionScope.candidate.paswd }'><br>
		<input type='submit' name='ok' value='Delete'><br>
		<a href="/EditCand?candidate_id=${candidate.candidate_id }">Go back</a><br>
		<a href="/showAll">Cancel</a><br>
	</form>
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