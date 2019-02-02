

<html lang="pt-br">
<head>


	<meta charset="utf-8">
    <title>Login</title>
	<link rel="stylesheet" href="resources/css/estilo.css">
	
	<link href="resources/js/all.min.css" rel="stylesheet">

</head>
<body>
	<div id="corpo-form">
     <h1>Efetue o seu login</h1>
		<form method="POST" action="checkLogin">
		<input type="text" name="login">
		<input type="password" name="senha" >
		<input type="submit" value="Acessar">
		

	</form><br>
	${msg}
	
	</div>
	
</body>
</html>