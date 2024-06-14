package C04Interface.BankService;

// 비즈니스 로직이 활동하는 service 코드
public class BankService {

//    public void transfer(int money, BankAccount bankAccount){
//        this.balance -= money;
//        bankAccount.deposit(money);
//        System.out.println("현재 잔액은 " + this.balance);
//    }
    public void deposit(int money, BankAccount bankAccount){
        this.balance += money;
        System.out.println(money+"원 입금되었습니다.");
        System.out.println("현재 잔액은 " + this.balance);
    }
    public void withdraw(int money, BankAccount bankAccount){
        if(this.balance < money){
            System.out.println("잔액 부족입니다.");
        }else {
            this.balance -= money;
            System.out.println(money + "원 출금되었습니다.");
        }
        System.out.println("현재 잔액은 " + this.balance);
    }
}