package C02ClassBasic;

public class C0201Method {
//        메소드를 사용하는 이유
//        1) 코드의 기능 재활용을 위함
//        2) 코드의 중복이 발생하는 것을 방지하기 위함
    public static void main(String[] args) { // >> 이 부분이 main method
        System.out.println(sumAcc(1,10));
        System.out.println(sumAcc(100,200));
    }

//     함수 및 변수명은 대문자로 시작하지 않고 camelcase로 시작한다.
//     int라는 return 타입을 가는 method
//    method 구성요소 : 매개변수, 리턴타입, 접근제어자(public,private), 클래스메서드여부(static)
    static int sumAcc(int start, int end){ // ()괄호 내부는 매개변수
        int total = 0;
        for (int i = start; i <= end; i++) {
            total+=start;
        }
        return total;
    }
}
