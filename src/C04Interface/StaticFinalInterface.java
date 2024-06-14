package C04Interface;

public class StaticFinalInterface {
    public static void main(String[] args) {
        MyInterface m1 = new MyInterface(){};
        m1.methodA();

//        MyImplements에 my_constant변수가 상속(static 변수)
        System.out.println(MyImplements.my_constans);
    }
}

interface MyInterface{
//     아래 변수는 컴파일 타임에 static final 키워드가 붙음
    int my_constans = 10;
    default void methodA(){

    }
}

class MyImplements implements MyInterface{

    @Override
    public void methodA() {
        System.out.println("hello world");
    }
}

