<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="fragments/header.jsp"/>

  <div class="container">

<form action="" method="post">

	<label>Podaj imię klienta</label><br>
	<input type="text" name="name" required /><br>
	<label>Podaj nazwisko klienta</label><br>
	<input type="text" name="surname" required /><br>
	<label> Podaj datę urodzenia klienta :</label><br>
	<input type="date" name="date" placeholder="RRRR-MM-DD" /><br>

<input type="submit" value="Dodaj nowego klienta" />
</form>

  </div>

<jsp:include page="fragments/footer.jsp"/>
