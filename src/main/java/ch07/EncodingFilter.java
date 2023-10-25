package ch07;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class EncodingFilter implements Filter {

  @Override
  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fc) throws IOException, ServletException {
    HttpServletRequest httpReq = (HttpServletRequest)req;
    if(httpReq.getMethod().equalsIgnoreCase("POST") || httpReq.getMethod().equalsIgnoreCase("GET")) {
      req.setCharacterEncoding("UTF-8");
    }
  fc.doFilter(req,resp);

  }
}
