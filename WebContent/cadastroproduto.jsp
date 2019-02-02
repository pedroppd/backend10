<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="br.com.projetofinal.model.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="br.com.projetofinal.dao.*"%>
<%@ page import="br.com.projetofinal.model.*"%>

<%
	
	request.setAttribute("produto", new ProdutoDao().list());

	request.setAttribute("categorias", new CategoriaDao().listCategoria());

	request.setAttribute("tamanhos", new TamanhoDao().list());
%>

<html lang="pt-br">
<head>

<meta charset="utf-8">
<title>Cadastro de produtos</title>
<link rel="stylesheet" href="resources/css/estilo.css">
</head>
<body>
	<div id="corpo-form-cad">
		<h1>Cadastro de produtos</h1>
		
		<form action="add" method="post" enctype="multipart/form-data">
		
	
		<label>Nome:</label> <input type="text" name="nome" ><br>
		<label>Preço:</label> <input type="text" name="preco"><br>
		<label>Imagem:</label> <input type="file" name="imagem"><br>
		<label>Categoria:</label> <select name="categoria">
			<c:forEach items="${categorias}" var="cat">
				<option value="${cat.id}">${cat.categoria}</option>
			</c:forEach>
			
		</select> 
		<label>Tamanho:</label> <select name="tamanho">
			<c:forEach items="${tamanhos}" var="t">
				<option value="${t.id}">${t.tamanho}</option>
			</c:forEach>
		</select>
		
		<label>Descrição:</label> <input type="text" name="descricao">
		
		<input	type="submit" value="Cadastrar">

		</form>
	</div>

</body>
</html>