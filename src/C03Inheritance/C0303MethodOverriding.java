package C03Inheritance;

public class C0303MethodOverriding {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.sound2();

//        상속관계일 때, [부모] [클래스] 타입을 [자식] 클래스 [객체] 타입으로 지정가능
//        animal 클래스에 정의된 메서드만 사용 가능하도록 제약 발생
        Animal dog2 = new Dog();
//        dog2.sound2(); // Dog 클래스에 정의된 메소드 사용 불가

//        Dog animal = new Animal();
    }
}

class Animal{
    void sound(){
        System.out.println("동물의 소리~");
    }
}

class Dog extends Animal{
    void sound(){
        System.out.println("멍멍");
    }
    void sound2(){
        System.out.println("왈왈이");
    }
}
class Cat extends Animal {
    void sound(){
        System.out.println("야옹");
    }
}
