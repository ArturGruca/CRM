<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="fragments/header.jsp"/>

  <div class="container">

<table bordercolor="black" border=1px>
	
	<tr>
	<td>Nr id</td><td align="center"> Imię Nazwisko</td> <td align="center">Adres </td>
	<td align="center">Nr tel.</td><td align="center">Opis:</td><td align="center">Koszt roboczogodziny</td>
	</tr>
	<tr>
	<c:forEach var="item" items="${Employee}">
	<td>  ${item.employee_id} </td><td> ${item.name} ${item.surname}</td> <td>${item.adress} </td>
	<td>${item.tel_num}</td><td>${item.describe}</td><td align="center"> ${item.costPerH} PLN</td>
	</tr>
	</c:forEach>
</table>
	<br>
	<a href="/CRM/employeeAdd">Dodaj nowego pracownika</a>
	<br>
	<a href="/CRM/employeeDelete">Usuń pracownika</a> 
	<br>
	<a href="/CRM/employeeEdit">Edytuj dane pracownika</a> 
  </div>

<jsp:include page="fragments/footer.jsp"/>


