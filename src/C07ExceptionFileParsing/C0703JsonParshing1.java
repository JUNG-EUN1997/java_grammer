package C07ExceptionFileParsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class C0703JsonParshing1 {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Path filePath = Paths.get("src/C07ExceptionFileParsing/test_data1.json");

        String jsonString = Files.readString(filePath);
//        System.out.println(jsonString);

//        ⭐방법 1. ⭐ readTree : 트리구조의 JsonNode로 변경된다.
//                  장점 : 유연함
//        JsonNode data1 = objectMapper.readTree(jsonString); // 객체 안에 객체
//        Map<String,String> studentMap = new HashMap<>();
//        studentMap.put("id", data1.get("id").asText());
//        studentMap.put("name", data1.get("name").asText());
//        studentMap.put("classNumber", data1.get("classNumber").asText());
//        studentMap.put("city", data1.get("city").asText());
//        System.out.println(studentMap);

//        ⭐방법 2. ⭐ readValue : 바로 객체로 변환
//        Map studentMap2 = objectMapper.readValue(jsonString, Map.class); // Map.class : Map이라는 클래스를 쓰겠다.
//        System.out.println(studentMap2);

        Student studentMap3 = objectMapper.readValue(jsonString, Student.class); // Map.class : Map이라는 클래스를 쓰겠다.
        System.out.println(studentMap3);

    }
}

class Student{
    private int id;
    private String name;
    private String classNumber;
    private String city;

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString(){
        return "이름 : "+ this.name+ "\n반번호 : "+this.classNumber+ "\ncity : "+this.city+"\n";
    }

//    Student(int id, String name, String classNumber, String city){
//        this.id = id;
//        this.name = name;
//        this.classNumber = classNumber;
//        this.city = city;
//    }
}
