package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Calendar;

//년월일을 입력하면 요일을 알려주는 프로그램
@Controller
public class YoilTellerMVC5 {
    @ExceptionHandler(Exception.class)
    public String catcher(Exception ex){
        ex.printStackTrace();
        return "yoilError";
    }
    @RequestMapping("/getYoilMVC4") // 맵핑주소를 MVC로 바꿔준다 맵핑은 중복되면 충돌다니까 중복되지 않게 해야한다
    public ModelAndView main(MyDate date) throws IOException { // 모델을 적어주고 기존에 사용중이던 response는 더이상 필요없으니 지워줬다

        ModelAndView mv = new ModelAndView();
//         1. 유효성 검사
        if (!isValid(date))
            return mv;

        // 2. 요일 계산
        char yoil = getYoil(date);

        // 3. 계산한 결과를 model에 저장
        mv.addObject("myDate", date);
        mv.addObject("yoil", yoil);

        // 4. 결과를 보여줄 view를 지정
        mv.setViewName("yoil");
        return mv;

//        return "yoil"; //WEB-INF/views/yoil.jsp 를 이용해서 작업처리된 결과를 출력해라는 의미이고 반환타입은 문자열이므로 상단에 public void를 public String으로 변경해야함
    }

    private boolean isValid(MyDate date) {
        return isValid(date.getYear(),date.getMonth(),date.getDay());
    }

    private char getYoil(MyDate date) {
        return getYoil(date.getYear(),date.getMonth(),date.getDay());
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
