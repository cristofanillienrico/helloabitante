<%@page import="it.helloabitante.model.Abitante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dettaglio Abitante</title>
</head>
<body>
<%Abitante abitanteInPagine=(Abitante)request.getAttribute("abitanteDaInviareAPaginaDettalio"); %>
Nome:<%=abitanteInPagine.getNome() %><br>
Cognome:<%=abitanteInPagine.getCognome() %><br>
CodiceFiscale:<%=abitanteInPagine.getCodiceFiscale() %><br>
Eta:<%=abitanteInPagine.getEta() %><br>
MottoDiVita:<%=abitanteInPagine.getMottoDiVita() %><br>


</body>
</html>