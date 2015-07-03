<%@ page language='java' contentType='text/html;charset=iso-8859-1'%> 
<%@ page import='java.util.Date' %> 
<%@ page session = "false" %> <!-- PARA QUE NO GENERE AUTOMATICAMENTE SESION AL EJECUTAR EL .JSP-->

<!-- SE PUEDE REDIRIGIR DESDE AQUI AL SERVLET DE GESTION DE ERRORES QUE DEFINIAMOS EN EL WEB.XML -->
<%@ page errorPage = "MensajeError.jsp"%>

	<html> <head> <title>Hola Mundo</title> </head> 
	<body> <p>Hola, esto es una página JSP.</p> 
	<p>La hora del servidor es <%= new Date() %></p> 
	<% int[] arraynum = new int[2];
	arraynum[5]= 3;
	
	
	%>
	
	
	</body> 
</html> 
