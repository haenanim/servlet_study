<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title></title>
</head>
<body>
<%
 int n1 = Integer.parseInt(request.getParameter("n1"));
 int n2 = Integer.parseInt(request.getParameter("n2"));
 String op = request.getParameter("op");
 long result = 0L;
 switch (op) {
 case "+" : result = n1 + n2; break;
 case "-" : result = n1 - n2; break;
 case "*" : result = n1 * n2; break;
 case "/" : result = n1 / n2; break;
 }
 %>
<h4>
1. jsp 주석
</h4>
<hr />
<!-- HTML 주석 : 화면에서는 안보이고 소스 보기에는 포함 -->
<%-- jsp주석 : 화면과 소스 보기에서 보이지 않음 --%>
<h4>
2. 배열과 함수 선언
</h4>
<hr />
<%!
    String[] members = { "김길동", "홍길동", "김사랑", "박사랑" };
    int num1 = 10;

    int calc(int num2) {
        return num1 + num2;
    }
%>
<% for(String member: members) { %>
    <li> <%=member%> </li>
<% } %>

<h4>
3. 함수의 사용
</h4>
<hr />
<h3>
    <%=calc(10)%>
</h3>
<h4>
4. include : hello.jsp
</h4>
<hr />
<%@ include file="../hello.jsp"%>
<%= result %>
</body>
</html>