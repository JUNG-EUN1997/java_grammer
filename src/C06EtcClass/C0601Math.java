package C06EtcClass;

public class C0601Math {
    public static void main(String[] args) {
//        0.0 ~ 1.0미만의 임의의 double형을 반환
        double randomValue = Math.random();
        for (int i = 0; i < 7; i++) {
            int random = (int) (Math.random() * 100);
            System.out.println(random);
        }


//        abs() : 절대값 반환
        System.out.println(Math.abs(-5)); // 5


//        ceil() : 올림,  floor() : 내림,  round() : 반올림
        System.out.println(Math.ceil(5.1));
        System.out.println(Math.floor(5.6));
        System.out.println(Math.round(5.6));


//        min, max : 둘 중 작은것 혹은 큰것
        System.out.println(Math.max(5,8));
        System.out.println(Math.min(5,8));


//        pow() : 제곱
        System.out.println(Math.pow(5,2));

//        sqrt() : 제곱근
        System.out.println(Math.sqrt(2));
        int n=100;
        for(int i=2; i<Math.sqrt(n); i++){
            if(n % i==0){
                System.out.println("소수가 아닙니다.");
                break;
            }
        }

    }
}
