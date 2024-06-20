package C07ExceptionFileParsing;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class C0705JsonParshing3 {
    public static void main(String[] args) throws IOException, InterruptedException {
//        Spring에서는 RestTemplate를 통해 Http를 요청
//        JAVA에서는 http 클라이언트 사용
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String posts = response.body();
        System.out.println(posts);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode data1 = objectMapper.readTree(posts);
        ArrayList<Post> postArray = new ArrayList<>();
        for (JsonNode j : data1) {
            postArray.add(objectMapper.treeToValue(j, Post.class));
        }

//        ⭐직렬화 하기⭐ JSON으로 제작하기 /  객체 > JSON (직렬화)
//        리스트 형식도 직렬화가 가능
//        여러 단계가 겹쳐있는 단계로 되어있을 때, 최상위 단계만 해당 처리 진행해주면 된다.
        String postJson = objectMapper.writeValueAsString(postArray);

        System.out.println(postArray);
    }
}

class Post{
    @Override
    public String toString(){
        return "\n아이디 : "+this.getId()+"\n제목 : "+this.getTitle()+"\n";
    }

    private int userId;
    private int id;
    private String title;
    private String body;

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }


}
