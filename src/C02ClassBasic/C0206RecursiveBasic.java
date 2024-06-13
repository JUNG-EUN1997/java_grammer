package C02ClassBasic;

import java.util.Arrays;

public class C0206RecursiveBasic {
    public static void main(String[] args) {
//        1-10까지 for문으로 누적 합계
//        sum(1);
        int total = 0;
        for (int i = 0; i <= 10 ; i++) {
            total += i;
        }
//        System.out.println(total);
//        System.out.println();
//        System.out.println(addAcc(10));
        fibonacciForType(10);
    }

//    피보나치 수열 구현
//    1 1 2 3 5
    static void fibonacciForType(int loop){
        int[] arr = new int[loop];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < loop; i++) {
            arr[i] = arr[(i-1)] + arr[(i-2)];
        }
        System.out.println(arr[loop-1]);
//        System.out.println(Arrays.toString(arr)); // 전체 array 보기
    }

//    식 자체는 굉장히 직관적이라는 장점
//    하지만 굉장히 비효울적, 중복적인 값을 또 다시 불러온다.
//    하지만 그런 사태를 해결하기 위해 메모라이즈 기법(dp) 기법을 추가로 사용한다.
    static int fibonacciFecursiveType(int a){
        if(a<=2){
            return 1;
        }
        return fibonacciFecursiveType(a-1) + fibonacciFecursiveType(a+2);
//        int[] arr = new int[a];
//        arr[0] = 1;
//        arr[1] = 1;
//        for (int i = 2; i < a; i++) {
//            arr[i] = arr[(i-1)] + arr[(i-2)];
//        }


    }


    static int addAcc(int n){
        if(n == 1){
            return 1;
        }
        return n+addAcc(n-1);
    }
}
