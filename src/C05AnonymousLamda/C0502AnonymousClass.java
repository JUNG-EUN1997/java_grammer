package C05AnonymousLambda;

import java.util.*;

public class C0502AnonymousClass {
    public static void main(String[] args) {

//        AbstractAnimal을 상속한 클래스가 별도로 존재하지 않고,
//        익명의 클래스가 만들어짐과 동시에 익명개체가 생성된다.
//        AbstractAnimal a1 = new AbstractAnimal() {
//            @Override
//            void makeSound2() {
//
//            }
//        };
//
////        익명객체에 구현메서드가 1개밖에 없을 때에 람다표현식(화살표함수)로 표현가능
////              > 내가~~ 어?! 여기 안에있는거 아니까 함수명 안 써도 삽가능이야~
//        Animal a2 = new Animal() {
//            @Override
//            public void makeSound() {
//                System.out.println("익명개체다~");
//            }
//        };
////        a2.makeSound();
//
////        줄이는 방법
////        ()부분에 매개변수를 지정
////        변수의 개수 및 순서를 맞춰서 지정 해야 함
//        Animal a22 = () -> System.out.println("람다 익명 이다~");
//        a22.makeSound();
//
//
////        익명개체 생성 후 input1,2,3 를 다 합쳐서 출력하는 메소드 정의
////        실행문이 1줄 일 때, return 생략 가능, 단 2줄 이상일 때 return 처리 필요
//        Animal2 a3 = new Animal2() {
//            @Override
//            public String makeSound(String a, String b, int c) {
//                return (a  + b + c);
//            }
//        };
//        System.out.println(a3.makeSound("zz","bb",3));
////        Animal2 a4 = (a, b, c) -> c > 10 ? a : b;
//        Animal2 a4 = new Animal2() {
//            @Override
//            public String makeSound(String a, String b, int c) {
//                if(c > 10){
//                    return a;
//                }else{
//                    return b;
//                }
//            }
//        };
//        System.out.println(a4.makeSound("A입니당","B입니당",100));
//        System.out.println(a4.makeSound("A입니당","B입니당",7));

//        List<String> myList = new ArrayList<>();
//        myList.add("java");
//        myList.add("python");
//        myList.add("javascript");
//        Collections.sort(myList); // Comparable의 compareTo 메서드를 구현하여 정렬
//        System.out.println(myList);
//        Collections.sort(myList, Comparator.reverseOrder());
//        System.out.println(myList);
//        Collections.sort(myList,Comparator.naturalOrder());
//        System.out.println(myList);

        List<Student> students = new ArrayList<>();
        students.add(new Student("홍길동",16));
        students.add(new Student("성춘향",20));
        students.add(new Student("흥부",54));
        students.add(new Student("놀부",56));
        students.add(new Student("두껍이",2));
//        ⭐방법1.⭐ Student객체에서 Comparable을 구현 => comparaTo 메서드를 오버라이딩
        Collections.sort(students);
//        for (Student i : students) {
//            System.out.println(i.getName() + " " + i.getAge());
////            System.out.println(i.getName());
//        }
        System.out.println(students);

//        ⭐방법2.⭐ Comparator를 구현한 익명객체를 sort에 주입
//        Comparator<Student> myComparator = new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o2.getAge() - o1.getAge(); // o1이랑 o2랑 비교하겠다!
//            }
//        };
//        students.sort(myComparator);

//        ⭐방법2-1.⭐ Comparator를 구현한 익명객체를 sort에 주입 >> 람다식 변형
//        아니 여기 안에 Comparator만 들어갈줄 어떻게 알구 이것만 씀?
//              >> 이미 정해져있는 규칙 : 넣거나 아예 넣지 않거나
//        students.sort((o1, o2) -> o2.getAge() - o1.getAge());
//        for (Student i : students) {
//            System.out.println(i.getName() + " " + i.getAge());
////            System.out.println(i.getName());
//        }

//        아래 문자열을 글자길이 순서로 내림차순 정렬하여라
        String[] stArr = {"hello","java","world2","C++"};
        Arrays.sort(stArr,(o1, o2) -> o2.length() - o1.length());
//        System.out.println(Arrays.toString(stArr));


//        [4,5][1,2][5,0][3,1]
//        위 배열이 들어간 아래 리스트를 배열의 0번째가 아닌 1번째의 기준으로 내림차순 정렬
        List<int[]> myList = new ArrayList<>();
        myList.add(new int[]{4,5});
        myList.add(new int[]{1,2});
        myList.add(new int[]{5,0});
        myList.add(new int[]{3,1});
        myList.add(new int[]{4,1});
        myList.sort((o1, o2) -> {
            if(o2[1] == o1[1]){
                return o2[0] - o1[0];
            }
            return o2[1] - o1[1];
        });


        for (int[] i :myList) {
            System.out.print(Arrays.toString(i) + " " +i[1]);
            System.out.println();
        }

    }
}

class Student implements Comparable<Student>{ // Comparable의 Target Object를 알려주는 형식
    String name;
    int age;
    Student(String name, int age){
        this.name = name;
        this.age = age;
    };

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

//    모든 클래스의 조상클래스인 Object 클래스의 toString 메서드를 Overriding 하여
//    객체 호출시에 자동으로
    @Override
    public String toString(){
        return this.name + " " + this.getAge();
    }


    @Override
    public int compareTo(Student s) { // 비교할 대상이 나 자신인 오브젝트
//        return this.age - s.getAge(); // 1 > 10 오름차순
//        return this.age - s.getAge(); // 10 > 1 내림차순
//        return this.name.compareTo(s.getName()); // ㄱ > ㅎ 오름차순
        return s.name.compareTo(this.getName()); // ㅎ > ㄱ 내림차순
    }



}

interface Animal{
    void makeSound();
}

interface Animal2{
    default String makeSound(String a, String b, int c){
        return a+b+c;
    };
}

abstract class AbstractAnimal{
    void makeSound1(){

    }

    abstract void makeSound2();
}