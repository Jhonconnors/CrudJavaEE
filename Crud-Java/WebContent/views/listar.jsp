<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Listar Productos</title>
		<style>
			input {background-color: #B83F35}
			.edit{background-color: #4EB9EC}
		</style>
	</head>
	<body>
		<div align="center">
		 <h1>Listar Productos</h1>
		 <table border="1">
		  <tr>
		   <td>Id</td>
		   <td>Nombre</td>
		   <td>Cantidad</td>
		   <td>Precio</td>
		   <td>Accion 1</td>
		   <td>Accion 2</td>
		  </tr>
		  <c:forEach var="producto" items="${lista}">
			  <tr>
			    <td>
			      <c:out value="${ producto.id}"></c:out>
			    </td>
			    <td><c:out value="${ producto.nombre}"></c:out></td>
			    <td><c:out value="${ producto.cantidad}"></c:out></td>
			    <td><c:out value="${ producto.precio}"></c:out></td>
			    <td> <a href="productos?opcion=eliminar&id=<c:out value="${ producto.id}"></c:out>">
       		  	<input type="button" value="Eliminar"></a></td>
       		  	<td> <a href="productos?opcion=meditar&id=<c:out value="${ producto.id}"></c:out>">
       		  	<input type="button" class="edit" value="Editar"></a></td>
			  </tr>
		  </c:forEach>
		 </table>
		 </div>
	</body>
</html>