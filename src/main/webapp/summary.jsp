<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Date,java.util.List,java.io.*" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Budget Summary</title>
</head>
<style>


body { background-image:url("https://media.licdn.com/mpr/mpr/p/7/005/095/15d/05abf1b.jpg") ;
     }

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
<center><h1>Budget Summary </h1></center>
<table align="center" border="3">
    <tr><th>Total Category</th><th>Total Budget Amount</th><th>Total Actual Amount</th></tr>

    <c:forEach items="${budgettotal}" var="aTotal">
        <tr>

            <td><c:out value="${aTotal.cat}"/></td>
            <td>$<c:out value="${aTotal.budtotal}"/></td>
            <td>$<c:out value="${aTotal.acttotal}"/></td>

        </tr>
    </c:forEach>



    <tr>
        <td>Total</td>
        <td>$<c:out value="${totalbudamount}"/> </td>
        <td>$<c:out value="${totalactamount}"/> </td>

    </tr>




</table>
<br>
<br>
<br>

   <center><a href="createbudget.jsp">Go To Detail</a></center>

</body>
</html>