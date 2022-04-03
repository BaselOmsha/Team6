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
<title>Candidate Registration Form</title>
<!--Link to bootstrap.-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="../css/style.css">
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
  color:#000000;
  background-color: #eeeeef;
  border: none;
  font-size: 20px;
	
}

tr:nth-child(even) {
  background-color: rgb(0, 0, 255);
   
}

</style>
</head>
<body>
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
						<!-- 							<li class="nav-item"><a class="nav-link active" -->
						<!-- 								aria-current="page" href="votRegForm.html" style=" font-size: 20px"><b>Voter Registration</b></a></li> -->
						<li class="nav-item"><a class="nav-link active"
							href="./staticRegForm/candRegForm.html" style="font-size: 20px"><b>Candidate
									Registration</b></a></li>
						<li class="nav-item"><a class="nav-link active"
							style="font-size: 20px"><b>
									<%
									//get the cockies
									Cookie[] cookies = request.getCookies();
									String uname = null;
									if (cookies != null) {
										for (int i = 0; i < cookies.length; i++) {

											if (cookies[i].getName().equals("Welcome"))
										uname = cookies[i].getValue();
											out.println("Welcome " + uname);
										}
									}
									if (uname == null)
										response.sendRedirect("/AdminLogIn.html");
									%>
							</b></a></li>
						<li class="nav-item"><a class="nav-link active"
							href="/adminlogout" style="font-size: 20px"><b>Log out</b></a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
		<main>
		<div class="box">
		<br><br>
			<h1>Candidate Registration Form</h1><br>
				<h5 style="color:red">Fill up all the required fields!</h5><br>
			
			<form method='post' action='/candidate'>
				<table>
					<tr>
						<td>First name*</td>
						<td><input type='text' name='fname' 
							placeholder='First name*'><br></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td>Last name*</td>
						<td><input type="text" name="lname" placeholder="Last name*"></input></td>
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
						<td>Social Security Number*</td>
						<td><input type='text' name='ssn'  placeholder='SSN*'><br></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td>Party*:</td>
						<td><input type="text" name="party" placeholder="Party*"></input></td>
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
						<td>Email</td>
						<td><input type='text' name='email' 
							placeholder='email'><br></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td>Uname*:</td>
						<td><input type="text" name="uname" placeholder="Uname*"></input></td>
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
						<td>Age</td>
						<td><input type='number' name='age' 
							placeholder='Age*'><br></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td>Password*</td>
						<td><input type="password" name="paswd"
							placeholder="Password*" id="myInput"></input></td>
						<td style="font-size: 12px">Show password<input
							type="checkbox" onclick="myFunction()">
						</td>
					</tr>
				</table>
				<br>
				<br> <input type='submit' name='ok' value='Register'
					style="margin-left: 45%; font-size: 30px"
					onclick='sendInfo(this.form);'>
					<br> <input type='button' name='ok' value='Cancel'
					style="margin-left: 46%; font-size: 30px"
					onclick='window.history.back()'>
			</form>
			<br>
			<br> Items with an asterisk (*) are mandatory <br><br>
		</div>	
		</main>
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
		<script>
            function myFunction() {
              var x = document.getElementById("myInput");
              if (x.type === "password") {
                x.type = "text";
              } else {
                x.type = "password";
              }
            }
        </script>
	</body>
</html>