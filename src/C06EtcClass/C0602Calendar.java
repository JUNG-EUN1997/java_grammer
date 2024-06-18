package C06EtcClass;

/*
DB말고 프로그렘에 now()를 해서 DB에 박는 이유!!!

* DB에 의존적이지 않기 위해, 프로그램 중심 사상으로 가기 위해
* Current timeStamp를 놓지 않는 것으로 진행함
* DB는 옮길 수 있지만, 프로그램인 JPA는 그대로 사용할 수 있기 때문에
* 또한 DB는 추가할 수 있기도 하기에!
* */

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.Calendar;

public class C0602Calendar {
    public static void main(String[] args) {
//        java.util 패키지의 Calendar 클래스
        Calendar calendar1 = Calendar.getInstance();
//        System.out.println(calendar1.getTime()); // KST : 한국시간  | UTC 세계표준시간

//        2024-06-18
//        System.out.println(calendar1.get(Calendar.YEAR)); // 2024
//        System.out.println(calendar1.get(Calendar.MONTH)+1); // 5 > 0부터 1월이 시작해서, +1 필수!
//        System.out.println(calendar1.get(Calendar.DAY_OF_MONTH)); // 몇일?
//        System.out.println(calendar1.get(Calendar.DAY_OF_WEEK)); // 몇요일? (오늘은 수요일)
//        System.out.println(calendar1.get(Calendar.HOUR_OF_DAY)); // 시간
//        System.out.println(calendar1.get(Calendar.MINUTE)); // 분
//        System.out.println(calendar1.get(Calendar.SECOND)); // 초


//        java.time패키지 : Local~ 클래스
//              날짜(LocalDate) : DB의 date 타입
//              시간(LocalTime) : DB의 time 타입
//              날짜와 시간(LocalDateTime) : DB의 datetime 타입
//        LocalDate presentDate = LocalDate.now();
//        System.out.println(presentDate);
//        System.out.println(presentDate.getYear());
//        System.out.println(presentDate.getMonth());
//        System.out.println(presentDate.getDayOfMonth());
//        System.out.println(presentDate.getDayOfWeek());
//
//
//        LocalTime presentTime = LocalTime.now();
//        System.out.println(presentTime);
//        System.out.println(presentTime.getHour());
//        System.out.println(presentTime.getMinute());
//        System.out.println(presentTime.getSecond());


//        ⭐⭐이게 최고!⭐⭐
//        LocalDateTime presentLocalDateTime = LocalDateTime.now();
//        System.out.println(presentLocalDateTime);
//        System.out.println(presentLocalDateTime.getYear());
//        System.out.println(presentLocalDateTime.getHour());



//        임의로 특정 시간을 만들어 내고 싶을 때, ((of 메서드)) 사용
//        LocalDate birthDay = LocalDate.of(1996,12,24);
//        System.out.println(birthDay.getYear());
//        System.out.println(birthDay.getMonth());
//        System.out.println(birthDay.getDayOfMonth());


//        LocalTime birthTime = LocalTime.of(20,12,24);
//        LocalDateTime birthDayTime = LocalDateTime.of(1996,12,24,20,51,24);

//        매개변수로 크로노필드 enum타입을 사용하여 프로그램의 유연성 향상 가능
//        System.out.println(birthDayTime.get(ChronoField.YEAR));
//        System.out.println(birthDayTime.get(ChronoField.MONTH_OF_YEAR));
//        System.out.println(birthDayTime.get(ChronoField.DAY_OF_MONTH));
//        System.out.println(birthDayTime.get(ChronoField.HOUR_OF_DAY));
//        0 : 오전, 1: 오후
//        System.out.println(birthDayTime.get(ChronoField.AMPM_OF_DAY));

        myWatch(LocalDateTime.now(),ChronoField.YEAR);
        myWatch(LocalDateTime.now(),ChronoField.AMPM_OF_DAY);




    }

    static void myWatch(LocalDateTime localDateTime, ChronoField c){
        if (c == ChronoField.YEAR) {
            System.out.println("연도는 " + localDateTime.get(c) + " 입니다.");
        }else if(c == ChronoField.MONTH_OF_YEAR){
            System.out.println("월은 " + localDateTime.get(c) + " 입니다.");
        }else if(c == ChronoField.AMPM_OF_DAY){
            if(localDateTime.get(c) == 0){
                System.out.println("오전 입니다.");
            }else{
                System.out.println("오후 입니다.");
            }
        }
    }
}
