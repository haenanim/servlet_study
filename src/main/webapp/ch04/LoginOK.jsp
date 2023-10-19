<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<%


    String id= "";
    id = session.getAttribute("id").toString();
    if(id.equals("")) {
      out.println("아이디를 입력 해 주세요");
    } else {
      out.println(id + "님 반갑습니다.");
    }


 %>

</body>
</html>