<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>DB Representation</title>
    <%--<link rel="stylesheet" href="css/bootstrap.min.css"/>--%>
</head>

<body>
<table>
    <tr>
        <th>id</th>
    </tr>
    <c:forEach items="${formids}" var="id">
        <tr>
            <td>${id}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
