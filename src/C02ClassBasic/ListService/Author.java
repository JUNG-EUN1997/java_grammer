package C02ClassBasic.ListService;
/*
 * 제작해야할 클래스 리스트
 * Author
 * Post
 * */

//[
//        {
//            id : 1,
//            name : 홍길동,
//            email : 머머머.com
//            password : 머머머
//        }
//]

/*
 * 게시판 서비스 만들기
 * 1. 회원가입
 *   Author 클래스
 *   id, name, email, password
 * 2. 회원전체목록조회
 *   id, email 조회
 * 3. 회원상세조회
 *   by id로 조회
 *   id, name, email, password
 * 4. 게시글 작성
 *   Post 클래스
 *   내가 누구인지는 email로 받기 (PK)
 *   id, title, contents, email
 * 5. 게시글목록조회
 *   id, title
 * 6. 게시글상세조회
 *   id, title, contents, 저자(email or nanme or author_id)
 * 7. (선택) 게시글 삭제
 *
 * */

import java.util.*;

public class Author {
    public static void main(String[] args) {
        int serviceNum = 0;
        Scanner sc = new Scanner(System.in);
        Map<Long, User> userAccount = new TreeMap<>();
        User user = null;

        Map<Long, Post> postList = new TreeMap<>();
        Post post = null;
        while (serviceNum < 7) {
            System.out.println("어떤 서비스를 이용하실 예정인가요? 이용하실 서비스의 [번호]를 입력해주세요.");
            System.out.println("1. 회원생성  /  2. 회원전체목록조회  /  3. 회원상세조회  /  4. 게시글 작성  / 5. 게시글목록조회  / 6. 게시글상세조회  /  7. 종료");
//            System.out.println("");
            serviceNum = Integer.parseInt(sc.next());
            System.out.println(serviceNum);

            if (serviceNum == 1) {
                System.out.println("회원가입할 성함, 이메일, 비밀번호를 [띄어쓰기] 기준으로 입력하세요.");
                String userName = sc.next();
                String userEmail = sc.next();
                String userPw = sc.next();
                System.out.println(userName + " " + userEmail + " " + userPw);

                user = new User(userName, userEmail, userPw);
                // user 객체 생성된 버전을 getter 를 톻해 메모리 주소화 함께 TreeMap에 추가!
                userAccount.put(user.getId(), user);
            } else {
                if (user==null) {
                    System.out.println("유저(user)객체가 비어있는 상태로 시작할 수 없습니다. 유저 생성 후 진행해주세요.");
                    serviceNum = 7;
                    break;
                }

                if (serviceNum == 2) {
                    System.out.println("현재 전체 생성한 회원목록");
                    for(Long i : userAccount.keySet()){ //저장된 key값 확인
                        User targetUser = userAccount.get(i);
                        user.list(targetUser);
                    }
                }else if(serviceNum == 3){
                    System.out.println("상세조회를 원하는 회원의 ID 입력");
                    long targetUserId = Long.parseLong(sc.next());
                    User targetDetailUser = userAccount.get(targetUserId);
                    user.detail(targetDetailUser);
                }else if(serviceNum >= 4){ // 게시글 시리즈 시작!
                    if(serviceNum == 4){ // 게시글 작성
                        System.out.println("게시글의 제목, 내용, 이메일을 띄어쓰기 기준으로 입력하세요. (기존에 등록되어있는 유저의 이메일만 가능)");
                        String postTitle = sc.next();
                        String postContents = sc.next();
                        String postEmail = sc.next();

                        boolean isTrueEmail = user.emailChecker(postEmail,userAccount);
                        if(!isTrueEmail){
                            System.out.println("존재하지 않은 이메일 입니다. 다시 시도하세요.");
                            break;
                        }
                        post = new Post(postTitle, postContents, postEmail);

//                         post 객체 생성된 버전을 getter 를 톻해 메모리 주소화 함께 TreeMap에 추가!
                        postList.put(post.getId(), post);
                    }else{
                        if (post==null) {
                            System.out.println("게시글(post)객체가 비어있는 상태로 시작할 수 없습니다. 게시글 생성 후 진행해주세요.");
                            serviceNum = 7;
                            break;
                        }

                        if(serviceNum == 5){ //게시글목록조회
                            System.out.println("현재 전체 생성한 게시글목록");
                            for(Long i : postList.keySet()){ //저장된 key값 확인
                                Post targetPost = postList.get(i);
                                post.list(targetPost);
                            }
                        }else if(serviceNum == 6){ //게시글상세조회
                            System.out.println("상세조회를 원하는 게시글 ID 입력");
                            long targetPostId = Long.parseLong(sc.next());
                            Post targetDetailPost = postList.get(targetPostId);
                            post.detail(targetDetailPost);

                        }else{
                            System.out.println("잘못된 접근입니다.");
                        }
                    }
                }
            }
        }

        System.out.println("서비스 종료");
        sc.close();
    }
}

class Post{
    static long postAutoId = 0L;

    private long id;
    private String title, contents, email;

    Post(String title, String contents, String email) {
        this.write(title, contents, email);
//        this.user.getPosts().add(this);
    }

    void write(String title, String contents, String email){
        // id, title, contents, email
        postAutoId += 1;
        this.id = postAutoId;
        this.title = title;
        this.contents = contents;
        this.email = email;
        System.out.println("게시글이 성공적으로 작성되었습니다.");
    }
    void list(Post post){
        // id, title
        System.out.println(post.id + " >> " + post.email);
    }
    void detail(Post post){
        // id, title, contents, 저자(email or nanme or author_id)
        System.out.println("게시글 아이디 : " + post.id);
        System.out.println("게시글 타이틀 :" + post.title);
        System.out.println("게시글 내용 :" + post.contents);
        System.out.println("게시글 작성자 이메일 :" + post.email);
    }
    //    getter 시작
    public long getId() {
        return this.id;
    }
}

class User {
    static long userAutoId = 0L;

    private long id;
    private String name, email, password;

    private List<Post> posts = new ArrayList<>();
    // 내 글 쓴 목록을 보기 위한 것 생성
    // DB에서 정보를 조회할 때, 추가적으로 DB에 접근하지 않게하기 위해 하는 것.

    User(String name, String email, String password) {
        this.join(name, email, password);
    }


    // 회원가입
    void join(String name, String email, String password) {
        userAutoId += 1;
        this.id = userAutoId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // 회원전체목록조회
    void list(User user) {
        System.out.println(user.id + " >> " + user.email);
    }

    //회원상세조회
    void detail(User user) {
        // id, name, email, password
        System.out.println("유저의 아이디 : " + user.id);
        System.out.println("유저의 이름 :" + user.name);
        System.out.println("유저의 이메일 :" + user.email);
        System.out.println("유저의 비밀번호 :" + user.password);
    }

    void getPosts(){

    }

    //    getter 시작
    public long getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public boolean emailChecker(String email, Map<Long,User> user){
        boolean result = false;
        for(Long i : user.keySet()){ //저장된 key값 확인
            User loopUser = user.get(i);
            if(Objects.equals(loopUser.getEmail(), email)){
                result = true;
                return true;
            }
        }
        return result;
    }
}


