<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="fragments/header.jsp"/>

  <div class="container">

<table bordercolor="black" border=1px>
<c:forEach var="item" items="${customer}">
	<tr>
	<td> Nr id: ${item.customer_id} </td><td> Imię, Nazwisko: ${item.name} ${item.surname}</td> <td>Data urodzenia: ${item.date} </td>

	</tr>
	</c:forEach>
</table>
	<br>
	<a href="/CRM/CustomerAdd">Dodaj nowego klienta</a>
	<br>
	<a href="/CRM/CustomerDelete">Usuń klienta</a> 
	<br>
	<a href="/CRM/CustomerEdit">Edytuj klienta</a> 
  </div>

<jsp:include page="fragments/footer.jsp"/>


