package C04Interface.BankService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<BankAccount> bankAccounts = new ArrayList<>();
        System.out.println("계좌번호를 입력하세요");
        String accountNumber = sc.nextLine();
//new BankAccount(accNumber)
        bankAccounts.add(new BankAccount(accountNumber));
        while (true){
            System.out.println("서비스 번호를 입력하세요. 1.카드 2.카카오페이");
            int number = Integer.parseInt(sc.nextLine());
            System.out.println("서비스 번호를 입력하세요. 1.입금 2.출금");
            int number2 = Integer.parseInt(sc.nextLine());
            if (number == 1){
//                카드 서비스
                BankService bcs = new BankCardService();
                System.out.println("원하시는 금액을 입력하세요.");
                int money = Integer.parseInt(sc.nextLine());
                if (number2 == 1){
//                    bcs.deposit(money, bankAccounts.get(0));
                }else{
//                    bcs.withdraw(money, bankAccounts.get(0));
                }
            }else{
//                카카오페이 서비스
                BankService bcs = new BankKakaopayService();
                System.out.println("원하시는 금액을 입력하세요!!!");
                int money = Integer.parseInt(sc.nextLine());
                if (number2 == 1){
//                    bcs.deposit(money, bankAccounts.get(0));
                }else{
//                    bcs.withdraw(money, bankAccounts.get(0));
                }
            }
        }
    }
}