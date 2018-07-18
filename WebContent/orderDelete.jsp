<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="fragments/header.jsp"/>

  <div class="container">

<form action="" method="post">

	<label>Podaj id zlecenia które chcesz usunąć:</label><br>
	<input type="number" name="id" required /><br>


<input type="submit" value="Usuń zlecenie" />
</form>

  </div>

<jsp:include page="fragments/footer.jsp"/>
