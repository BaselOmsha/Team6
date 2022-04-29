<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="app.model.Candidate"%>
<%@ page import="app.model.Kysymykset"%>

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
								href="/adminlogout" style="font-size: 20px"><b>Log out</b></a></li>
						</ul>
					</div>
				</div>
			</nav>
			<!-- /#header -->
		</header>
		<main>

 			<div class="box"> 
						<h1>Candidate Questions Form</h1><br> 
 			<form action='#' method='post'>
 			<input type="text" name="candidate_id" value="${sessionScope.LoggedUser.candidate_id}">
 			<table> 
 			
					<c:forEach var="Kysymyslista"
						items="${requestScope.Kysymyslista}">
 						<tr> 
						<td>${Kysymyslista.kysymys_id}</td>
						<td>${Kysymyslista.kysymys}</td>
 						<td><input type="radio" id="q1${Kysymyslista.kysymys_id}" name="kysymys${Kysymyslista.kysymys_id}" value="1"> 
  							<label for="q1${Kysymyslista.kysymys_id}">1</label><br></td> 
   							<td><input type="radio" id="q2${Kysymyslista.kysymys_id}" name="kysymys${Kysymyslista.kysymys_id}" value="2"> 
  							<label for="q2${Kysymyslista.kysymys_id}">2</label><br></td>
   							<td><input type="radio" id="q3${Kysymyslista.kysymys_id}" name="kysymys${Kysymyslista.kysymys_id}" value="3"> 
   							<label for="q3${Kysymyslista.kysymys_id}">3</label><br></td> 
  							<td><input type="radio" id="q4${Kysymyslista.kysymys_id}" name="kysymys${Kysymyslista.kysymys_id}" value="4"> 
   							<label for="q4${Kysymyslista.kysymys_id}">4</label><br></td> 
   							<td><input type="radio" id="q5${Kysymyslista.kysymys_id}" name="kysymys${Kysymyslista.kysymys_id}" value="5"> 
   							<label for="q5${Kysymyslista.kysymys_id}">5</label><br></td> 
 							<td></td> 
 							<td></td> 
 							<td></td> 
							<td></td> 
 							<td></td> 
						</tr> 
					</c:forEach>
 			</table> 
 			</form>		
					<br><br>
			<br><br>
