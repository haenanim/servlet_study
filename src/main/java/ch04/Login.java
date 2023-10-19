package ch04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String id = req.getParameter("id");
    String pwd = req.getParameter("pwd");
//    System.out.println(id + pwd);
    HttpSession session = req.getSession();
    session.setAttribute("id",id);
    String id1 = (String)session.getAttribute("id");
//    System.out.println(id1);

//    req.setAttribute("sharedInfo", "전달된 데이터");
    resp.sendRedirect("/jwbook/ch04/LoginOK.jsp");
  }
}