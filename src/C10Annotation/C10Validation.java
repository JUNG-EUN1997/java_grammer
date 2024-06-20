package C10Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public class C10Validation {
    public static void main(String[] args) throws IllegalAccessException {
        User user = new User("hong","");
        validate(user);
    }
    static void validate(Object object) throws IllegalAccessException {
        Class<?> myClass = object.getClass();
        Field[] fileds = myClass.getDeclaredFields();
        for (Field f : fileds) {
            if (f.isAnnotationPresent(NotEmpty.class)) {
                f.setAccessible(true); // private
                String value = (String) f.get(object);
                if (value== null || value.isEmpty()) {
                    NotEmpty notEmpty = f.getAnnotation(NotEmpty.class);
                    throw new IllegalArgumentException(notEmpty.message());
                }
            }
        }
    }
}

class User{
    @NotEmpty(message = "name cannot be empty")
    private String name;
    @NotEmpty(message = "email cannot be empty")
    private String email;

    User(String name, String email){
        this.name = name;
        this.email = email;
    }
}

// Annotation 제작 : 특정 필드의 값이 비어있는지 아닌지 검사하는 어노테이션
@Retention(RetentionPolicy.RUNTIME) // RUNTIME에 동작하도록 지정한다.
@Target(ElementType.FIELD) // FIELD: 변수 | METHOD : 메서드 | TYPE : 클래스, 인터페이스 || 그 외 다양한 곳
@interface NotEmpty{
    String message() default "this field can not be empty";
}