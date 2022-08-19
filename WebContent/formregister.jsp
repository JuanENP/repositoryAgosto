<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- Esta etiqueta importa las etiqutas (tags) propias de struts -->
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- importa tags de javascrpt -->
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modulo Register</title>
</head>
<s:head />
<sx:head />
<body>
	<sx:tabbedpanel id="formCrud">
		<sx:div label="Modulo CRUD- REGISTER">
		<!-- alta es el name en el struts del método addRegister -->
			<s:form action="alta.action" method="post">
				<s:push value="register">
					<s:hidden key="id"></s:hidden>
					<s:textfield key="nombre" label="Nombre"></s:textfield>
					<s:radio name="genero" label="Genero" list="#{'Masculino': 'MASCULINO', 'Femenino':'FEMENINO'}"></s:radio>
					<s:select name="ciudad" label="Ciudad" list="#{'Pue':'PUEBLA', 'Tlax':'TLAXCALA', 'Ver':'VERACRUZ'}"
					headerKey="1" headerValue="Selecciona una Ciudad"></s:select>
					<s:textarea key="descripcion" label="Descripcion"></s:textarea>
					<s:checkbox name="desarrollador" label="¿Tiene experiencia en  Siabel?"></s:checkbox>
					
					<s:submit value="Enviar Datos"></s:submit>
					<s:reset value="Limpiar todo"></s:reset>
				</s:push>
			</s:form>
			
			<table border="1">
				<tr>
					<th>ID</th>
					<th>Nombre</th>
					<th>Genero</th>
					<th>Ciudad</th>
					<th>Descripcion</th>
					<th>Desarollador</th>
					<th>Editar</th>
					<th>Eliminar</th>
				</tr>
				<!-- listRegisters es el nombre de la clase en DaoImplRegister que me arroja todos los registros -->
				<s:iterator value="listRegisters">
					<tr>
						<td> <s:property value="id"/> </td>
						<td> <s:property value="nombre"/> </td>
						<td> <s:property value="genero"/> </td>
						<td> <s:property value="ciudad"/> </td>
						<td> <s:property value="descripcion"/> </td>
						<td> <s:property value="desarrollador"/> </td>
						<td>
							<s:url id="editURL" action="editar">
								<s:param name="id" value="%{id}"></s:param>
							</s:url>
							<s:a href="%{editURL}">Editar</s:a>
						</td>
						
						<td>
							<s:url id="deleteURL" action="baja">
								<s:param name="id" value="%{id}"></s:param>
							</s:url>
							<s:a href="%{deleteURL}">Eliminar</s:a>
						</td>
						
					</tr>
				</s:iterator>
			</table>
		</sx:div>
	</sx:tabbedpanel>
</body>
</html>