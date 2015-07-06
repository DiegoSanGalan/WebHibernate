<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import = "clasesDTOAutogeneradas.Employees" %>
<%@ page import = "java.util.ArrayList" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- tenemos que usar el mismo nombre de variable que el que ponemos en el Servlet -->

<% 
ArrayList<Employees> listEmp = (ArrayList<Employees>)request.getAttribute("listaemp");
String nombreDpto = (String)request.getAttribute("nombredep");

%>

<p>NOMBRE DEL DEPARTAMENTO:  </p>
<%=nombreDpto%>

<% 
for (Employees emp : listEmp ) 
{%>
	
<ul>
	<li>
	<p><b>EMPLEADO: </b></p>
	<p>NOMBRE: </p>
	<%= emp.getFirstName()%>
	
	<p>APELLIDO: </p>
	<%= emp.getLastName()%>
	
	<p>EMAIL: </p>
	<%= emp.getEmail()%>
	
	<p>SALARIO: </p>
	<%= emp.getSalary()%>
	</li>
</ul>	
	
<%}
%>


</body>
</html>