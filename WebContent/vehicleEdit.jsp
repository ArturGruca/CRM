<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="fragments/header.jsp"/>

  <div class="container">

<form action="" method="post">
	<label>Podaj id pojazdu, którego dane chcesz zmienić</label><br>
	<input type="number" name="id" required /><br>
	<label>Podaj model pojazdu</label><br>
	<input type="text" name="model" required /><br>
	<label>Podaj markę pojazdu</label><br>
	<input type="text" name="brand" required /><br>
	<label>Podaj rok produkcji pojazdu</label><br>
	<input type="number" name="productionYear" required /><br>
	<label>Podaj nr rejestracyjny pojazdu</label><br>
	<input type="text" name="registrationNo" required /><br>
	<label>Podaj date kolejnego przeglądu pojazdu</label><br>
	<input type="text" name="nextReviewDate" placeholder="RRRR-MM-DD" /><br>

<input type="submit" value="Prześlij nowe dane" />
</form>

  </div>

<jsp:include page="fragments/footer.jsp"/>
