package ch06;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
  ProductService services;

  public void init() throws ServletException {
    services = new ProductService();
    services.open();
  }
  @Override
  public void destroy() {
    services.open();
  }


  public ProductController() {

  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String action = req.getParameter("action");
    String view="";

    if(action == null) {
      getServletContext().getRequestDispatcher("/ProductController?action=list")
          .forward(req,resp);
    } else {
      if (action.equals("list")) {
        view = list(req,resp);
      } else if(action.equals("info")) {
        view = info(req,resp);
      } else if(action.equals("update")) {
//        view = update(req,resp);

      }

      getServletContext().getRequestDispatcher("/ch06/"+view)
          .forward(req,resp);
    }
  }

  private String list(HttpServletRequest req, HttpServletResponse resp){
    req.setAttribute("products", services.findAll());
    return "productlist.jsp";
  }

  private String info(HttpServletRequest req, HttpServletResponse resp){
    req.setAttribute("p", services.findById(req.getParameter("id")));
    return "productinfo.jsp";
  }
//  private String update(HttpServletRequest req, HttpServletResponse resp){
//    String id = req.getParameter("id");
//    String name = req.getParameter("name");
//    String maker = req.getParameter("maker");
//    String price = req.getParameter("price");
//    System.out.println(id + name + maker + price);
//    services.updateById(id,name,maker,price);
//    return "productinfo.jsp";
//  }
}