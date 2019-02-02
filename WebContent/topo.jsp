<%
if(session.getAttribute("login")!= "true"){
	session.setAttribute("mensagem", "Você precisa estar autenticado! ");
	%>

<jsp:forward page="/login.jsp"></jsp:forward>

<%
}
%>