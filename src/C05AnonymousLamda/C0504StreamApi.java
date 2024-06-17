package C05AnonymousLamda;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class C0504StreamApi {
    public static void main(String[] args) {
//        int[] arr = {20,40,4,12};
////        전통적인 방식의 데이터 접근방식 : 메모리주소 접근방식
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }

//        함수형 프로그래밍 방식 : 데이터 객체 중심이 아닌, 입력에 따른 출력만 존재
//        장점 : 데이터 안정성 증가

//        JAVA에서 함수형프로그래밍을 지원하기위한 라이브러리 >> streamAPI
//        forEach : stream의 각 요소를 소모하면서 동작을 수행
//        Arrays.stream(arr).forEach(System.out::println);


//        스트림의 생성
//        String[] stArr = {"HTML", "CSS", "JAVA", "PYTHON"};
////        Stream<클래스명> : 제네릭타입으로 stream객체가 생성 >> 꺽새(<>)를 제네릭이라고 함
//        Stream<String> stream1 = Arrays.stream(stArr);
//        List<String> stList = new ArrayList<>(Arrays.asList(stArr));
//        Stream<String> stream2 = Arrays.stream(stArr);
//
//        int[] intArr = {10,20,30,40,50};
////        기본형 자료는 별도의 stream 제동
//        IntStream stream3 = Arrays.stream(intArr);
//
//        List<Integer> myList = new ArrayList<>();
//        myList.add(10);
//        myList.add(20);
//        myList.add(30);
//
//        Stream<Integer> stream4 = myList.stream();
//
////        int가 아니라 Integer이기 때문에 IntStream 사용 불가
//        IntStream stream5 = myList.stream();



////        stream 변환(중개연산) : filter, map, sorted, distinct, limit
//        String[] stArr = {"HTML", "CSS", "JAVA", "PYTHON"};
////        filter : 특정기준으로 대상을 filtering 하는 것
////        참조변수 스트림변환의 경우 제네릭의 타입소거 문제 발생
////              제네릭의 타입 소거란 제네릭타입을 런타임시점에는 제거하는것을 의미
////        따라서, 타입이 소건된 stream 객체에서 배열로 변환하려면, 타입이 무엇인지 명시해야함
////        >>> 타입캐스팅
//        String[] newStArr = Arrays.stream(stArr)
//                .filter(a -> a.length() < 4) // 하나씩 나오는 요소들 중 length가 4 이하인 것.
//                // 이부분에서는 stream을 반환하기 때문에 다시 String[]으로 반환해야함.
//                .toArray(a-> new String[a]); // a 변수에는 stream요소의 개수 가 들어온다
//
////        이 방법은 [캐스팅을 사용하는 방법]
////        Object[]를 먼저 생성한 후 이를 String[]로 캐스팅하는데, 이 과정에서 추가적인 캐스팅 연산이 필요하여 성능적으로 떨어짐
////        String[] newStArr2 = (String[]) Arrays.stream(stArr).filter(a -> a.length() < 4).toArray();
//
////        (일반적인 방식) 메소드 참조 방식 > 매개변수가 ((추론 가능할 때)) 생략하는 방식 >> 클래스 :: 메서드
//        String[] newStArr3 = Arrays.stream(stArr)
//                .filter(a -> a.length() < 4)
//                .toArray(String[]::new);
//
//        int[] intArr = {10,10,30,40,50};
//        int[] newIntArr = Arrays.stream(intArr).filter(a->a<=30).toArray();
//        System.out.println(Arrays.toString(newIntArr));
//
//
////        distinct : 중복제거
//        int[] newIntArr2 = Arrays.stream(intArr).distinct().toArray();
//        System.out.println(Arrays.toString(newIntArr2));
//        int total = Arrays.stream(intArr).sum();
//        System.out.println(total);
//
//
////        map : 기존의 스트림을 조작하여 새로운 스트림 반환
//        int[] newMapArr = Arrays.stream(intArr).map(a->a*10).toArray();
//        System.out.println(Arrays.toString(newMapArr));

//        홀수찾기
//        int[] arr1 = {1,2,3,4,5};
////        홀수만 담은 후 배열의 값을 제곱한 새로운 배열생성하고 오름차순 정렬
//        int[] result = Arrays.stream(arr1).filter(a -> a%2 == 1).map(a -> a*a).sorted().toArray();
//        System.out.println(Arrays.toString(result));




//      mapToInt : StringStream을!!! intstream 형태로 변환해주는 map
//        String[] stArr = {"HTML", "CSS", "JAVA", "PYTHON"};
////        각 문자열의 길이를 담은 새로운 int배열 생성
//        int[] wordCount = Arrays.stream(stArr).mapToInt(String::length).toArray();
//        System.out.println(Arrays.toString(wordCount));
//        int[] intArr6 = Arrays.stream(stArr).mapToInt(String::length).limit(2).toArray();
//        System.out.println(Arrays.toString(intArr6));



//      ----------------------------------------------------------------------------------------------- 스트림의 중개연산 끝
//      ----------------------------------------------------------------------------------------------- 스트림의 소모 시작


//        스트림의 소모 -> sum : 합계 / reduce : 누적합계 / foreach : 출력  등등
//        int[] intArr = {10,20,30,40};
////        Arrays.stream(intArr).forEach(System.out::println);
//        int intArrSum = Arrays.stream(intArr).sum();
////        optional객체 : 값이 있을 수 있고 없을 수 있음을 명시한 객체
//        int intArrMax = Arrays.stream(intArr).max().getAsInt(); // getAsInt는, 없다면 오류남!
//        int intArrMin = Arrays.stream(intArr).min().getAsInt();
//        int intArrCount = (int) Arrays.stream(intArr).count();
//
//        int allMultiply = Arrays.stream(intArr).reduce(1,(a,b) -> a*b); // 초기값을 1로 세팅하고, 앞과 뒤의 값을 곱한다!
//        int allAdd = Arrays.stream(intArr).reduce(0,(a,b) -> a+b);
////        System.out.println(allMultiply);
////        System.out.println(allAdd);
//
//
////        findFirst : 첫번째요소 반환
//        List<Student> students = new ArrayList<>();
//        students.add(new Student("홍길동",16));
//        students.add(new Student("성춘향",20));
//        students.add(new Student("흥부",54));
//        students.add(new Student("놀부",56));
//        students.add(new Student("두껍이",2));
//
////        나이가 30이 넘는 학생 중 첫번째 index 가지는 학생 객체 생성
//        Student s1 = students.stream().filter(a -> a.getAge() >=30).findFirst().get();
//
////        Student 객체 실습
////        - 모든 객체의 평균나이
//        int avgAge = (int) students.stream().mapToInt(Student::getAge).average().getAsDouble();
//        System.out.println(avgAge);
////        1) 나이만 전부 꺼내 stream객체로 만든다
////        2)
//
////        2. 가장 나이 어린사람 찾기
//        Student s2 = students.stream().sorted((a,b)->a.getAge() - b.getAge()).findFirst().get();
//        System.out.println(s2.getName());
////        3. 30대의 이름을 String 배열에 담기
////        String[] nameArr = students.stream().filter(a-> a.getAge() >= 30).map(a->a.getName()).toArray(a->new String[a]);
//        String[] nameArr = students.stream().filter(a-> a.getAge() >= 30).map(Student::getName).toArray(String[]::new);
//        System.out.println(Arrays.toString(nameArr));




//        Optional객체 : 특정객체에 값이 없을지도 모른다는 것을 명시적으로 표현
//                    : 객체를 생성할 경우는 거의 없음
//        ofNullable : null이 있을 수 도 있는경우에는 Optional객체를 생성하는 메서드


//        String st1 = "1";
//        Optional<String> opt1 = Optional.ofNullable(st1);
//        if (opt1.isPresent()) {
//            System.out.println(opt1.get().compareTo("hello"));
//        }else{
//            System.out.println("값이 없습니다.");
//        }

//        Optional 객체 생성법 3가지
//        Optional<String> opt1 = Optional.empty();
//        Optional<String> opt2 = Optional.of("hello"); // 값이 반드시 존재해야함 > null이 못 들어감
//        Optional<String> opt3 = Optional.ofNullable(null); // 값이 존재하거나 없을 수 있음 > nulld이 들어갈 수 있음
////        Optional<String> opt4 = Optional.ofNullable(null);
//
//
//
////        Optional객체 처리방법 4가지
////        ⭐방법 1.⭐ isPresent() 확인 후 get();
//        if (opt3.isPresent()){
//            System.out.println(opt3.get().length());
//        }
////        ⭐방법 2.⭐ orElse() : 값이 있다면 있는 값 return, 없다면 지정 값 return
//        System.out.println(opt3.orElse("").length());
//
////        ⭐방법 3.⭐ orElseGet() : 값이 있다면 있는 값 return, 없다면 람다함수 실행
//        System.out.println(opt3.orElseGet(()->new String("")).length());
//
////        ⭐방법 4.⭐ orElseThrow() : ⭐가장 중요⭐ 값이 있다면 있는 값 return, 없으면 지정된 강제
////                    : 개발에서 예외를 사용자에게 적절한 메세지 전달 목적으로 ((강제 발생))시키는 경우도 존재
//        System.out.println(opt3.orElseThrow(()-> new NoSuchElementException("값이 없습니다.")).length());


        List<Student> students = new ArrayList<>();
        students.add(new Student("kim", 20));
        students.add(new Student("kim1", 21));
        students.add(new Student("kim2", 23));
        students.add(new Student("kim3", 25));
//        방법1
//        return type 이 null일 수도 아닐 수도 있어서 : OptionalDouble
        OptionalDouble answer = students.stream()
                .filter(a->a.getAge()>=29)
                .mapToInt(a->a.getAge()).average();
        if(answer.isPresent()){
            System.out.println(answer.getAsDouble());
        }else {
            System.out.println("값이 없습니다.");
        }
        System.out.println(answer);


//        방법2 : ⭐추천 방법⭐
        double answer2 = students.stream()
                .filter(a->a.getAge()>=29).mapToInt(a->a.getAge()).average()
                .orElseThrow(()->new NoSuchElementException("값이 없습니다.")); // 꺼내짐과 동시에 없다면 예외터지기!!!! ⭐⭐

    }
}