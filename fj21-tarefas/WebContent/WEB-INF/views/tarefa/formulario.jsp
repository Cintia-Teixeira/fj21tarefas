<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Projeto fj21-tarefas</title>
</head>
<body>
	<h3>Adicionar tarefas</h3>
	<form:errors path="tarefa.descricao"/>
	<form action="adicionaTarefa" method="post">
		Descrição: <br />
		<textarea name="descricao" rows="5" cols="100"></textarea><br />
		<input type="submit" value="Adicionar">
	</form>
</body>
</html>