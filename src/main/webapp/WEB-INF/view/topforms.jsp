<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Top 5 forms</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th, td {
            padding: 5px;
            text-align: left;
        }
    </style>
</head>

<body>
<h3>Top 5 most commonly used forms</h3>
<table style="width:50%">
    <tr>
        <th>Top</th>
        <th>Form</th>
        <c:set var="count" value="0"/>
        <c:forEach items="${formids}" var="id">
            <c:set var="count" value="${count + 1}"/>
        <tr>
            <td>${count}</td>
            <td>${id}</td>
        </tr>
        </c:forEach>
</table>
</body>
</html>
