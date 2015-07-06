<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>El empleado buscado</title>
</head>
<body>

<p>${"Empleado buscado utilizando Expresion Languaje (EI)"}</p>
<table border="2">

  <tr>
      <th>Nombre</th>
      <th>Apellido</th>
      <th>Salario</th>
    </tr>
    <tr>
      <td>${empleadoDTO.getFirstName()}</td>
      <td>${empleadoDTO.getLastName()}</td>
      <td>${empleadoDTO.getSalary()}</td>
    </tr>
    





</table>

</body>
</html>