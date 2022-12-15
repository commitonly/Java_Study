package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
//    public void main(int year, int month, int day,  HttpServletResponse response) throws IOException { // 하단에 Integer.parse를 쓰지않고 바로 int로 받기 위한 코드
    // 하단에서 return "yoil"이 문자열이여서 void -> String으로 변경해줘야 에러가 생기지 않는다
//    public String main(int year, int month, int day,  HttpServletResponse response) throws IOException { // 하단에 Integer.parse를 쓰지않고 바로 int로 받기 위한 코드
    public String main(int year, int month, int day,  Model model) throws IOException { // 모델을 적어주고 기존에 사용중이던 response는 더이상 필요없으니 지워줬다

        // 1. 유효성 검사
        if (!isValid(year,month,day))
            return "yoilError";

        // 2. 요일 계산
        char yoil = getYoil(year, month, day);

        // 3. 계산한 결과를 model에 저장
        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("day", day);
        model.addAttribute("yoil", yoil);

        return "yoil"; //WEB-INF/views/yoil.jsp 를 이용해서 작업처리된 결과를 출력해라는 의미이고 반환타입은 문자열이므로 상단에 public void를 public String으로 변경해야함
    }
    // 메서드가 Private으로 설정되는 이유는 이 클래스 안에서만 사용되게 하기위해서이다
    private boolean isValid(int year, int month, int day) {
        return true;
    }
    private char getYoil(int year, int month, int day) {
        Calendar cal= Calendar.getInstance();
        cal.set(year, month -1, day -1); // 위에서 직접 선언해줬으니까 원래 이름 그대로 적어줘야한다

        int dayOfweek = cal.get(Calendar.DAY_OF_WEEK); //1:일요일 2:월요일 ...
        return "일월화수목금토".charAt(dayOfweek);
    }
}
