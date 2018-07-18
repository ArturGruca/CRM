<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="fragments/header.jsp"/>

  <div class="container">

<form action="" method="post">


	<label>Podaj imię pracownika</label><br>
	<input type="text" name="name" required /><br>
	<label>Podaj nazwisko pracownika</label><br>
	<input type="text" name="surname" required /><br>
	<label>Podaj adres pracownika</label><br>
	<input type="text" name="adress" required /><br>
	<label>Podaj numer telefonu pracownika</label><br>
	<input type="number" name="tel_num" required placeholder="Podaj ciąg liczb"/><br>
	<label>Dodaj opis pracownika</label><br>
	<input type="text" name="describe"  /><br>
	<label>Podaj koszt roboczogodziny</label><br>
	<input type="number" name="costPerH" required /><br>

<input type="submit" value="Dodaj nowey pojazd" />
</form>

  </div>

<jsp:include page="fragments/footer.jsp"/>
