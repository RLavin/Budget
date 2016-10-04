<%--
  Created by IntelliJ IDEA.
  User: Raul
  Date: 10/4/16
  Time: 11:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Movie</title>
</head>
<body>
Please input your movie data and click 'Save'!

<form action="/finance/create" method="post">
    <table>
        <tr> <td>Category:</td>              <td><input type="text" name="cat"></td></tr>
        <tr><td>Description:</td>          <td><input type="text" name="desc"></td></tr>
        <tr> <td>Budget Amount:</td>    <td><input type="text" name="budamount"></td></tr>
        <tr> <td>Actual Amount:</td>    <td><input type="text" name="actamount"></td></tr>

    </table>
    <input type="submit" name="save" />

</form>
</body>
</html>

