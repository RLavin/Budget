<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Raul
  Date: 10/5/16
  Time: 11:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Movie</title>
</head>
<body>
Please edit your movie data and click 'Update'!

<form action="/finance/update" method="post">
    <table>
        <tr><td>Category:</td>              <td><input type="text" name="cat" value="<c:out value="${myEdit.category}"/>"></td></tr>
        <tr><td>Description:</td>          <td><input type="text" name="desc" value="<c:out value="${myEdit.description}"/>"></td></tr>
        <tr><td>Budget Amount:</td>     <td><input type="text" name="budamount" value="<c:out value="${myEdit.budgetamount}"/>"></td></tr>
        <tr><td>Actual Amount:</td>       <td><input type="text" name="actamount" value="<c:out value="${myEdit.actualamount}"/>"></td></tr>
    </table>
    <input type="submit" name="Update" />
    <input type="hidden" name="id" value="<c:out value="${myEdit.id}"/>"/>
</form>
</body>
</html>