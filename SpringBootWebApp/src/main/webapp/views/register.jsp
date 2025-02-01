<!-- JSP is use to create a dynamic web -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register here</title>
<link rel="stylesheet" href="css/style.css"/>
</head>
<body class="body_bg">
<h4> Register Here</h4>
<c:if test="${not empty SuccessMasg}">
<h4 style="color: green"> ${SuccessMasg}</h4>
</c:if>

<c:if test="${not empty ErrorMasg}">
<h4 style="color: red"> ${ErrorMasg}</h4>
</c:if>


<form action="regForm" method="post">
Name : <input type="text" name="name"/> <br/><br/>
Email : <input type="text" name="email"/> <br/><br/>
Password : <input type="password" name="password"/> <br/><br/>
Phone No : <input type="text" name="phoneno"/> <br/><br/>
<input type="submit" value="Register"/>
</form>

<br/><br/>
If already registered.....<a href="loginPage"><b>Click Here</b></a>


</body>
</html> 