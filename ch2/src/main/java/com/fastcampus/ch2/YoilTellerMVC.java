package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

//년월일을 입력하면 요일을 알려주는 프로그램
@Controller
public class YoilTellerMVC {//http://localhost:8080/getYoil?year=2021&month=10&day=1
    // public static void main(String[] args) {
//    @RequestMapping("/getYoil") // 기존맵핑주소
    @RequestMapping("/getYoilMVC") // 맵핑주소를 MVC로 바꿔준다 맵핑은 중복되면 충돌다니까 중복되지 않게 해야한다
//    public void main(HttpServletRequest request, HttpServletResponse response) throws IOException { // 톰캣에게 요청하는 객체와 받을 객체를 선언해주는 것
//    public void main(String year, String month, String day,  HttpServletResponse response) throws IOException { // MVC패턴 분리를 위해 각각 선언해서 request로 통으로 받지않고 개별로 받음
    public void main(int year, int month, int day,  HttpServletResponse response) throws IOException { // 하단에 Integer.parse를 쓰지않고 바로 int로 받기 위한 코드
        //1. 입력
//        String year = request.getParameter("year");
//        String month = request.getParameter("month");
//        String day = request.getParameter("day");


        //2. 작업
        //원래는 변환해줘야 하지만 상단에서 바로 int로 받았음으로 주석처리해도 괜찮다
//        int yyyy = Integer.parseInt(year);
//        int mm = Integer.parseInt(month);
//        int dd = Integer.parseInt(day);


        Calendar cal= Calendar.getInstance();
//        cal.set(yyyy, mm-1, dd -1); 기존 방식
        cal.set(year, month-1, day -1); // 위에서 직접 선언해줬으니까 원래 이름 그대로 적어줘야한다

        int dayOfweek = cal.get(Calendar.DAY_OF_WEEK); //1:일요일 2:월요일 ...
        char yoil= "일월화수목금토".charAt(dayOfweek);

        //3. 출력
        response.setContentType("text/html"); //어떤 형태로 받을 것인지 작성 텍스트형태로 받음
        response.setCharacterEncoding("utf-8"); // 한글로 깨지지 않고 잘 나오기 위해 작성
        PrintWriter out = response.getWriter();// response객체에서 브라우저로의 출력 스트링을 얻는다.
        out.println(year + "년" + month + "월" + day + "일은 " );
        out.println(yoil+ "요일입니다.");
    }
}
