package C02ClassBasic;

public class C0205Constructor {

    public static void main(String[] args) {
        Calendar ca = new Calendar();
        Calendar ca1 = new Calendar("2023","11","3");
        ca.setYear("2024");
        ca.setMonth("12");
        ca.setDay("24");

        System.out.println(ca.getYear()+"년 "+ca.getMonth()+"월 "+ca.getDay()+"일입니다!");
        System.out.println(ca1.getYear()+"년 "+ca1.getMonth()+"월 "+ca1.getDay()+"일입니다!");
    }
}

class Calendar{
    private String year,month,day;

    Calendar(String year,String month,String day){
//         생성자 : 클래스명과 동일해야함. 초기화 하고 싶은 변수명 나열하기
//         new~~ 하는 시점에 호출된당!
//        별도의 생성자를 만들 경우, 초기생성자 따로 선언 필요.
        this.year = year;
        this.month = month;
        this.day = day;
    }

//    같은 클래스 내의 다른 생성자 호출 시 this() 사용
    Calendar(String year,String month){
        this(year, month, null); // 매개변수의 개수를 보고 알아서 찾아감
    }


    Calendar(){ // 메소드 오버로딩 > 매개변수가 없을 경우 이쪽으로!
//        위에 있는 Calendar(String year,String month,String day) 이게 있을 때, 이 초기 생성자(매개변수가 없는)가 없으면
//        해당 객체를 생성하려면 매개변수가 반드시 들어가야 생성할 수 있게 강제된당.
        System.out.println("매개변수가 없이 Calendar 호출되었다!");
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getYear() {
        return year;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getMonth() {
        return month;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }
}