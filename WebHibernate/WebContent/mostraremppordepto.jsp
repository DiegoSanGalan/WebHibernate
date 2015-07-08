<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="mitag" uri="/WEB-INF/etiqueta.tld"%>





<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<link rel="stylesheet" type="text/css" href="CSS/tablas.css"/>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mostrar empleados</title>
</head>
<body>
<!-- tenemos que usar el mismo nombre de variable que el que ponemos en el Servlet -->


<h2 align = "justify"><b>NOMBRE DEL DEPARTAMENTO:  
<c:out value = "${nombredep}"></c:out></b></h2>



<c:forEach items="${listaemp}" var="emp" >
<ul>
	<li>
	<p><b><u>EMPLEADO: </u></b></p>
	<p><b>  Nombre: </b><em><c:out value="${emp.firstName}"></c:out></em></p>
	<p><b>  Apellido: </b><em><c:out value="${emp.lastName}"></c:out></em></p>
	<p><b>  Email: </b><em><c:out value="${emp.email}"></c:out></em></p>
	<p><b>  Salario: </b><em><c:out value="${emp.salary}"></c:out></em></p>
	</li>
</ul>	
</c:forEach>








	

<table>
	<tr>
		<th>Nombre</th>
		<th>Apellido</th>
		<th>Email</th>
		<th>Salario</th>
	</tr>
<c:forEach items = "${listaemp}" var = "emp2">
	<tr>
		<td><c:out value="${emp2.firstName}"></c:out>
		</td>
		
		<td><c:out value="${emp2.lastName}"></c:out>
		</td>
		
		<td><c:out value="${emp2.email}"></c:out>
		</td>
		
		<td><c:out value="${emp2.salary}"></c:out>
		</td>
	</tr>	

</c:forEach>
</table>


<%-- 
for (Employees emp : listEmp ) 
{
	
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
--%>

</body>
</html>