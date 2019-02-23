<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<c:url value="/controlador" var="linkControladorServlet" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<c:choose>
	<c:when test="${not empty editaUsuario}">
		<title>Reciclômetro - Editar Usuário</title>
	</c:when>
	<c:otherwise>
		<title>Reciclômetro - Novo Usuário</title>
	</c:otherwise>
</c:choose>

</head>
<body>
	
	<c:choose>
	<c:when test="${not empty editaUsuario}">
		<h1>Editar Usuário</h1>
	</c:when>
	<c:otherwise>
		<h1>Novo Usuário</h1>
	</c:otherwise>
</c:choose>

	<form action="${linkControladorServlet }" method="post">
		<p>
			Usuário: <input type="text" name="inputUsername" value="${editaUsuario.username }"/>
		</p>
		<p>
			Senha: <input type="password" name="inputSenha" value="${editaUsuario.senha }"/>
		</p>
				
		<c:choose>
			<c:when test="${not empty editaUsuario}">
				<input type="hidden" name="acao" value="AtualizaUsuario" />
				<input type="hidden" name="id" value="${editaUsuario.id }" />
				<input type="submit" value="Atualizar" />
			</c:when>
			<c:otherwise>
				<input type="hidden" name="acao" value="NovoUsuario" />
				<input type="submit" value="Cadastrar" />
			</c:otherwise>
		</c:choose>
	</form>

	<p>
		<a href="/reciclometro/controlador?acao=Home">Voltar</a>
	</p>
</body>
</html>