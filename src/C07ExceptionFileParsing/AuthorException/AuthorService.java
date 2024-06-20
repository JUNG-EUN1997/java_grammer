package C07ExceptionFileParsing.AuthorException;

import java.util.Optional;

import static C07ExceptionFileParsing.AuthorException.AuthorRepository.authorList;

public class AuthorService {
    AuthorRepository authorRepository;

    AuthorService(){
        authorRepository = new AuthorRepository();
    }

    public void register(Author author){
        boolean isDupEmail = this.checkDupEmail(author);
        if(!isDupEmail){
            throw new IllegalArgumentException("중복된 이메일이라 가입이 불가합니다.");
        }else if(author.getPassword().length() <= 5){
            throw new IllegalArgumentException("비밀번호가 5자리 이하 입니다.");
        }else{
            authorRepository.register(author);
        }
    }

    void login(String email, String password) {
        boolean isCheckEmail = findUserSearch(new String[]{email},FINDTYPE.email);
        boolean isCheckPw = findUserSearch(new String[]{password},FINDTYPE.password);
        if(!isCheckEmail){
            throw new IllegalArgumentException("잘못된 이메일 입니다.");
        }
        if(!isCheckPw){
            throw new IllegalArgumentException("잘못된 비밀번호 입니다.");
        }
        if(isCheckEmail && isCheckPw){
            // ⭐⭐⭐ optinal 객체로 객체null유무 확인하기!
            Optional<Author> targetAuthor = this.emailToAuthor(email);
            Author author = targetAuthor.orElseThrow(()
                    -> new IllegalArgumentException("[Login Error] 존재하지 않는 유저입니다."));
            System.out.println("로그인 성공! "+ author.getName() +" 님, 환영합니다!");
        }
    }

    private boolean checkDupEmail (Author author){
        for (Author i : authorList) {
            if (i.getEmail().equals(author.getEmail())) {
                return false; // 중복이다!
            }
        }
        return true; // 중복이 아니다!
    }

    private <T>boolean findUserSearch (T[] userValueArr, FINDTYPE findtype){
//        userValueArr >> 유저의 email, password의 값이 들어갈 영역
        String targetFindValue = "";
        for (Author i : authorList) {
            if(findtype == FINDTYPE.email){ //이메일을 찾아달라고 했을 때
                targetFindValue = i.getEmail();
            }else if(findtype == FINDTYPE.password){ //비밀번호를 찾아달라고 했을 때,
                targetFindValue = i.getPassword();
            }else{
                throw new IllegalArgumentException("잘못된 FINDTYPE 입니다.");
            }
            for (T j : userValueArr) {
                if (targetFindValue.equals(j)) { // 들어온 값이 진짜 DB에 있음!
                    return true;
                }
            }
        }
        return false;
    }

    private Optional<Author> emailToAuthor(String email){
        Author changeAuthor = null;
        for (Author i : authorList) {
            if(i.getEmail().equals(email)){
                return Optional.of(i);
            }
        }
        return Optional.ofNullable(changeAuthor);
    }
}

enum FINDTYPE{
    name,
    email,
    password;
}

