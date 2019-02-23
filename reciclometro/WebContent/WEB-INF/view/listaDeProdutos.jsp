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

	<h1>Lista de Produtos Reciclados</h1>

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
			<td><b>Tipo</b></td>
			<td><b>Formulação</b></td>
			<td><b>Descrição</b></td>
			<td><b>Peso</b></td>
		</tr>

		<c:forEach items="${listaProdutos }" var="produto">
			<tr>
				<td><c:out value="${produto.tipo }" /></td>
				<td><c:out value="${produto.formulacao }" /></td>
				<td><c:out value="${produto.descricao }" /></td>
				<td><c:out value="${produto.peso }" /></td>
				
				<c:if test="${usuarioLogado.username == 'admin' }">
				<td><a href="<c:url value = "/controlador?acao=EditaProduto&id="/>${produto.id }">Editar</a></td>
				<td><a href="<c:url value = "/controlador?acao=RemoveProduto&id="/>${produto.id }">Remover</a></td>
				</c:if>
			</tr>
		</c:forEach>
	</table>

	<p>
		<a href="/reciclometro/controlador?acao=Home">Voltar</a>
	</p>
</body>
</html>