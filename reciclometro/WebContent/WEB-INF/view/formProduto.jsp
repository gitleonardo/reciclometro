<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<c:url value="/controlador" var="linkControladorServlet" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<c:choose>
	<c:when test="${not empty editaProduto}">
		<title>Reciclômetro - Editar Produto Reciclável</title>
	</c:when>
	<c:otherwise>
		<title>Reciclômetro - Novo Produto Reciclável</title>
	</c:otherwise>
</c:choose>

</head>
<body>
	
	<c:choose>
	<c:when test="${not empty editaProduto}">
		<h1>Editar Produto Reciclável</h1>
	</c:when>
	<c:otherwise>
		<h1>Novo Produto Reciclável</h1>
	</c:otherwise>
</c:choose>

	<form action="${linkControladorServlet }" method="post">
		<p>
			Material: <input type="text" name="inputMaterial"
				value="${editaProduto.tipo }" />
		</p>
		<p>
			Descrição: <input type="text" name="inputDescricao"
				value="${editaProduto.descricao }" />
		</p>
		<p>
			Peso(Kg): <input type="text" name="inputPeso"
				value="${editaProduto.peso }" />
		</p>

		<c:choose>
			<c:when test="${not empty editaProduto}">
				<input type="hidden" name="acao" value="AtualizaProduto" />
				<input type="hidden" name="id" value="${editaProduto.id }" />
				<input type="submit" value="Atualizar" />
			</c:when>
			<c:otherwise>
				<input type="hidden" name="acao" value="NovoProduto" />
				<input type="submit" value="Cadastrar" />
			</c:otherwise>
		</c:choose>

	</form>

	<p>
		<a href="/reciclometro/controlador?acao=Home">Voltar</a>
	</p>
</body>
</html>