<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SIGN UP</title> 
<link rel="stylesheet" href="resources/Css/style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<h4>SIGN UP</h4>
<div class="aa">
<form id="signup" method="post" action="success" >
<pre><h5>FIRST NAME                        LAST NAME</h5></pre>
<input type="text"   name="fname"  placeholder="FIRST NAME" >
<input type="text"   name="lname" placeholder="LAST NAME"><br>
 <c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('fname')}" var="err">
					  <div><span>${err.text}</span></div>
					</c:forEach>
<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('lname')}" var="err">
					  <div><span>${err.text}</span></div>
					</c:forEach> 				
<div class="af">
<pre><h5>PHONE                            <!--  GENDER --></h5></pre>
<input type="text" id="phone" class="form-control" name="phone" placeholder="PHONE" required maxlength="15" onkeyup="validatephone(this);">
 
 <!-- <select name="GENDER">   
            <option value="--Select--">--Select--</option>
			<option value="Male">Male</option>
			<option value="Female">Female</option>
	</select> -->
	<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('phone')}" var="err">
					  <div><span>${err.text}</span></div>
					</c:forEach>		
<div class="ab">
<h5>E-MAIL ID</h5>
<input type="text"  name="email" id="EmailId" placeholder="E-MAIL" onchange="email_validate(this.value);">
<div class="status" id="status"></div>
<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('email')}" var="err">
 <div><span>${err.text}</span></div>
 </c:forEach>
 <div class="ac"> 
<pre><h5>PASSWORD                         <!--  CONFIRM PASSWORD --></h5></pre>
<input type="password"  name="password" id="Password"  placeholder="ENTER THE PASSWORD" required data-toggle="popover" title="Password Strength" data-content="Enter Password....">
<!-- <input type="password" placeholder="ENTER THE PASSWORD"><br><br> -->
<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('password')}" var="err">
					  <div><span>${err.text}</span></div>
					</c:forEach>
<input type="button"  value="SUBMIT" class="btn btn-primary btn-lg btn-block login-button"><br><br>
 </div> 
</div>
</div>
</form>
</div>
</body>
</html>