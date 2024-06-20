package C09NetWorking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class C0902Websever2 {
    public static void main(String[] args) throws IOException {

//        socket이란 서버와 사용자가 통신을 하기 위한 네트워크 통신의 끝점을 나타내는 개념
        ServerSocket serverSocket = new ServerSocket(8081); // port는 시중에 약속되어있는 것은 사용하면 안된다
//                   원래는 try catch로 예외처리 해줘야하는게 맞음

        System.out.println("8081 서비스 시작");
        while (true){
//            accept() : 클라이언트의 연결 요청을 수락
            Socket socket = serverSocket.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null && !line.isEmpty()){
                sb.append(line).append("\n");
            }
            String requestString = sb.toString();
            String firstLine = requestString.split("\n")[0];
            String infos = firstLine.split(" ")[1];
            System.out.println(infos);
            String id = "";
            String name = "";
            if(infos.contains("?")){
                String st1 = infos.split("\\?")[1];
                String[] stArr = st1.split("&");
                for (String s : stArr){
                    String[] keyValue = s.split("=");
                    if(keyValue[0].equals("id")){
                        id = keyValue[1];
                    }
                    if(keyValue[0].equals("name")){
                        name = keyValue[1];
                    }
                }
            }
            System.out.println(id + " " + name);
            String httpResponse = "HTTP/1.1 200 OK\r\n\r\n"+"hello world server2";
//             UTF_8 문자열로 return 한다. : 한글return
            socket.getOutputStream().write(httpResponse.getBytes(StandardCharsets.UTF_8));
//            flush() : 변경사항 확정 및 반영
            socket.getOutputStream().flush();
            socket.close();
        }


    }
}
