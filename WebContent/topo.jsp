<%
if(session.getAttribute("login")!= "true"){
	session.setAttribute("mensagem", "Voc� precisa estar autenticado! ");
	%>

<jsp:forward page="/login.jsp"></jsp:forward>

<%
}
%>