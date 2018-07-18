<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="fragments/header.jsp"/>

  <div class="container">

<form action="" method="post">
	<label>Podaj id klienta, którego dane chcesz zmienić</label><br>
	<input type="number" name="id" required /><br>
	<label>Podaj nowe imię</label><br>
	<input type="text" name="name" required /><br>
	<label>Podaj nowe nazwisko</label><br>
	<input type="text" name="surname" required /><br>
	<label> Podaj nową datę urodzenia klienta :</label><br>
	<input type="date" name="date" placeholder="RRRR-MM-DD" /><br>

<input type="submit" value="Prześlij nowe dane" />
</form>

  </div>

<jsp:include page="fragments/footer.jsp"/>
