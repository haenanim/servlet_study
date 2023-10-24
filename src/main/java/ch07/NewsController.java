package ch07;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/news.nhn")
@MultipartConfig(maxFileSize = 1024*1024*2 , location = "c:/Temp/img")
public class NewsController extends HttpServlet {
  private NewsDAO newsDAO;
  private ServletContext ctx;
  private final String START_PAGE = "/ch07/newsList.jsp";

  @Override
  public void init() throws ServletException {
    super.init();
    newsDAO = new NewsDAO();
    ctx = getServletContext();
  }

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    req.setCharacterEncoding("utf-8");
    String action = req.getParameter("action");
    if(action == null) {
      action = "list";
    }
  }
}