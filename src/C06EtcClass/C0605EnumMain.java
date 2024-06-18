package C06EtcClass;

public class C0605EnumMain {
    public static void main(String[] args) {
        EnumStudent s1 = new EnumStudent();
        s1.setName("hong1");
        s1.setClassGrade(ClassGrade.c1); // Enum을 사용하지 못할 때 이렇게도 할 수 있음

        EnumStudent s2 = new EnumStudent();
        s2.setName("hong1");
        s2.setClassGrade("second_gg"); // 단, ClassGrade를 거치는 것이 필수가 아니기 때문에, 실수 가능

//        Enum설정 시, 위의 실수를 방지할 수 있음! 😊
        s2.setRole(Role.ADMIN_USER); // enum class인 Role 안에 있는 값으로 만 선택 가능

        System.out.println(s2.getRole());
        System.out.println(s2.getRole().getClass());
//        enum값 내부에는 저장된 순서대로 0부터 index값이 내부적으로 할당 된다.
        System.out.println(s2.getRole().ordinal());



    }
}
class ClassGrade{
    static final String c1 = "first_grade";
    static final String c2 = "second_grade";
    static final String c3 = "third_grade";
}

enum Role{
//    각 열거형 상수는 콤마로 구분.  상수 목록 끝 ;(세미콜론)으로 구분
//    static final이 생략되어있는 형식이라고 생각
//    숫자로 입력하는 것은 좋지 않다. 문자로 작성 하여 넣는 것이 좋다.
    GENERAL_USER, ADMIN_USER;
}

class EnumStudent{
    private String name;
    private String classGrade;

    public Enum<Role> getRole() {
        return role;
    }

    public void setRole(Enum<Role> role) {
        this.role = role;
    }

    private Enum<Role> role;

    public String getClassGrade() {
        return classGrade;
    }

    public void setClassGrade(String classGrade) {
        this.classGrade = classGrade;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
