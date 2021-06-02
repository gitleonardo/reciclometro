<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<c:url value="/controlador" var="linkControladorServlet"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reciclômetro</title>
</head>
<body>
	<h1>Reciclômetro</h1>

	<c:choose>
		<c:when test="${not empty usuarioLogado}">
			<p>
				Bem-vindo, <b>${usuarioLogado.username }</b> <a href="/reciclometro/controlador?acao=Logout">Logout</a>
			</p>
		</c:when>
		<c:otherwise>
			<p>
				Bem-vindo. Realize o Login para reciclar um novo produto - <a
					href="/reciclometro/controlador?acao=LoginForm">Login</a>
			</p>
		</c:otherwise>
	</c:choose>

	<p>
		Quantidade de reciclagem total realizada: <b>${totalReciclagem}</b> Kg
	</p>

	<c:choose>
		<c:when test="${empty usuarioLogado}">
			<p>
				<a href="/reciclometro/controlador?acao=ListaProdutos">Consulta detalhada</a>
			</p>
		</c:when>
		<c:otherwise>
			<p>
				<a href="/reciclometro/controlador?acao=ProdutoForm">Nova Reciclagem</a> |
				<a href="/reciclometro/controlador?acao=ListaProdutos">Consulta detalhada</a>
				
				<c:if test="${usuarioLogado.admin }">
					| <a href="/reciclometro/controlador?acao=UsuarioForm">Novo Usuário</a> |
					<a href="/reciclometro/controlador?acao=ListaUsuarios">Consultar Usuários</a>
					<a href="/reciclometro/controlador?acao=UsuarioPerfil">Novo Perfil Usuário</a>
				</c:if> 
			</p>
		</c:otherwise>
	</c:choose>
</body>
</html>