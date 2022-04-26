<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	content="Team 14 project work. The website contains basic web development guides utilizing HTML5, CSS, JavaScript and Bootstrap">
<title>Question Page</title>
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
							<!-- 	<li class="nav-item"><a class="nav-link active"
								aria-current="page" href="votRegForm.html" style=" font-size: 20px"><b>Voter Registration</b></a></li>
							<li class="nav-item"><a class="nav-link active" href="./staticRegForm/candRegForm.html" style=" font-size: 20px"><b>Candidate Registration</b></a>
							</li> -->
							<%-- <li class="nav-item"><a class="nav-link active" 
								style="font-size: 20px"><b> 										<%
										//allow access only if session exists
											//allow access only if session exists
										String uname = null;
										uname =(String) session.getAttribute("uname");
										if (uname!=null){
											String data = null;
											String sessionID = null;
											Cookie[] cookies = request.getCookies();
											if(cookies !=null){
												for (int i = 0; i < cookies.length; i++) {
												if(cookies[i].getName().equals("uname")) data = cookies[i].getValue();
												
												if(cookies[i].getName().equals("JSESSIONID")) sessionID = cookies[i].getValue();
											}
											out.println("Welcome, " + data);
											}else{
												sessionID = session.getId();
											}
											
										}else if(session.getAttribute("uname") == null){
											response.sendRedirect("/AdminLogIn.html");
										}
										%>
								</b></a></li> --%>
							<li class="nav-item"><a class="nav-link active"
								href="/adminlogout" style="font-size: 20px"><b>Log out</b></a></li>
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
			<h1>Candidate Edit Form</h1><br>
				<form action='./EditCand' method='post'>
					<table>
						<tr>
							<td>Suomessa on liian helppo el‰‰ sosiaaliturvan varassa</td>
							<td><input type="radio" id="q1" name="kysymys" value="1">
  							<label for="question1">1</label><br></td>
  							<td><input type="radio" id="q1" name="kysymys" value="2">
  							<label for="question1">2</label><br></td>
  							<td><input type="radio" id="q1" name="kysymys" value="3">
  							<label for="question1">3</label><br></td>
  							<td><input type="radio" id="q1" name="kysymys" value="4">
  							<label for="question1">4</label><br></td>
  							<td><input type="radio" id="q1" name="kysymys" value="5">
  							<label for="question1">5</label><br></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>Kaupan ja muiden liikkeiden aukioloajat on vapautettava</td>
							<td><input type="radio" id="q2" name="kysymys" value="1">
  							<label for="question2">1</label><br></td>
  							<td><input type="radio" id="q2" name="kysymys" value="2">
  							<label for="question2">2</label><br></td>
  							<td><input type="radio" id="q2" name="kysymys" value="3">
  							<label for="question2">3</label><br></td>
  							<td><input type="radio" id="q2" name="kysymys" value="4">
  							<label for="question2">4</label><br></td>
  							<td><input type="radio" id="q2" name="kysymys" value="5">
  							<label for="question2">5</label><br></td>
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
							<td>Suomessa on siirrytt‰v‰ perustuloon joka korvaisi nykyisen sosiaaliturvan v‰himm‰istason.</td>
							<td><input type="radio" id="q3" name="kysymys" value="1">
  							<label for="question3">1</label><br></td>
  							<td><input type="radio" id="q3" name="kysymys" value="2">
  							<label for="question3">2</label><br></td>
  							<td><input type="radio" id="q3" name="kysymys" value="3">
  							<label for="question3">3</label><br></td>
  							<td><input type="radio" id="q3" name="kysymys" value="4">
  							<label for="question3">4</label><br></td>
  							<td><input type="radio" id="q3" name="kysymys" value="5">
  							<label for="question3">5</label><br></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>Tyˆntekij‰lle on turvattava lailla minimity‰aika.</td>
							<td><input type="radio" id="q4" name="kysymys" value="1">
  							<label for="question4">1</label><br></td>
  							<td><input type="radio" id="q4" name="kysymys" value="2">
  							<label for="question4">2</label><br></td>
  							<td><input type="radio" id="q4" name="kysymys" value="3">
  							<label for="question4">3</label><br></td>
  							<td><input type="radio" id="q4" name="kysymys" value="4">
  							<label for="question4">4</label><br></td>
  							<td><input type="radio" id="q4" name="kysymys" value="5">
  							<label for="question4">5</label><br></td>
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
							<td>Ansiosidonnaisen ty‰tt‰myysturvan kestoa pit‰‰ lyhent‰‰.</td>
							<td><input type="radio" id="q5" name="kysymys" value="1">
  							<label for="question5">1</label><br></td>
  							<td><input type="radio" id="q5" name="kysymys" value="2">
  							<label for="question5">2</label><br></td>
  							<td><input type="radio" id="q5" name="kysymys" value="3">
  							<label for="question5">3</label><br></td>
  							<td><input type="radio" id="q5" name="kysymys" value="4">
  							<label for="question5">4</label><br></td>
  							<td><input type="radio" id="q5" name="kysymys" value="5">
  							<label for="question5">5</label><br></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>Euron ulkopuolella Suomi p‰rj‰isi paremmin.</td>
							<td><input type="radio" id="q6" name="kysymys" value="1">
  							<label for="question6">1</label><br></td>
  							<td><input type="radio" id="q6" name="kysymys" value="2">
  							<label for="question6">2</label><br></td>
  							<td><input type="radio" id="q6" name="kysymys" value="3">
  							<label for="question6">3</label><br></td>
  							<td><input type="radio" id="q6" name="kysymys" value="4">
  							<label for="question6">4</label><br></td>
  							<td><input type="radio" id="q6" name="kysymys" value="5">
  							<label for="question6">5</label><br></td>
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
							<td>Ruoan verotusta on varaa kirist‰‰.</td>
							<td><input type="radio" id="q7" name="kysymys" value="1">
  							<label for="question7">1</label><br></td>
  							<td><input type="radio" id="q7" name="kysymys" value="2">
  							<label for="question7">2</label><br></td>
  							<td><input type="radio" id="q7" name="kysymys" value="3">
  							<label for="question7">3</label><br></td>
  							<td><input type="radio" id="q7" name="kysymys" value="4">
  							<label for="question7">4</label><br></td>
  							<td><input type="radio" id="q7" name="kysymys" value="5">
  							<label for="question7">5</label><br></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>Valtion ja kuntien taloutta on tasapainotettava ensisijaisesti leikkaamalla menoja.</td>
							<td><input type="radio" id="q8" name="kysymys" value="1">
  							<label for="question8">1</label><br></td>
  							<td><input type="radio" id="q8" name="kysymys" value="2">
  							<label for="question8">2</label><br></td>
  							<td><input type="radio" id="q8" name="kysymys" value="3">
  							<label for="question8">3</label><br></td>
  							<td><input type="radio" id="q8" name="kysymys" value="4">
  							<label for="question8">4</label><br></td>
  							<td><input type="radio" id="q8" name="kysymys" value="5">
  							<label for="question8">5</label><br></td>
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
							<td>Lapsilisi‰ on korotettava ja laitettava verolle.</td>
							<td><input type="radio" id="q9" name="kysymys" value="1">
  							<label for="question9">1</label><br></td>
  							<td><input type="radio" id="q9" name="kysymys" value="2">
  							<label for="question9">2</label><br></td>
  							<td><input type="radio" id="q9" name="kysymys" value="3">
  							<label for="question9">3</label><br></td>
  							<td><input type="radio" id="q9" name="kysymys" value="4">
  							<label for="question9">4</label><br></td>
  							<td><input type="radio" id="q9" name="kysymys" value="5">
  							<label for="question9">5</label><br></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>Suomella ei ole varaa nykyisen laajuisiin sosiaali- ja terveyspalveluihin.</td>
							<td><input type="radio" id="q10" name="kysymys" value="1">
  							<label for="question10">1</label><br></td>
  							<td><input type="radio" id="q10" name="kysymys" value="2">
  							<label for="question10">2</label><br></td>
  							<td><input type="radio" id="q10" name="kysymys" value="3">
  							<label for="question10">3</label><br></td>
  							<td><input type="radio" id="q10" name="kysymys" value="4">
  							<label for="question10">4</label><br></td>
  							<td><input type="radio" id="q10" name="kysymys" value="5">
  							<label for="question10">5</label><br></td>
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
							<td>Nato-j‰senyys vahvistaisi Suomen turvallisuuspoliittista asemaa</td>
							<td><input type="radio" id="q11" name="kysymys" value="1">
  							<label for="question11">1</label><br></td>
  							<td><input type="radio" id="q11" name="kysymys" value="2">
  							<label for="question11">2</label><br></td>
  							<td><input type="radio" id="q11" name="kysymys" value="3">
  							<label for="question11">3</label><br></td>
  							<td><input type="radio" id="q11" name="kysymys" value="4">
  							<label for="question11">4</label><br></td>
  							<td><input type="radio" id="q11" name="kysymys" value="5">
  							<label for="question11">5</label><br></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>Suomeen tarvitaan enemm‰n poliiseja</td>
							<td><input type="radio" id="q12" name="kysymys" value="1">
  							<label for="question12">1</label><br></td>
  							<td><input type="radio" id="q12" name="kysymys" value="2">
  							<label for="question12">2</label><br></td>
  							<td><input type="radio" id="q12" name="kysymys" value="3">
  							<label for="question12">3</label><br></td>
  							<td><input type="radio" id="q12" name="kysymys" value="4">
  							<label for="question12">4</label><br></td>
  							<td><input type="radio" id="q12" name="kysymys" value="5">
  							<label for="question12">5</label><br></td>
							
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
							<td>Maahanmuuttoa Suomeen on rajoitettava terrorismin uhan vuoksi.</td>
							<td><input type="radio" id="q13" name="kysymys" value="1">
  							<label for="question13">1</label><br></td>
  							<td><input type="radio" id="q13" name="kysymys" value="2">
  							<label for="question13">2</label><br></td>
  							<td><input type="radio" id="q13" name="kysymys" value="3">
  							<label for="question13">3</label><br></td>
  							<td><input type="radio" id="q13" name="kysymys" value="4">
  							<label for="question13">4</label><br></td>
  							<td><input type="radio" id="q13" name="kysymys" value="5">
  							<label for="question13">5</label><br></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>Ven‰j‰n etupiiripolitiikka on uhka Suomelle.</td>
							<td><input type="radio" id="q14" name="kysymys" value="1">
  							<label for="question14">1</label><br></td>
  							<td><input type="radio" id="q14" name="kysymys" value="2">
  							<label for="question14">2</label><br></td>
  							<td><input type="radio" id="q14" name="kysymys" value="3">
  							<label for="question14">3</label><br></td>
  							<td><input type="radio" id="q14" name="kysymys" value="4">
  							<label for="question14">4</label><br></td>
  							<td><input type="radio" id="q14" name="kysymys" value="5">
  							<label for="question14">5</label><br></td>
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
							<td>Verkkovalvonnassa valtion turvallisuus on t‰rke‰mp‰‰ kuin kansalaisten yksityisyyden suoja..</td>
							<td><input type="radio" id="q15" name="kysymys" value="1">
  							<label for="question15">1</label><br></td>
  							<td><input type="radio" id="q15" name="kysymys" value="2">
  							<label for="question15">2</label><br></td>
  							<td><input type="radio" id="q15" name="kysymys" value="3">
  							<label for="question15">3</label><br></td>
  							<td><input type="radio" id="q15" name="kysymys" value="4">
  							<label for="question15">4</label><br></td>
  							<td><input type="radio" id="q15" name="kysymys" value="5">
  							<label for="question15">5</label><br></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>Suomen on osallistuttava Isisin vastaiseen taisteluun kouluttamalla Irakin hallituksen joukkoja.</td>
							<td><input type="radio" id="q16" name="kysymys" value="1">
  							<label for="question16">1</label><br></td>
  							<td><input type="radio" id="q16" name="kysymys" value="2">
  							<label for="question16">2</label><br></td>
  							<td><input type="radio" id="q16" name="kysymys" value="3">
  							<label for="question16">3</label><br></td>
  							<td><input type="radio" id="q16" name="kysymys" value="4">
  							<label for="question16">4</label><br></td>
  							<td><input type="radio" id="q16" name="kysymys" value="5">
  							<label for="question16">5</label><br></td>
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
							<td>Parantumattomasti sairaalla on oltava oikeus avustettuun kuolemaan..</td>
							<td><input type="radio" id="q17" name="kysymys" value="1">
  							<label for="question17">1</label><br></td>
  							<td><input type="radio" id="q17" name="kysymys" value="2">
  							<label for="question17">2</label><br></td>
  							<td><input type="radio" id="q17 name="kysymys" value="3">
  							<label for="question17">3</label><br></td>
  							<td><input type="radio" id="q17" name="kysymys" value="4">
  							<label for="question17">4</label><br></td>
  							<td><input type="radio" id="q17" name="kysymys" value="5">
  							<label for="question17">5</label><br></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td>Terveys- ja sosiaalipalvelut on tuotettava ensijaisesti julkisina palveluina.</td>
							<td><input type="radio" id="q18" name="kysymys" value="1">
  							<label for="question18">1</label><br></td>
  							<td><input type="radio" id="q18" name="kysymys" value="2">
  							<label for="question18">2</label><br></td>
  							<td><input type="radio" id="q18" name="kysymys" value="3">
  							<label for="question18">3</label><br></td>
  							<td><input type="radio" id="q18" name="kysymys" value="4">
  							<label for="question18">4</label><br></td>
  							<td><input type="radio" id="q18" name="kysymys" value="5">
  							<label for="question18">5</label><br></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>Viranomaisten pit‰‰ puuttua lapsiperheiden ongelmiin nykyist‰ herkemmin.</td>
							<td><input type="radio" id="q19" name="kysymys" value="1">
  							<label for="question19">1</label><br></td>
  							<td><input type="radio" id="q19" name="kysymys" value="2">
  							<label for="question19">2</label><br></td>
  							<td><input type="radio" id="q19" name="kysymys" value="3">
  							<label for="question19">3</label><br></td>
  							<td><input type="radio" id="q19" name="kysymys" value="4">
  							<label for="question19">4</label><br></td>
  							<td><input type="radio" id="q19" name="kysymys" value="5">
  							<label for="question19">5</label><br></td>
						</tr>
						
					</table>
					<br>
					<table>
					<tr>
					<td> <input type='submit' name='ok' value='Update' style=" font-size: 30px;"  id="button1" ></td>
					<td><input style=" font-size: 30px;" type='reset' name='reset' value='Reset' id="button2"></td>
					<td><input style=' font-size: 30px' type='button' name='cancel' value='Cancel' onclick='window.history.back()'></td>
					<td><a style=" font-size: 30px; border: solid black;" href="/deleteCand?candidate_id=${candidate.candidate_id }">Delete</a></td>
					</tr>
					</table>
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