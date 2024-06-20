package C09NetWorking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C0903Webseve3 {
    public static void main(String[] args) throws IOException, SQLException {
        ServerSocket serverSocket = new ServerSocket(8081);

        System.out.println("Webseve3 서비스 시작");
        while (true){
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
            String email = "";
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
                    if(keyValue[0].equals("email")){
                        email = keyValue[1];
                    }
                }
            }

            DBConnect dbConnect = new DBConnect();

            String whereSQL = "";

            if(!id.isEmpty()){
//                name, email, password 응답
                whereSQL = "id="+id;
            }else if(!name.isEmpty() && !email.isEmpty()){
//                name, email, password, id도 함께 응답
                whereSQL = "name="+name+" and email="+email;
            }
            System.out.println(whereSQL);
            if(!whereSQL.isEmpty()){
                dbConnect.getDBUserData(whereSQL);
            }
            String httpResponse = "HTTP/1.1 200 OK\r\n\r\n"+"hello world server2";
//             UTF_8 문자열로 return 한다. : 한글return
            socket.getOutputStream().write(httpResponse.getBytes(StandardCharsets.UTF_8));
//            flush() : 변경사항 확정 및 반영
            socket.getOutputStream().flush();
            socket.close();
        }


    }
}

class DBConnect {
    //        mysql 드라이버 필요
    String url = "jdbc:mysql://localhost:3306/board1?useSSL=false"; // ssl보안을 사용하지 않는다는 뜻
    String userName = "root";
    String password = "1234";
    Connection con = null;

    DBConnect() throws SQLException {
        con = DriverManager.getConnection(url, userName, password);
        System.out.println("DB 연결 성공");
    }

    public void getDBUserData(String whereSQL) throws SQLException {
        Statement st = con.createStatement();
        String myQuery = "SELECT * FROM author WHERE " + whereSQL + ";";
        ResultSet rs = st.executeQuery(myQuery);
        while (rs.next()){
            new User(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("password"));
        }

    }
}

class User {
    int id;
    String name;
    String email;
    String password;

    User(int id, String name, String email, String password){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        UserRepository.register(this);
    }

    public void getUserInfo(int id){
        System.out.println(this.id +"\n" + this.name +"\n" + this.email +"\n" + this.password + " \n 호출 끝!");
    }
}

class UserRepository {
    static List<User> userList;

    UserRepository(){
        userList = new ArrayList<>();
    }

    static void register(User user){
        userList.add(user);
    }
}