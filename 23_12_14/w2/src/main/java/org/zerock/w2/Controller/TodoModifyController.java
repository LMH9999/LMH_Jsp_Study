package org.zerock.w2.Controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.w2.dto.TodoDTO;
import org.zerock.w2.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name ="todoModifyController", value="/todo/modify")
@Log4j2
public class TodoModifyController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;
    private final DateTimeFormatter DATEFROMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");



    // 오버라이드 안써도 상관없지만, 기존에 있던건지 재정의 한건지 구분하기 위해서 써주는게 좋음.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Long tno = Long.parseLong(req.getParameter("tno"));
            TodoDTO todoDTO = todoService.get(tno);
            // 데이터 담기
            req.setAttribute("dto", todoDTO);
            req.getRequestDispatcher("/WEB-INF/todo/modify.jsp").forward(req, resp);

        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("modify get .... error");
        }

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String finishedStr = req.getParameter("finished");

        TodoDTO todoDTO=TodoDTO.builder()
                .tno(Long.parseLong(req.getParameter("tno")))
                .title(req.getParameter("title"))
                .dueDate(LocalDate.parse(req.getParameter("dueDate"),DATEFROMATTER))
                .finished(finishedStr !=null && finishedStr.equals("on"))
                .build();

        log.info("/todo/modify POST...");
        log.info(todoDTO);
        try{
            todoService.modify(todoDTO);
        }catch(Exception e){
            e.printStackTrace();
        }
        resp.sendRedirect("/todo/list");
    }
}
