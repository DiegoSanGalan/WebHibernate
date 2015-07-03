<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mostrar Empleado MVC Hibernate</title>
</head>
<body>

<!-- tenemos que usar el mismo nombre de variable que el que ponemos en el Servlet -->
<jsp:useBean id="empleadoDTO" type="clasesDTOAutogeneradas.Employees" scope = "request"/>

<p> <font size = "4">Los datos del empleado buscado son: </font></p>
<p><b>Nombre: </b>
<jsp:getProperty name="empleadoDTO" property="firstName"/></p>
<p><b>Apellido: </b>
<jsp:getProperty name="empleadoDTO" property="lastName"/></p>
<p><b>Email: </b>
<jsp:getProperty name="empleadoDTO" property="email"/></p>
<p><b>Salario: </b>
<jsp:getProperty name="empleadoDTO" property="salary"/></p>









</body>
</html>