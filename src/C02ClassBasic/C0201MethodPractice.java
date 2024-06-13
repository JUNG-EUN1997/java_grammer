package C02ClassBasic;

public class C0201MethodPractice {
    public static void main(String[] args) {
        boolean checker = numberChecker(6);
        if (checker) {
            System.out.println("소수입니다");
        }else{
            System.out.println("거짓입니다.");
        }
    }

    public static boolean numberChecker(int num) {
        boolean result = true;
        for(int i = 2; i*i < num; i++) {
            if (num % i == 0) {
                return false; // return 만나면 강제 종료하기 때문에 return 사용
            }
        }
        return result;
    }
}
