package C10Annotation;

// 자바의 runtime inflection이 어떻게 구현되는지 알아보는 시간~
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class C10ReflectionBasic {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
//        ⭐객체생성방법 1⭐. 기존의 방식과 메서드 호출
        Calculator calculator = new Calculator("samsung");
        calculator.sayHello();

//        ⭐객체생성방법 2⭐. 런타임 환경에서 리플랙션 기술을 통해 객체 생성 및 메서드 호출
//        <?> : 제네릭 표현으로 어떤 클래스타입도 가능하다는 표현
//        getClass메서드는 런타임시점에 calculator라는 객체의 타입을 가져오는 메서드
        Class<?> myClass = calculator.getClass();
//        ⭐객체생성2-1)
        Calculator cal1 = (Calculator) myClass.getConstructor(String.class).newInstance("samsung");
//        메서드 생성
        Method cal1Method = myClass.getMethod("sayHello");
        cal1Method.invoke(cal1);


//        객체생성2-2)
        Calculator cal2 = Calculator.class.getConstructor(String.class).newInstance("Casio");
//        메서드생성
        Method cal2Method = Calculator.class.getMethod("sayHello");
        cal2Method.invoke(cal2);

//        객체생성 및 접근을 자바에게 위임한 상황.
//        현재 프로그램이 실행중인 런타임 상황에서, 어떻게 업데이트를 실시간으로 수정해서 보여줄 수 있을까? 에 대한 것.
//


//        리플렉션 기술을 통해 필드 접근 및 수정
        Field nameField = Calculator.class.getDeclaredField("name");
        nameField.setAccessible(true); // 접근 가능하도록 권한 설정
        nameField.set(cal1, "Casio");

        cal1Method.invoke(cal1);

    }
}

class Calculator{
    private String name;

    public Calculator(){

    }

    public Calculator(String name){
        this.name = name;
    }

    public void sayHello(){
        System.out.println(this.name+" 환영합니당.");
    }
}
