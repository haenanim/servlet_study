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
    <form action="/jwbook/ProductController?action=update" method="post">
    id<input type="text" name="id" size="10px"/><br/>
    name<input type="text" name="name" size="10px"/><br/>
    maker<input type="text" name="maker" size="10px"/><br/>
    price<input type="text" name="price" size="10px"/><br/>
    <input type="submit" value="로그인" />
    </form>
</body>
</html>