<!-- 			<h1>Candidate Edit Form</h1><br> -->
<!-- 				<form action='./EditCand' method='post'> -->
<!-- 					<table> -->
<!-- 						<tr> -->
<!-- 							<td>Suomessa on liian helppo el‰‰ sosiaaliturvan varassa</td> -->
<%-- 							<td><input type="radio" id="q1" name="kysymys1" value='${sessionScope.KYSYMYS_ID.candidate_id}'> --%>
<!--   							<label for="question1">1</label><br></td> -->
<%--   							<td><input type="radio" id="q2" name="kysymys1" value="${requestScope.KYSYMYS_ID}"> --%>
<!--   							<label for="question2">2</label><br></td> -->
<%--   							<td><input type="radio" id="q3" name="kysymys1" value="${requestScope.KYSYMYS_ID}"> --%>
<!--   							<label for="question3">3</label><br></td> -->
<%--   							<td><input type="radio" id="q4" name="kysymys1" value="${requestScope.KYSYMYS_ID}"> --%>
<!--   							<label for="question4">4</label><br></td> -->
<%--   							<td><input type="radio" id="q5" name="kysymys1" value="${requestScope.KYSYMYS_ID}"> --%>
<!--   							<label for="question5">5</label><br></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td>Kaupan ja muiden liikkeiden aukioloajat on vapautettava</td> -->
<!-- 							<td><input type="radio" id="q6" name="kysymys2" value="1"> -->
<!--   							<label for="question6">1</label><br></td> -->
<!--   							<td><input type="radio" id="q7" name="kysymys2" value="2"> -->
<!--   							<label for="question7">2</label><br></td> -->
<!--   							<td><input type="radio" id="q8" name="kysymys2" value="3"> -->
<!--   							<label for="question8">3</label><br></td> -->
<!--   							<td><input type="radio" id="q9" name="kysymys2" value="4"> -->
<!--   							<label for="question9">4</label><br></td> -->
<!--   							<td><input type="radio" id="q10" name="kysymys2" value="5"> -->
<!--   							<label for="question10">5</label><br></td> -->
<!-- 							<br> -->
<!-- 						</tr> -->
<!-- 						<tr> -->
<!-- 							<td></td> -->
<!-- 							<td><br></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></input></td> -->
<!-- 							<br> -->
<!-- 						</tr> -->
<!-- 						<tr> -->
<!-- 							<td>Suomessa on siirrytt‰v‰ perustuloon joka korvaisi nykyisen sosiaaliturvan v‰himm‰istason.</td> -->
<!-- 							<td><input type="radio" id="q11" name="kysymys3" value="1"> -->
<!--   							<label for="question11">1</label><br></td> -->
<!--   							<td><input type="radio" id="q12" name="kysymys3" value="2"> -->
<!--   							<label for="question12">2</label><br></td> -->
<!--   							<td><input type="radio" id="q13" name="kysymys3" value="3"> -->
<!--   							<label for="question13">3</label><br></td> -->
<!--   							<td><input type="radio" id="q14" name="kysymys3" value="4"> -->
<!--   							<label for="question14">4</label><br></td> -->
<!--   							<td><input type="radio" id="q15" name="kysymys3" value="5"> -->
<!--   							<label for="question15">5</label><br></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td>Tyˆntekij‰lle on turvattava lailla minimity‰aika.</td> -->
<!-- 							<td><input type="radio" id="q16" name="kysymys4" value="1"> -->
<!--   							<label for="question16">1</label><br></td> -->
<!--   							<td><input type="radio" id="q17" name="kysymys4" value="2"> -->
<!--   							<label for="question17">2</label><br></td> -->
<!--   							<td><input type="radio" id="q18" name="kysymys4" value="3"> -->
<!--   							<label for="question18">3</label><br></td> -->
<!--   							<td><input type="radio" id="q19" name="kysymys4" value="4"> -->
<!--   							<label for="question19">4</label><br></td> -->
<!--   							<td><input type="radio" id="q20" name="kysymys4" value="5"> -->
<!--   							<label for="question20">5</label><br></td> -->
<!-- 						</tr> -->
<!-- 						<tr> -->
<!-- 							<td></td> -->
<!-- 							<td><br></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></input></td> -->
<!-- 							<br> -->
<!-- 						</tr> -->
<!-- 						<tr> -->
<!-- 							<td>Ansiosidonnaisen ty‰tt‰myysturvan kestoa pit‰‰ lyhent‰‰.</td> -->
<!-- 							<td><input type="radio" id="q21" name="kysymys5" value="1"> -->
<!--   							<label for="question21">1</label><br></td> -->
<!--   							<td><input type="radio" id="q22" name="kysymys5" value="2"> -->
<!--   							<label for="question22">2</label><br></td> -->
<!--   							<td><input type="radio" id="q23" name="kysymys5" value="3"> -->
<!--   							<label for="question23">3</label><br></td> -->
<!--   							<td><input type="radio" id="q24" name="kysymys5" value="4"> -->
<!--   							<label for="question24">4</label><br></td> -->
<!--   							<td><input type="radio" id="q25" name="kysymys5" value="5"> -->
<!--   							<label for="question25">5</label><br></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td>Euron ulkopuolella Suomi p‰rj‰isi paremmin.</td> -->
<!-- 							<td><input type="radio" id="q26" name="kysymys6" value="1"> -->
<!--   							<label for="question26">1</label><br></td> -->
<!--   							<td><input type="radio" id="q27" name="kysymys6" value="2"> -->
<!--   							<label for="question27">2</label><br></td> -->
<!--   							<td><input type="radio" id="q28" name="kysymys6" value="3"> -->
<!--   							<label for="question28">3</label><br></td> -->
<!--   							<td><input type="radio" id="q29" name="kysymys6" value="4"> -->
<!--   							<label for="question29">4</label><br></td> -->
<!--   							<td><input type="radio" id="q30" name="kysymys6" value="5"> -->
<!--   							<label for="question30">5</label><br></td> -->
<!-- 						</tr> -->
<!-- 						<tr> -->
<!-- 							<td></td> -->
<!-- 							<td><br></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<br> -->
<!-- 						</tr> -->
<!-- 						<tr> -->
<!-- 							<td>Ruoan verotusta on varaa kirist‰‰.</td> -->
<!-- 							<td><input type="radio" id="q31" name="kysymys8" value="1"> -->
<!--   							<label for="question31">1</label><br></td> -->
<!--   							<td><input type="radio" id="q32" name="kysymys8" value="2"> -->
<!--   							<label for="question32">2</label><br></td> -->
<!--   							<td><input type="radio" id="q33" name="kysymys8" value="3"> -->
<!--   							<label for="question33">3</label><br></td> -->
<!--   							<td><input type="radio" id="q34" name="kysymys8" value="4"> -->
<!--   							<label for="question34">4</label><br></td> -->
<!--   							<td><input type="radio" id="q35" name="kysymys8" value="5"> -->
<!--   							<label for="question35">5</label><br></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td>Valtion ja kuntien taloutta on tasapainotettava ensisijaisesti leikkaamalla menoja.</td> -->
<!-- 							<td><input type="radio" id="q36" name="kysymys9" value="1"> -->
<!--   							<label for="question36">1</label><br></td> -->
<!--   							<td><input type="radio" id="q37" name="kysymys9" value="2"> -->
<!--   							<label for="question37">2</label><br></td> -->
<!--   							<td><input type="radio" id="q38" name="kysymys9" value="3"> -->
<!--   							<label for="question38">3</label><br></td> -->
<!--   							<td><input type="radio" id="q39" name="kysymys9" value="4"> -->
<!--   							<label for="question39">4</label><br></td> -->
<!--   							<td><input type="radio" id="q40" name="kysymys9" value="5"> -->
<!--   							<label for="question40">5</label><br></td> -->
<!-- 						</tr> -->
<!-- 						<td> -->
<!-- 						<td><br></td> -->
<!-- 						<td></td> -->
<!-- 						<td></td> -->
<!-- 						<td></td> -->
<!-- 						<td></td> -->
<!-- 						<td></td> -->
<!-- 						<td></td> -->
<!-- 						<td></td> -->
<!-- 						<br> -->
<!-- 						</tr> -->
<!-- 						<tr> -->
<!-- 							<td>Lapsilisi‰ on korotettava ja laitettava verolle.</td> -->
<!-- 							<td><input type="radio" id="q41" name="kysymys10" value="1"> -->
<!--   							<label for="question41">1</label><br></td> -->
<!--   							<td><input type="radio" id="q42" name="kysymys10" value="2"> -->
<!--   							<label for="question42">2</label><br></td> -->
<!--   							<td><input type="radio" id="q43" name="kysymys10" value="3"> -->
<!--   							<label for="question43">3</label><br></td> -->
<!--   							<td><input type="radio" id="q44" name="kysymys10" value="4"> -->
<!--   							<label for="question44">4</label><br></td> -->
<!--   							<td><input type="radio" id="q45" name="kysymys10" value="5"> -->
<!--   							<label for="question45">5</label><br></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td>Suomella ei ole varaa nykyisen laajuisiin sosiaali- ja terveyspalveluihin.</td> -->
<!-- 							<td><input type="radio" id="q146" name="kysymys11" value="1"> -->
<!--   							<label for="question46">1</label><br></td> -->
<!--   							<td><input type="radio" id="q47" name="kysymys11" value="2"> -->
<!--   							<label for="question47">2</label><br></td> -->
<!--   							<td><input type="radio" id="q48" name="kysymys11" value="3"> -->
<!--   							<label for="question48">3</label><br></td> -->
<!--   							<td><input type="radio" id="q49" name="kysymys11" value="4"> -->
<!--   							<label for="question49">4</label><br></td> -->
<!--   							<td><input type="radio" id="q50" name="kysymys11" value="5"> -->
<!--   							<label for="question50">5</label><br></td> -->
<!-- 							</td> -->
<!-- 						</tr> -->
<!-- 						<tr> -->
<!-- 							<td></td> -->
<!-- 							<td><br></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<br> -->
<!-- 						</tr> -->
<!-- 						<tr> -->
<!-- 							<td>Nato-j‰senyys vahvistaisi Suomen turvallisuuspoliittista asemaa</td> -->
<!-- 							<td><input type="radio" id="q51" name="kysymys12" value="1"> -->
<!--   							<label for="question51">1</label><br></td> -->
<!--   							<td><input type="radio" id="q52" name="kysymys12" value="2"> -->
<!--   							<label for="question52">2</label><br></td> -->
<!--   							<td><input type="radio" id="q53" name="kysymys12" value="3"> -->
<!--   							<label for="question53">3</label><br></td> -->
<!--   							<td><input type="radio" id="q54" name="kysymys12" value="4"> -->
<!--   							<label for="question54">4</label><br></td> -->
<!--   							<td><input type="radio" id="q55" name="kysymys12" value="5"> -->
<!--   							<label for="question55">5</label><br></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td>Suomeen tarvitaan enemm‰n poliiseja</td> -->
<!-- 							<td><input type="radio" id="q56" name="kysymys13" value="1"> -->
<!--   							<label for="question56">1</label><br></td> -->
<!--   							<td><input type="radio" id="q57" name="kysymys13" value="2"> -->
<!--   							<label for="question57">2</label><br></td> -->
<!--   							<td><input type="radio" id="q58" name="kysymys13" value="3"> -->
<!--   							<label for="question58">3</label><br></td> -->
<!--   							<td><input type="radio" id="q59" name="kysymys13" value="4"> -->
<!--   							<label for="question59">4</label><br></td> -->
<!--   							<td><input type="radio" id="q60" name="kysymys13" value="5"> -->
<!--   							<label for="question60">5</label><br></td> -->
							
