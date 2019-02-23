<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<c:url value="/controlador" var="linkControladorServlet" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reciclômetro</title>
</head>
<body>

	<h1>Lista de Usuários</h1>

	<c:choose>
		<c:when test="${not empty usuarioLogado}">
			<p>
				Bem-vindo, <b>${usuarioLogado.username }</b> <a
					href="/reciclometro/controlador?acao=Logout">Logout</a>
			</p>
		</c:when>
		<c:otherwise>
			<p>
				Bem-vindo. Realize o Login para reciclar um novo produto - <a
					href="/reciclometro/controlador?acao=LoginForm">Login</a>
			</p>
		</c:otherwise>
	</c:choose>

	<table cellpadding="5">
		<tr>
			<td><b>Username</b></td>
		</tr>

		<c:forEach items="${listaUsuarios }" var="usuario">
			<tr>
				<td><c:out value="${usuario.username }" /></td>
				<c:if test="${usuario.username != 'admin' }">
					<td><a href="<c:url value = "/controlador?acao=EditaUsuario&id="/>${usuario.id }">Editar</a></td>
					<td><a href="<c:url value = "/controlador?acao=RemoveUsuario&id="/>${usuario.id }">Remover</a></td>
				</c:if>
			</tr>
		</c:forEach>
	</table>

	<p>
		<a href="/reciclometro/controlador?acao=Home">Voltar</a>
	</p>
</body>
</html>