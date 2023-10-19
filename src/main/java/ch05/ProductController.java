package ch05;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
//  @Override
//  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    doGet(req, resp);
//  }
//
//  @Override
//  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    doGet(req, resp);
//  }


    ProductService service;
  public ProductController() {
    service = new ProductService();
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String action = req.getParameter("action");
    String view = "";
    if(action == null ) {
      getServletContext().getRequestDispatcher("/ProductController?action=list")
        .forward(req,resp);
    }else if(action.equals("list")) {
      view = list(req, resp);
    } else if (action.equals("info")) {
      view = info(req, resp);
    }
    getServletContext().getRequestDispatcher("/ProductController?action=list")
        .forward(req,resp);
  }

  private String list(HttpServletRequest req, HttpServletResponse resp){
    req.setAttribute("products",service.findAll());
    return "productlist.jsp";
  }
  private String info(HttpServletRequest req, HttpServletResponse resp) {
    req.setAttribute("p", service.findById(req.getParameter("id")));
    return "productinfo.jsp";

  }
}