<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="fragments/header.jsp"/>

  <div class="container">

<table bordercolor="black" border=1px>
	
	<tr>
	<td>Nr id zamówienia</td><td align="center" width="500"> Data przyjęcia zgłoszenia</td> <td align="center">Planowana data rozpoczęcia anprawy </td>
	<td align="center">Data rozpoczęcia naprawy</td><td align="center">Id pzypisanego pracownika</td><td align="center">Opis problemu</td><td align="center">Opis naprawy</td>
	<td align="center">Status naprawy</td><td align="center">Id pojazdu naprawianego</td><td align="center">Całkowity koszt naprawy</td><td align="center">Koszt części</td>
	<td align="center">Ilość roboczogodzin</td><td align="center">Koszt roboczogodziny</td>
	</tr>
	<tr>
	<c:forEach var="item" items="${Order}">
	<td> ${item.order_id} </td><td width="500"> ${item.dateReception}</td> <td>${item.datePlannedStart} </td>
	<td>${item.dateStart}</td><td>${item.idEmployee}</td><td align="center"> ${item.problemDescription}</td><td align="center"> ${item.repairDescription}</td>
	<td align="center"> ${item.repairStatus}</td><td align="center"> ${item.idVehicle}</td><td align="center"> ${item.repairCost} PLN</td>
	<td align="center"> ${item.elementsCost} PLN</td>
	<td align="center"> ${item.quanWorkHour}</td>
	<td align="center"> ${item.costPerH} PLN</td>
	</tr>
	</c:forEach>
</table>
	<br>
	<a href="/CRM/orderAdd">Dodaj nowe zamówienie</a>
	<br>
	<a href="/CRM/orderDelete">Usuń zlecenie</a> 
	<br>
	<a href="/CRM/orderEdit">Edytuj zlecenie</a> 
  </div>

<jsp:include page="fragments/footer.jsp"/>
