//작성자 : 이무현
//작성일 :

package com.example.demo7;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MyViewServlet", value = "/myView.do")
public class MyViewServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String url = "myViewPage.jsp";  // forward할 url

        // 사용자 처리

        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }
}