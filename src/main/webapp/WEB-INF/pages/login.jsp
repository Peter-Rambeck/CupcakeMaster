<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login to our app</title>
</head>
<body>
<h1>Olsker Cupcakes</h1>
<br>
<br>

<h2>Log ind med eksisterende bruger</h2>

<form action="loginAuthenticate.jsp" >
    E-mail: <input type="text" name="e-mail"/><br/>
    Password: <input type="password" name="password"/><br/>
    <input type="submit" />
</form>
<br>
<a href="url">Opret ny bruger</a> <br>

<br>
<br>
<br>
<br>
<font color="red"><c:if test="${not empty param.errMsg}">
    <c:out value="${param.errMsg}" />
</c:if></font>
</body>
</html>
