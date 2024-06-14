package C03Inheritance;


// extends 키워드를 통해 상속관계를 표현
public class C0301Inheritance extends Parents {

    int c = 30;
    public static void main(String[] args) {
//        System.out.println(a); // 인스턴스 변수이기 때문에 출력불가
//        System.out.println(c);

        C0301Inheritance c1 =  new C0301Inheritance();
        System.out.println(c1.c);
        System.out.println(c1.a);

    }

}
class Parents{
    public int a = 10;
    void parentMethod(){
        System.out.println("부모 클래스입니다.");
    }
}

