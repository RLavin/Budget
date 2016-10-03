<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Date,java.util.List,java.io.*" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Budget</title>
</head>
<style>



body {background-image: url("https://thumbs.dreamstime.com/z/budget-background-financial-concept-note-book-money-calculator-66275030.jpg");  ;
       align-content: center; }

table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 45%;
}

td, th {
    border: 2px solid #566573 ;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd ;
}



</style>
<body>
<center><h1>Monthly Budget</h1></center>

<table align="center" border="3">
    <tr><th>Category</th><th>Description</th><th>Budgeted Amount</th><th>Actual Amount</th></tr>
    <c:forEach items="${thebudgetlist}" var="detail">
        <tr>
            <td> <c:out value="${detail.category}"/></td>
            <td> <c:out value="${detail.description}"/></td>
            <td>$ <c:out value="${detail.budgetamount}"/></td>
            <td>$ <c:out value="${detail.actualamount}"/></td>
        </tr>
    </c:forEach>
</table>
<br>
<br>
<br>

   <center> <a href="/finance/mybudget">HOME</a>
    </center>
<br>
<br>
<form action="/finance/filter" method="post">
    Search <input type="text" name="searchtext"/>
    <br>
    <input type="submit" name="Filter Results"/>
</form>


</body>
</html>