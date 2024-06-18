package C06EtcClass;
// 제네릭 <> 가 대체 뭐하는 놈일까?! 🤔

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C0603GenericMain {
    public static void main(String[] args) {
        String[] stArr = {"java","python","C","C#"};

        genericCange(stArr,0,1); // 0번이랑 1번이랑 자리 바꿔줘!
        System.out.println(Arrays.toString(stArr));

        Integer[] intArr = {1,2,3};
//        던지는 array의 타입으로 받아지는 generic 타입!
        genericCange(intArr,0,1);
        System.out.println(Arrays.toString(intArr));


        GenericPerson<String> p1 = new GenericPerson();
        p1.setValue("gggg");
        System.out.println(p1.getValue());

        GenericPerson<Integer> p2 = new GenericPerson();
        p2.setValue(22222);
        System.out.println(p2.getValue());

//        제네릭 사용(소거)
        List<String> myList = new ArrayList<>();
        myList.add("hello");
        myList.add("hello1");

//        컴파일 후 제네릭인 <String>이 소거된다.
//              실행 시점에 Object로 해버려서, 실행 시점에 Integer로 박아버릴 수 있다~!
//        List myList = new ArrayList<>();
//        myList.add("hello");
//        myList.add("hello1");






    }


//    제네릭메서드 생성 : 반환타입 왼쪽에 <T> 선언
//                                   <A> 등 아무 숫자나 들어와도 ㅇㅋ! > 중요한 것은, 꺽새 안에 어떠한 값이 들어오는 것
//          ⭐유의점⭐ : 제네릭은, 객체 타입이 들어와야함.

    static <T>void genericCange(T[] stArr, int start, int end){
        T temp = stArr[start];
        stArr[start] = stArr[end];
        stArr[end] = temp;
    }




}


class Person {
    String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

//제네릭 클래스는, 클래스명 옆에 <T> 선언
class GenericPerson<T> {
    T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}