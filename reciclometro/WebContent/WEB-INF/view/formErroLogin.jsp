<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<c:url value="/controlador" var="linkControladorServlet" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reciclômetro - Login</title>
</head>
<body>
	<h1>Erro</h1>

	<p>Usuário ou senha incorretos.</p>

	<p>
		<a href="/reciclometro/controlador?acao=LoginForm">Voltar</a>
	</p>
</body>
</html>