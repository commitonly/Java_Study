package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class TwoDice {
    @RequestMapping("/rollDice")
    public void main(HttpServletResponse response) throws IOException {

        int idx1= (int)(Math.random()*6)+1; // 새로고침할 때 마다 주사위 이미지가 랜덤으로 나오게 만들기 위한 코드
        int idx2= (int)(Math.random()*6)+1;

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<img src='/resources/img/dice"+idx1+".jpg'>"); // 랜덤으로 1~6까지 이미지가 출력됨
        out.println("<img src='/resources/img/dice"+idx2+".jpg'>"); // 랜덤으로 1~6까지 이미지가 출력됨
        out.println("</body>");
        out.println("</html>");


    }

}
