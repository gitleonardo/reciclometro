<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<c:url value="/controlador" var="linkControladorServlet"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reciclômetro - Login</title>
</head>
<body>
	<h1>Login</h1>
	
	<p>Inserir seu usuário e senha para se logar no sistema.</p>
	
	<form action="${linkControladorServlet }" method="post">
		<p>Usuário: <input type="text" name="inputUsuario"/></p>
		<p>Senha: <input type="password" name="inputSenha"/></p>
		
		<input type="hidden" name="acao" value="Login"/>
		<input type="submit" value="Realizar login"/>
	</form>
	
	<p><a href="/reciclometro/controlador?acao=Home">Voltar</a></p>
</body>
</html>