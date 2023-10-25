package ch07;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class ListenerExam  implements ServletContextListener, ServletContextAttributeListener,
    HttpSessionListener, HttpSessionAttributeListener,
    ServletRequestListener, ServletRequestAttributeListener
{
  @Override
  public void attributeAdded(ServletContextAttributeEvent event) {
    event.getServletContext().log("서블릿 컨텍스트 속성이 추가 됨" + event.getValue());
  }

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    sce.getServletContext().log("서블릿 컨텍스트가 시작 됨");

  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    sce.getServletContext().log("서블릿 컨텍스트가 종료 됨");
    
  }

  @Override
  public void attributeAdded(HttpSessionBindingEvent event) {
    event.getSession().getServletContext().log("Session 속성 추가" + event.getValue());
  }

  @Override
  public void sessionCreated(HttpSessionEvent se) {
    se.getSession().getServletContext().log("Session이 생성됨" + se.getSession().getId());
  }
}
