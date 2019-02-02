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
<!DOCTYPE html>

<%
	request.setAttribute("venda", new VendaDao().list());
%>
<html>
<head>
<link href="js/all.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Varela+Round"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.css" media="all">
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.min.css" media="all">

<meta charset="ISO-8859-1">
<title>Lista de pedidos</title>
</head>
<body>

	
	
	
	 <table class="table">
    <thead>
      <tr>
        <th>id</th>
        <th>Valor total</th>
        <th>Data</th>
         <th>número do pedido</th>
          <th>Número da mesa</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${venda}" var="v">
      <tr>
        <td>${v.id}</td>
        <td>${v.precoTotal}</td>
        <td>${v.data_compra}</td>
        <td>${v.id_itemVenda}</td>
        <td>${v.numeroMesa}</td>
      </tr>
    </c:forEach>  
    </tbody>
  </table>
</div>
	


</body>
</html>