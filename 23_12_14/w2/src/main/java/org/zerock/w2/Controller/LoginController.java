package org.zerock.w2.Controller;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.zerock.w2.dto.MemberDTO;
import org.zerock.w2.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/login")
@Log
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("login get .....");

        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req,resp);

        // get으로 login.jsp를 부르고
    }

        // login.jsp에서 post로
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("login post....");

        String mid = req.getParameter("mid");
        String mpw = req.getParameter("mpw");

        String auto = req.getParameter("auto");

        boolean rememberMe = auto !=null && auto.equals("on");

        // String str = mid+mpw;

        try{
            MemberDTO memberDTO = MemberService.INSTANCE.login(mid, mpw);

            if(rememberMe) {


                String uuid = UUID.randomUUID().toString();

                MemberService.INSTANCE.updateUuid(mid, uuid);
                memberDTO.setUuid(uuid);
                Cookie rememberCookie=new Cookie("remember-me",uuid);
                rememberCookie.setMaxAge(60* 60* 24* 7); // 쿠키의 유효기간은 1주일
                rememberCookie.setPath("/");

                resp.addCookie(rememberCookie);

            }
            HttpSession session = req.getSession();

            session.setAttribute("loginInfo", memberDTO); // loninInfo라는 이름으로 문자열을 보관
            // LOGIN 버튼을 누르면 POST 방식으로 처리되고 이동.
            resp.sendRedirect("/todo/list");
        }catch(Exception e) {
            resp.sendRedirect("/login?result=error");
        }
    }
}
