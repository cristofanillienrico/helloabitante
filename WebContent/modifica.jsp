<%@page import="it.helloabitante.model.Abitante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Abitante</title>
</head>
<body>
<%Abitante abitanteInPagine=(Abitante)request.getAttribute("abitanteDaInviareAPaginaDettalio"); %>
<form action="ExecuteModificaAbitanteServlet" method="post">
		<label for="nomeInputId">NOME:</label><br>
		<input type="text" name="nomeInput" id="nomeInputId" required >
		<br>
		<label for="cognomeInputId">COGNOME:</label><br>
		<input type="text" name="cognomeInput" id="cognomeInputId" required>
		<br>
		<label for="codiceFiscaleInputId">CODICE FISCALE:</label><br>
		<input type="text" name="codiceFiscaleInput" id="codiceFiscaleInputId" required>
		<br>
		<label for="etaInputId">ETA:</label><br>
		<input type="text" name="etaInput" id="etaInputId" required>
		<br>
		<label for="mottoDiVitaInputId">MOTTO DI VITA:</label><br>
		<input type="text" name="mottoDiVitaInput" id="mottoDiVitaInputId" required>
		<br><br>
		<input type="submit" value="INSERISCI">
		<input type ="hidden" name="idAbitanteDaEliminare" value = "<%= abitanteInPagine.getIdAbitante() %>"> 
	
</form>
</body>
</html>