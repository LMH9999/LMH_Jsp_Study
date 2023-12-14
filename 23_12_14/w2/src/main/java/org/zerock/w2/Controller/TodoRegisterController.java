package org.zerock.w2.Controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.w2.dto.TodoDTO;
import org.zerock.w2.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name="todoRegisterController", value="/todo/register")
@Log4j2
public class TodoRegisterController extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;

    // 고치기 금지, 형식이 틀어지면 안되므로 final
    private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // get 입력폼을 불러옴
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("/todo/register GET ....");

        HttpSession session = req.getSession();
        // 처음이라 세션으로
        if(session.isNew()){ // 기존 JSESSIONID가 없는 새로운 사용자
            log.info("JSESSIONID 쿠키가 새로 만들어진 사용자");
            resp.sendRedirect("/login");
            return;

        }
        // JSESSEIONID는 있지만 해당 세션 컨텍스트에 loginInfo라는 이름으로 저장된
        // 객체가 없는 경우
        if(session.getAttribute("loginInfo")==null){ // 로그인 정보가 없음(로그인 실패)
            log.info("로그인한 정보가 없는 사용자");
            resp.sendRedirect("/login");
            return;
        }
        //정상적인 경우라면 register 화면으로 이동.
        req.getRequestDispatcher("/WEB-INF/todo/register.jsp").forward(req,resp);
    }

    //post 출력을 불러옴
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TodoDTO todoDTO = TodoDTO.builder()
                .title(req.getParameter("title"))
                .dueDate(LocalDate.parse(req.getParameter("dueDate"),DATEFORMATTER))
                .build();

        log.info("/todo/register POST ...");
        log.info(todoDTO);
        try{
            todoService.register(todoDTO);

        }catch (Exception e){
            e.printStackTrace();
        }
        resp.sendRedirect("/todo/list");
    }
}
