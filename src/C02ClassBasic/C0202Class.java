package C02ClassBasic;

public class C0202Class { // 한 파일 안에 하나
    public static void main(String[] args) {
//        System.out.println(MyCalculator.sum(10,20));

//        System.out.println();
////      누적매출 구하기
//        클래스 메소드 활용하기
//        MyCalculator.sumAcc(20);
//        System.out.println(MyCalculator.total);
//        MyCalculator.sumAcc(30);
//        System.out.println(MyCalculator.total);
//        MyCalculator.sumAcc(50);
//        System.out.println(MyCalculator.total);
//


//        객체를 이용한 매출 구하기 : 객체 고유의 메모리 공간 할당하기
//        MyCalculatorInstance m1 = new MyCalculatorInstance(); // 1부서의 누적매출 구하기
//        m1.sumAcc(10);
//        m1.sumAcc(20);
//        m1.sumAcc(30);
//        MyCalculatorInstance m2 = new MyCalculatorInstance(); // 2부서의 누적매출 구하기
//        m2.sumAcc(100);
//        m2.sumAcc(200);
//        m2.sumAcc(300);
//        System.out.println(m1.total);
//        System.out.println(m2.total);

        C0203Person person = new C0203Person();
//        변수값에 직접 접근하여 값을 할당하는 방식
//        person.name = "홍길동";
//        person.email = "gildong@mail.com";
//        person.age = 16;

//        일반적인 패턴은 변수값에 직접 접근하지 않는다.
//        의도를 명확히한 메서드를 통해 변수값을 할당하고 가져옴
        person.setName("홍길동");
        System.out.println(person.getName());
        person.eating();


    }
}

class MyCalculator { // 내부클래스
    static int total = 0;

    static int sum(int a, int b) {
        return a + b;
    }
    static void sumAcc(int a) { // return을 하지 않아서 void
        total += a;
    }
}

class MyCalculatorInstance { // 인스턴스
//    static이 붙어있는 변수는 클래스변수, [[static이 붙어있지 않으면 객체변수]]
//    클래스에 메모리를 할당해 복제해서 사용하는 경우를 말한다.
    int total = 0;

    int sum(int a, int b) {
        return a + b;
    }
    void sumAcc(int a) { // return을 하지 않아서 void
        this.total += a; // this 는 클래스 내부의 자기자신을 의미
    }
}