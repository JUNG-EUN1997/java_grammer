package C01Basic;

public class C1102StackFunction2 {
    public static void main(String[] args) {
        System.out.println("main함수 시작");
        function1(1);
        System.out.println("main함수 끝");
    }
    static int function1(int a){
        System.out.println("function1 함수 시작");
        System.out.println("function1 함수 끝");

//        자기자신을 계속 호출하면, 스택오버플로우(메모리가 풀로 찬다)
        return function1(a+1);
    }
}
