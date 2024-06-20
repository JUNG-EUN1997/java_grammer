package C07ExceptionFileParsing;

import java.sql.SQLException;
import java.util.Scanner;

public class C0701Exception {
    public static void main(String[] args) throws SQLException {
//        System.out.println("나눗셈 프로그램입니다.");
//        Scanner sc = new Scanner((System.in));

//        예외가 발생할 것 으로 예산되는 코드에 try로 감싸고
//        예외가 발생했을 때 대응하는 코드를 catch 작성

//        try {
//            System.out.println("분자 입력");
//            int head = Integer.parseInt(sc.nextLine());
//            System.out.println("분모 입력");
//            int tail = Integer.parseInt(sc.nextLine());
//            int result = head / tail;
//            System.out.println("나눈 결과값 >> " + result);
//        }catch (ArithmeticException e){ // ArithmeticException : 수학적으로 잘못된 예외
//            e.printStackTrace(); // printStackTrace : 예외 발생 내역을 로그로 남기기 위함
//            System.out.println("0으로 나누면 안됩니다!");
//        }catch (NumberFormatException e){
////            e.printStackTrace();
//            System.out.println("알맞은 숫자 값을 입력하세요.");
//        }catch (Exception e){ // Exception : 모든 예외의 조상 클래스
////            e.printStackTrace();
//            System.out.println("예외가 발생했습니다.");
//        }finally {
//            System.out.println("무조건 실행!");
//        }
//
//        System.out.println("감사합니당 😊😊");

//        login("1234");
//        login2("1234");

    }



    //        throws와 throw
//    unchecked 예외에서는 throws키워드가 예외사항을 명시하는 용도로만 사용된다.

    static void login(String password) { // unchecked 예외처리
        if (password.length() < 10){
//            throw new : 예외를 강제로 발생
//            예외는 기본적으로 메서드를 호출한 쪽에 번파
//            unchecked 예외는 예외처리가 강제되지 않음
            throw new IllegalArgumentException("비밀번호가 너무 짧습니다.");
        }
    }

//    static void login2(String password) { // checked 예외처리
//        if (password.length() < 10){
////            ⭐방법 1⭐ :  직접 예외처리
////            try {
////                throw new SQLException("DB조회상황에서 오류 발생");
////            }catch (SQLException e){
////                // e = SQLException("DB조회상황에서 오류 발생"); 랑 같은 것.
////                //      >> 지역변수랑은 다른 개념으로 이해해야함
////                System.out.println(e.getMessage());
////                e.printStackTrace();
////            }
//
//        }
//    }



//    ⭐방법 2⭐ : login2 메소드 옆에 throws SQLException 삽입 및, main 메소드 옆에 throws SQLException 추가
    static void login2(String password) throws SQLException {
        if (password.length() < 10){
            throw new SQLException("DB조회상황에서 오류 발생");
        }
    }
}
