package C07ExceptionFileParsing.AuthorException;

import java.util.Scanner;

//사용자와 가장 가까이 있는 곳
public class AuthorController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AuthorService authorService = new AuthorService();
        while (true){
            System.out.println("원하시는 서비스 번호를 호출하세요. 1) 회원가입 / 2) 로그인");
            try {
                int serviceNum = Integer.parseInt(sc.nextLine());
                if(serviceNum == 1){
//                    회원가입
                    System.out.println("성함을 입력하세요.");
                    String name = sc.nextLine();
                    System.out.println("이메일을 입력하세요.");
                    String email = sc.nextLine();
                    System.out.println("비밀번호를 입력하세요.");
                    String password = sc.nextLine();
                    Author author = new Author(name,email,password);
                    System.out.println(author);
                }else if(serviceNum == 2){
//                    로그인
                    System.out.println("이메일을 입력하세요.");
                    String email = sc.nextLine();
                    System.out.println("비밀번호를 입력하세요.");
                    String password = sc.nextLine();
                    authorService.login(email, password);
                }else{
                    System.out.println("옳지 않은 서비스 번호입니다.");
                    continue;
                }
            }catch (NumberFormatException e){
                System.out.println("알맞은 숫자 값을 입력하세요.");
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("예외가 발생했습니다.");
            }
        }
    }
}
