<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
<h2>News List</h2>
<hr>
<table>
    <tr>
        <th>ID</th><th>제목</th><th>작성일자</th>
    </tr>
    <c:forEach var="p" items="${newsList}" varStatus="status">
        <tr>
            <td>${p.id}</td>
            <td><a href="/news.nhn?action=list&id=${p.id}">${p.title}</a></td>
            <td>${p.date}</td>
        </tr>
    </c:forEach>
    <a href="/news.nhn?action=addNews">추가하기</a>
</table>
</body>
</html>