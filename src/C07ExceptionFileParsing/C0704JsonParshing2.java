package C07ExceptionFileParsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

public class C0704JsonParshing2 {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Path filePath = Paths.get("src/C07ExceptionFileParsing/test_data2.json");
        String jsonString = Files.readString(filePath);
        ArrayList<Student> list = new ArrayList<>();
        System.out.println(jsonString);
        System.out.println();
        System.out.println();

//        ⭐방법 1 ⭐ : enhance for문 사용 하기
        JsonNode data1 = objectMapper.readTree(jsonString);
        for (JsonNode j : data1){
            Student studentMap3 = objectMapper.treeToValue(j, Student.class); // 이거 하면 뒤에 .toString안해도 ㅇㅋ!
//            Student studentMap3 = objectMapper.readValue(j.toString(), Student.class);
            list.add(studentMap3);
        }
        System.out.println(list);

//        ⭐방법 2 ⭐ : Iterator 사용하기
        ArrayList<Student> listB = new ArrayList<>();
        Iterator<JsonNode> itr = data1.elements();
        while( itr.hasNext()) {
            JsonNode obj = (JsonNode) itr.next();
            Student studentMap3 = objectMapper.readValue(obj.toString(), Student.class);
            listB.add(studentMap3);
        }
        System.out.println(listB);

    }
}
