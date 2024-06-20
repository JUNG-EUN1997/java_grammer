package C08Thread;

import java.util.Collections;

// Thread 클래스에는 run 메서드 존재 (단, 비어있는 메서드)
// 따라서 실행 시 작업하고자 하는 내용을 run() 메서드를 overriding을 통해 구현
// 상속관계이다 보니, 다중 사속 불가 : Runnable과의 차이
public class MainClass {

//        스레드 생성방법 2가지
    public static void main(String[] args) throws InterruptedException {
//        ⭐방법 1⭐ 스레드 상속 방식
//        Thread t1 = new Thread1();
        // Thread에 Thread1이 상속되어 target이 되며,
        // Thread 안에 비어있는 run 메소드가 target인 Thread1을 실행된다.

//        t1.start();
//        Thread t2 = new Thread1();
//        t2.start();

//        ⭐방법 2⭐ Runnable 구현 방식 >> 이 방법으로 생성할 수 있어야 함.
//        Runnable을 구현한 객체를 Thread 클래스에 주입하는 방식
//        Thread t3 = new Thread( new Thread1());
//        t3.start();
//
//        new Thread(new Thread2()).start();

//        Thread 생성법 1 ::
//        new Thread(() -> System.out.println("익명의 Runnable객체 주입 후 실행 Thread")).start();

//        Thread 생성법 2 ::
//        Thread th = new Thread(new Runnable() {
//            @Override public void run() {
//                System.out.println("익명의 Runnable객체 주입 후 실행 Thread");
//            }});
//        th.start();

//        🚨동시성 이슈 발생🚨
//        for (int i = 0; i < 99999; i++) {
//            // 만들어 짐과 동시에 대출을 신청하는 형식,
//            // 완전한 동시는 아니기 때문에 ((동시성 이슈 발생))
//            new Thread(Library::borrow).start();
//        }

//        🍀해결법 1🍀 : join 하기
//        🍀해결법 2🍀 : synchronized 하기 >> Library.java 파일 참고
        for (int i = 0; i < 1000; i++) {
            Thread t1 = new Thread(Library::borrow);
            t1.start();
            t1.join();
        }

        System.out.println("Main의 최종수량 >> " + Library.bookCount);
    }
}