<!-- 						</tr> -->
<!-- 						<tr> -->
<!-- 							<td></td> -->
<!-- 							<td><br></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<br> -->
<!-- 						</tr> -->
<!-- 						<tr> -->
<!-- 							<td>Maahanmuuttoa Suomeen on rajoitettava terrorismin uhan vuoksi.</td> -->
<!-- 							<td><input type="radio" id="q61" name="kysymys14" value="1"> -->
<!--   							<label for="question61">1</label><br></td> -->
<!--   							<td><input type="radio" id="q62" name="kysymys14" value="2"> -->
<!--   							<label for="question62">2</label><br></td> -->
<!--   							<td><input type="radio" id="q63" name="kysymys14" value="3"> -->
<!--   							<label for="question63">3</label><br></td> -->
<!--   							<td><input type="radio" id="q64" name="kysymys14" value="4"> -->
<!--   							<label for="question64">4</label><br></td> -->
<!--   							<td><input type="radio" id="q65" name="kysymys14" value="5"> -->
<!--   							<label for="question65">5</label><br></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td>Ven‰j‰n etupiiripolitiikka on uhka Suomelle.</td> -->
<!-- 							<td><input type="radio" id="q66" name="kysymys15" value="1"> -->
<!--   							<label for="question66">1</label><br></td> -->
<!--   							<td><input type="radio" id="q67" name="kysymys15" value="2"> -->
<!--   							<label for="question67">2</label><br></td> -->
<!--   							<td><input type="radio" id="q68" name="kysymys15" value="3"> -->
<!--   							<label for="question68">3</label><br></td> -->
<!--   							<td><input type="radio" id="q69" name="kysymys15" value="4"> -->
<!--   							<label for="question69">4</label><br></td> -->
<!--   							<td><input type="radio" id="q70" name="kysymys15" value="5"> -->
<!--   							<label for="question70">5</label><br></td> -->
<!-- 						</tr> -->
<!-- 						<tr> -->
<!-- 							<td></td> -->
<!-- 							<td><br></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<br> -->
<!-- 						</tr> -->
<!-- 						<tr> -->
<!-- 							<td>Verkkovalvonnassa valtion turvallisuus on t‰rke‰mp‰‰ kuin kansalaisten yksityisyyden suoja..</td> -->
<!-- 							<td><input type="radio" id="q71" name="kysymys16" value="1"> -->
<!--   							<label for="question71">1</label><br></td> -->
<!--   							<td><input type="radio" id="q72" name="kysymys16" value="2"> -->
<!--   							<label for="question72">2</label><br></td> -->
<!--   							<td><input type="radio" id="q73" name="kysymys16" value="3"> -->
<!--   							<label for="question73">3</label><br></td> -->
<!--   							<td><input type="radio" id="q74" name="kysymys16" value="4"> -->
<!--   							<label for="question74">4</label><br></td> -->
<!--   							<td><input type="radio" id="q75" name="kysymys16" value="5"> -->
<!--   							<label for="question75">5</label><br></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td>Suomen on osallistuttava Isisin vastaiseen taisteluun kouluttamalla Irakin hallituksen joukkoja.</td> -->
<!-- 							<td><input type="radio" id="q76" name="kysymys17" value="1"> -->
<!--   							<label for="question76">1</label><br></td> -->
<!--   							<td><input type="radio" id="q77" name="kysymys17" value="2"> -->
<!--   							<label for="question77">2</label><br></td> -->
<!--   							<td><input type="radio" id="q78" name="kysymys17" value="3"> -->
<!--   							<label for="question78">3</label><br></td> -->
<!--   							<td><input type="radio" id="q79" name="kysymys17" value="4"> -->
<!--   							<label for="question79">4</label><br></td> -->
<!--   							<td><input type="radio" id="q80" name="kysymys17" value="5"> -->
<!--   							<label for="question80">5</label><br></td> -->
<!-- 						</tr> -->
<!-- 						<tr> -->
<!-- 							<td></td> -->
<!-- 							<td><br></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<br> -->
<!-- 						</tr> -->
<!-- 						<tr> -->
<!-- 							<td>Parantumattomasti sairaalla on oltava oikeus avustettuun kuolemaan..</td> -->
<!-- 							<td><input type="radio" id="q81" name="kysymys18" value="1"> -->
<!--   							<label for="question81">1</label><br></td> -->
<!--   							<td><input type="radio" id="q82" name="kysymys18" value="2"> -->
<!--   							<label for="question82">2</label><br></td> -->
<!--   							<td><input type="radio" id="q83" name="kysymys18" value="3"> -->
<!--   							<label for="question83">3</label><br></td> -->
<!--   							<td><input type="radio" id="q84" name="kysymys18" value="4"> -->
<!--   							<label for="question84">4</label><br></td> -->
<!--   							<td><input type="radio" id="q85" name="kysymys18" value="5"> -->
<!--   							<label for="question85">5</label><br></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td>Terveys- ja sosiaalipalvelut on tuotettava ensijaisesti julkisina palveluina.</td> -->
<!-- 							<td><input type="radio" id="q86" name="kysymys19" value="1"> -->
<!--   							<label for="question86">1</label><br></td> -->
<!--   							<td><input type="radio" id="q87" name="kysymys19" value="2"> -->
<!--   							<label for="question87">2</label><br></td> -->
<!--   							<td><input type="radio" id="q88" name="kysymys19" value="3"> -->
<!--   							<label for="question88">3</label><br></td> -->
<!--   							<td><input type="radio" id="q89" name="kysymys19" value="4"> -->
<!--   							<label for="question89">4</label><br></td> -->
<!--   							<td><input type="radio" id="q90" name="kysymys19" value="5"> -->
<!--   							<label for="question90">5</label><br></td> -->
<!--   						</tr> -->
<!--   						<tr> -->
<!-- 							<td></td> -->
<!-- 							<td><br></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<td></td> -->
<!-- 							<br> -->
<!-- 						</tr> -->
<!-- 						<tr> -->
<!-- 							<td>Viranomaisten pit‰‰ puuttua lapsiperheiden ongelmiin nykyist‰ herkemmin.</td> -->
<!-- 							<td><input type="radio" id="q91" name="kysymys20" value="1"> -->
<!--   							<label for="question91">1</label><br></td> -->
<!--   							<td><input type="radio" id="q92" name="kysymys20" value="2"> -->
<!--   							<label for="question92">2</label><br></td> -->
<!--   							<td><input type="radio" id="q93" name="kysymys20" value="3"> -->
<!--   							<label for="question93">3</label><br></td> -->
<!--   							<td><input type="radio" id="q94" name="kysymys20" value="4"> -->
<!--   							<label for="question94">4</label><br></td> -->
<!--   							<td><input type="radio" id="q95" name="kysymys20" value="5"> -->
<!--   							<label for="question95">5</label><br></td> -->
  							
<!-- 						</tr> -->
						
<!-- 					</table> -->
<!-- 					<br> -->
<!-- 					<table> -->
<!-- 					<tr> -->
<!-- 					<td> <input type='submit' name='ok' value='Update' style=" font-size: 30px;"  id="button1" ></td> -->
<!-- 					<td><input style=" font-size: 30px;" type='reset' name='reset' value='Reset' id="button2"></td> -->
<!-- 					<td><input style=' font-size: 30px' type='button' name='cancel' value='Cancel' onclick='window.history.back()'></td> -->
<%-- 					<td><a style=" font-size: 30px; border: solid black;" href="/deleteCand?candidate_id=${candidate.candidate_id }">Delete</a></td> --%>
<!-- 					</tr> -->
<!-- 					</table> -->
<!-- 				</form> -->
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