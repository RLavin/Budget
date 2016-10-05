<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Date,java.util.List,java.io.*" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Budget</title>
</head>
<style>



body {background-image: url("https://thumbs.dreamstime.com/z/budget-background-financial-concept-note-book-money-calculator-66275030.jpg");
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
    <tr><th>Edit</th><th>Category</th><th>Description</th><th>Budget Amount</th><th>Actual Amount</th><th>Delete</th></tr>
    <c:forEach items="${thebudgetlist}" var="detail">
        <tr>
            <td><a href="/finance/select?id=<c:out value="${detail.id}"/>">EDIT</a>
            <td> <c:out value="${detail.category}"/></td>
            <td> <c:out value="${detail.description}"/></td>
            <td>$ <c:out value="${detail.budgetamount}"/></td>
            <td>$ <c:out value="${detail.actualamount}"/></td>
            <td><a href="/finance/delete?id=<c:out value="${detail.id}"/>">DELETE</a></td>
        </tr>
    </c:forEach>
</table>
<br>
<br>
<br>

   <center> <a href="/finance/total">HOME</a>
    </center>
<br>
<br>

<center><form action="/finance/filter" method="post">
    Search <input type="text" name="searchtext"/>
    <br>
    <input type="submit" name="Filter Results"/>
</form></center>
<br>
<br>
<center>Create New Budget <a href="/finance/createnewbudget.jsp">HERE</a></center>


</body>
</html>