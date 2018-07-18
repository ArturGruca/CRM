<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="fragments/header.jsp"/>

  <div class="container">

<table bordercolor="black" border=1px>
<c:forEach var="item" items="${Vehicle}">
	<tr>
	<td> Nr id: ${item.vehicle_id} </td><td> Model: ${item.model}</td><td>Marka: ${item.brand}</td> <td>Data produkcji: ${item.productionYear} </td>
	<td>Nr rej. ${item.registrationNo}</td><td>Następny przegląd: ${item.nextReviewDate}</td>
	</tr>
	</c:forEach>
</table>
	<br>
	<a href="/CRM/vehicleAdd">Dodaj nowy pojazd</a>
	<br>
	<a href="/CRM/vehicleDelete">Usuń pojazd</a> 
	<br>
	<a href="/CRM/vehicleEdit">Edytuj dane pojazdu</a> 
  </div>

<jsp:include page="fragments/footer.jsp"/>


