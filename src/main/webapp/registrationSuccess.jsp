<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>successPage</title>
</head>
<body>
	<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
	<h2>registered successfully with <c:out value="${requestScope.seq}"></c:out> please use the same to
		login</h2>
	<hr>
	<jsp:include page="login.html"></jsp:include>
</body>
</html>