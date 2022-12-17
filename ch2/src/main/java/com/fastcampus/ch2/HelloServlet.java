package com.fastcampus.ch2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        // 서블릿이 초기화 될 때 자동 호출되는 메서드
        // 1. 서블릿의 초기화 작업 담당
        System.out.println("[HelloServlet] init() is called.");
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 입력
        // 2. 처리
        // 3. 출력
        System.out.println("[HelloServlet] service() is called.");
    }

    @Override
    public void destroy() {

        // 3. 뒷정리 - 서블릿이 메모리에서 제거될 때 서블릿 컨테스트에 의해서 자동 호출
        // 서블릿이 메모리에서 내려올 때
        // 서블릿이 다시 갱신되서 리로딩 될 때
        // 웹 어플리케이션이 종료될 때 이 메서드가 서블릿과 관련된 뒷마무리 작업을 하기위해 호출이 된다
        System.out.println("[HelloServlet] destroy() is called.");
    }

}

