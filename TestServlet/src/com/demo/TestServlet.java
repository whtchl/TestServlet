package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
    
  private static final long serialVersionUID = 1L;  
       
  /** 
   * @see HttpServlet#HttpServlet() 
   */  
  public TestServlet() {  
      super();  
  }  

  /** 
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) 
   */  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
      this.log("execute doGet method...");  
      this.execute(request, response);  
  }  

  /** 
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) 
   */  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
      this.log("execute doPost method...");  
      this.execute(request, response);  
  }  
    
  private void execute(HttpServletRequest request,HttpServletResponse response)   
          throws ServletException,IOException{  
    
      response.setCharacterEncoding("UTF-8");  
      request.setCharacterEncoding("UTF-8");  
        
      String requestURI =request.getRequestURI();  
      String method = request.getMethod();  
      String param = request.getParameter("param");  
        
      response.setContentType("text/html");  
        
      PrintWriter out = response.getWriter();//获取响应输出对象  
        
      out.println("<!DOCTYPE html>");  
      out.println("<html>");  
      out.println("<head>");  
      out.println("</head>");  
      out.println("<body>");  
        
      out.println("   <h2>通过 "+ method+ " 方式访问页面，参数为："+ param +"</h2>");  
      out.println("   <br/>");  
        
      out.println("   <form action= '"+ requestURI +"' method='get'>"  
              + " <input type='text' name='param' value='get param' > <input type='submit' value='GET方式提交页面"+ requestURI +"'></form>");  
      out.println("   <br/>");  
        
      out.println("   <form action= '"+ requestURI +"' method='post'> "  
              + " <input type='text' name='param' value='post param' > <input type='submit' value='POST方式提交页面"+ requestURI +"'></form>");         
      out.println("   <br/>");  
        
      out.println("<script> document.write('update time:'+document.lastModified) </script>");  
      out.println("</body>");  
      out.println("</html>");  
        
      out.flush();  
      out.close();      
  }  

}
