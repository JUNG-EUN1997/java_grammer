package C03Inheritance;

// 추상클래스와 인터페이스의 차이
// 추상클래스 : 구현되어있지 않은 메서드 + 구현되어있는 메서드
// 인터페이스 : 구현되어있지 않은 메서드

//public class C0305Others extends FinalParents{ >> 상속불가
public class C0305Others {
    public static void main(String[] args) {
        AbstractDog dog = new AbstractDog();
//        추상클래스와 인터페이스는 **구현없이 객체생성 불가**


        AbstractAnimail animail = new AbstractAnimail() {

//           익명객체
            @Override
            void makeSound3() {

            }
        };
//        익명



    }
}

// final 클래스 : 상속 불가한 클래스
//              >> 잘 사용하지 않음
final class FinalParents{ }

abstract class AbstractAnimail {
    void makeSound1(){
        System.out.println("동물소리~");
    }

//    final 메소드 : 상속 불가 메소드
    final void makeSound2(){

    }

//   (추상클래스)
//    abstract  : 자식클래스가 반드시 오바라이딩 하여야 함
//               >> abstract(추상)메서드 존재 시, 클래스에도 abstract 키워드 추가 필수
    abstract void  makeSound3();
}

class AbstractDog extends AbstractAnimail{

//    @Override  >> 타겟인 makeSound2가 final이여서 상속불가
//    void makeSound2(){
//
//    }

    @Override
    void makeSound3() {

    }

}