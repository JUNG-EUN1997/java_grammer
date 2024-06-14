package C04Interface.BankService;

// 비즈니스 로직이 활동하는 service 코드
public class BankCardService implements BankService {

    String defaultWord = "";
    public void deposit(int money, BankAccount bankAccount){
        int myMoney = bankAccount.getBalance();
        int total = myMoney + money;
        bankAccount.updateBalance(total);
        System.out.println(money+"원 "+this.defaultWord+"로 입금 되었습니다.");
        System.out.println("현재 잔액은 " + total);
    }
    public void withdraw(int money, BankAccount bankAccount){
        int myMoney = bankAccount.getBalance();

        if(myMoney < money){
            System.out.println("잔액 부족입니다.");
        }else {
            myMoney -= money;
            System.out.println(money + "원 "+this.defaultWord+"로 출금되었습니다.");
            bankAccount.updateBalance(myMoney);
        }
        System.out.println("현재 잔액은 " + myMoney);
    }
}