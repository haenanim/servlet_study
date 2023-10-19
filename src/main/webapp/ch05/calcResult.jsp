<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    isELIgnored="false" %>
<!DOCTYPE html>
<%
    Integer result = (Integer)request.getAttribute("result");
%>
<html>
<head>

<meta charset="UTF-8">
<title></title>
</head>
<body>
<h2>계산 결과</h2>
<hr/>
<%= result%>
</body>
</html>