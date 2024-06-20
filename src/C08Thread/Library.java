package C08Thread;

public class Library {
    static int bookCount = 100;

//    public static void borrow(){

//    🍀해결법 2🍀 : 메소드에 synchronized 걸기!
//                    해당 키워드를 통해서 해당 메서드에 한해 lock을 걸도록 설정
//                    해당 메서드를 들어오기 전에 앞에 사용자 줄세움
    public synchronized static void borrow(){
        if(bookCount > 0){
            try{
                Thread.sleep(10); //눈으로 보기 위한 것
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            bookCount--;
            System.out.println("대출완료");
            System.out.println("남아있는 책 수량 : "+bookCount);
        }else{
            System.out.println("대출이 마감");
        }
    }
}
