<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="fragments/header.jsp"/>

  <div class="container">

<form action="" method="post">
	<h2>Edycja zlecenia</h2>
	<label>Podaj id zlecenia, którego dane chcesz zmienić</label><br>
	<input type="number" name="id" required /><br>
	<label>Podaj datę przyjęcia do naprawy</label><br>
	<input type="text" name="dateReception" required placeholder="RRRR-MM-DD" /><br>
	<label>Podaj datę planowanego rozpoczęca naprawy</label><br>
	<input type="text" name="datePlannedStart" placeholder="RRRR-MM-DD" /><br>
	<label>Podaj datę rozpoczęca naprawy</label><br>
	<input type="text" name="dateStart" placeholder="RRRR-MM-DD" /><br>	
	<label>Podaj id pracownika przypisanego do naprawy</label><br>
	<input type="number" name="idEmployee" required /><br>
	<label>Podaj opis problemu</label><br>
	<input type="text" name="problemDescription" required /><br>
	<label>Podaj opis przeprowadzonych napraw</label><br>
	<input type="text" name="repairDescription"  /><br>
	<label>Wybierz status zlecenia:</label><br>
	<input type="radio" name="repairStatus" value="Przyjęty" checked="checked" />Przyjęty<br>   <!-- tu może być problem przez literkę "ę" -->
	<input type="radio" name="repairStatus" value="Zatwierdzone koszty naprawy" />Zatwierdzone koszty naprawy<br>
	<input type="radio" name="repairStatus" value="W naprawie" />W naprawie<br>
	<input type="radio" name="repairStatus" value="Gotowy do odbioru" />Gotowy do odbioru<br>
	<input type="radio" name="repairStatus" value="Rezygnacja" />Rezygnacja<br>
	<label>Podaj id pojazdu którego dotyczy naprawa</label><br>
	<input type="number" name="idVehicle" required /><br>
	<label>Podaj koszty naprawy</label><br>
	<input type="number" name="repairCost" min="0" step="0.01" /><br>
	<label>Podaj koszty zurzytych części</label><br>
	<input type="number" name="elementsCost" min="0" step="0.01" /><br>
	<label>Podaj ilosć potrzebnych roboczogodzin</label><br>
	<input type="number" name="quanWorkHour" /><br>
	<br>

<input type="submit" value="Prześlij nowe zlecenie" />
</form>

  </div>

<jsp:include page="fragments/footer.jsp"/>
