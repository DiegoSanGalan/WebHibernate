<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "clasesDTOAutogeneradas.Employees, services.employees.Operaciones, clasesDTOAutogeneradas.Departments" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mostrar empleados</title>
</head>
<body>
<!-- tenemos que usar el mismo nombre de variable que el que ponemos en el Servlet -->


<p>NOMBRE DEL DEPARTAMENTO:  </p>
<c:out value = "${nombredep}"></c:out>

<c:forEach items="${listaemp}" var="emp" >
<ul>
	<li>
	<p><b>EMPLEADO: </b></p>
	<p>NOMBRE: </p>
		<c:out value="${emp.firstName}"></c:out>
	<p>APELLIDO: </p>
		<c:out value="${emp.lastName}"></c:out>
	<p>EMAIL: </p>
		<c:out value="${emp.email}"></c:out>
	<p>SALARIO: </p>
		<c:out value="${emp.salary}"></c:out>
	</li>
</ul>	
</c:forEach>


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