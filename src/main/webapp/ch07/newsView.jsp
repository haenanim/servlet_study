<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    isELIgnored="false" %>
    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
    <h2>뉴스 상세보기</h2>
    <ul>
        <li>id : ${news.id}</li>
        <li>title : ${news.title}</li>
        <li>img : ${news.img}</li>
        <li>date : ${news.date}</li>
        <li>content : ${news.content}</li>
        <li></li>
        <a>삭제하기</a><a>수정하기</a>
    </ul>
</body>
</html>