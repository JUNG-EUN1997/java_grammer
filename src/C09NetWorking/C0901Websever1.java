package C09NetWorking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class C0901Websever1 {
    public static void main(String[] args) throws IOException {

//        socket이란 서버와 사용자가 통신을 하기 위한 네트워크 통신의 끝점을 나타내는 개념
        ServerSocket serverSocket = new ServerSocket(8081); // port는 시중에 약속되어있는 것은 사용하면 안된다
//                   원래는 try catch로 예외처리 해줘야하는게 맞음

        System.out.println("8081 서비스 시작");
        while (true){
//            accept() : 클라이언트의 연결 요청을 수락
            Socket socket = serverSocket.accept();
            String httpResponse = "HTTP/1.1 200 OK\r\n\r\n"+"hello world";
//             UTF_8 문자열로 return 한다. : 한글return
            socket.getOutputStream().write(httpResponse.getBytes(StandardCharsets.UTF_8));
//            flush() : 변경사항 확정 및 반영
            socket.getOutputStream().flush();
            socket.close();
        }


    }
}
