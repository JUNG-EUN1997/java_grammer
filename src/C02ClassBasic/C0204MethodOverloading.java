package C02ClassBasic;

public class C0204MethodOverloading {

    public static void main(String[] args) {
        System.out.println(sum(1,2));
    }

    static int sum(int a, int b) {
        return a + b;
    }

//    접근제어자 추가X 시, 기본적으로 default 접근제어자.
//    default : 같은 패키지 내 에서만
//    private : 같은 클래스 내 에서만
//    public : 모든 공간에서
}
