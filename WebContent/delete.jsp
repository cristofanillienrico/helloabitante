<%@page import="it.helloabitante.model.Abitante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elimina abitante</title>
</head>
<body>
<%Abitante abitanteInPagine=(Abitante)request.getAttribute("abitanteDaInviareAPaginaDettalio"); %>
Nome:<%=abitanteInPagine.getNome() %><br>
Cognome:<%=abitanteInPagine.getCognome() %><br>
CodiceFiscale:<%=abitanteInPagine.getCodiceFiscale() %><br>
Eta:<%=abitanteInPagine.getEta() %><br>
MottoDiVita:<%=abitanteInPagine.getMottoDiVita() %><br><br>
<form action="ExecuteDeleteServlet" method="post">
<input type ="hidden" name="idAbitanteDaEliminare" value = "<%= abitanteInPagine.getIdAbitante() %>"> 
<input type="submit" style="color:red" value="ELIMINA">
</form><br>
<a href="searchForm.jsp">Torna al menu principale</a>

