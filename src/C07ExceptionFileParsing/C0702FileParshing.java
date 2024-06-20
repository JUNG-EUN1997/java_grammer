package C07ExceptionFileParsing;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class C0702FileParshing {
    public static void main(String[] args) throws IOException {

//        콘솔에서 읽기
//        io패키지 사용
//        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
//        String input = br1.readLine(); // 한줄을 읽기
//        System.out.println(input);


//        파일에서 읽기
//        방법 1 : Path로 읽기
//        Path path = Paths.get("src/C07ExceptionFileParsing/test_file.txt");
//        try (Stream<String> lines = Files.lines(path)) {
//            lines.forEachOrdered(System.out::println);
//        } catch (IOException e) {
//            System.out.println("끝!");
//        }
//
//        System.out.println();
//
////        방법2 : BufferedReader로 읽기
//        BufferedReader br2 = new BufferedReader(new FileReader("src/C07ExceptionFileParsing/test_file.txt"));
//        String line;
//        while ((line = br2.readLine()) != null){
//            System.out.println(line);
//        }

//        결론
        /*
        * 효율성 비교
메모리 사용 측면 : BufferedReader 👍 | Path 👎
성능 측면: 일반적으로 BufferedReader가 더 빠릅니다. 특히 큰 파일을 읽을 때는 버퍼를 사용하기 때문에 성능이 향상됩니다.
코드 간결성: Files.lines()가 더 간결하고 사용하기 편리합니다.
결론
작은 파일을 간단하게 읽을 때는 Files.lines(path)를 사용하는 것이 편리합니다.
큰 파일을 효율적으로 읽어야 하거나, 메모리 사용량을 최소화하고자 할 때는 BufferedReader를 사용하는 것이 좋습니다.
        * */



//        System.out.println(br2.readLine());
//        System.out.println(br2.readLine());
//        try (Stream<String> lines = br2.readLine().lines()) {
//            lines.forEachOrdered(System.out::println);
//        } catch (IOException e) {
//            //error happened
//            System.out.println("끝!");
//        }



//        NIO 패키지를 이용한 경우
//        Path filePath = Paths.get("src/C07ExceptionFileParsing/test_file.txt");
//        try { // try catch하면 상단에 throw 안해도 ㅇㅋ
////        문자열 통째로 read
//            String st1 = Files.readString(filePath);
//            System.out.println(st1);
//
////        문자열을 각 라인을 잘라 list 형태로 read
//            List<String> st2 = Files.readAllLines(filePath);
//            for (String s : st2) {
//                System.out.println(s + " 선수");
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }



//        파일쓰기
//        append(추가) | write(덮어쓰기)
//        create_new(생성) |
        Path filePath = Paths.get("src/C07ExceptionFileParsing/write_file.txt");

        if (Files.exists(filePath)){
            Files.write(filePath, "홍길동\n".getBytes(),StandardOpenOption.APPEND);
        }else{
            Files.write(filePath, "".getBytes(), StandardOpenOption.CREATE_NEW);
        }


//        객체 > JSON :: 직렬화(
//        JSON > 객체 :: 역직렬화(파싱)
//        readTree, readValue




    }
}
