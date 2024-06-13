package C02ClassBasic;

import java.util.*;

public class BankService {
    public static void main(String[] args) {
//        String b1Balnum = "1234";
//        BankAccount b1 = new BankAccount(b1Balnum);
//        b1.deposit(10000);
////        b1.withdraw(b1Balnum,3000);
//
//        String b2Balnum = "4321";
//        BankAccount b2 = new BankAccount(b2Balnum);
//        b2.deposit(2000);
//        b2.trnsfer(1000, b1); // b2가 b1에게 보낸당
//        System.out.println(b1.getBalance());
//        System.out.println(b2.getBalance());
//        계좌 개설할 때 마다, list에 넣기
        Scanner sc = new Scanner(System.in);
        Map<String, BankAccount> bankAccounts = new HashMap<>();
        int serviceNum = 0;
        while (serviceNum != 5){
            System.out.println("어떤 서비스를 이용하실 예정인가요? 이용하실 서비스의 [번호]를 입력해주세요.");
            System.out.println("1. 계좌개설  /  2. 입금  /  3. 출금  /  4. 계좌송금  / 5. 종료");
            String serviceStr = sc.nextLine();

            serviceNum = Integer.parseInt(serviceStr);
            int money = 0;
            String accNumber = "";

            System.out.println("계좌번호를 입력하세요.");
            accNumber = sc.nextLine();

            if(serviceNum == 1){
                bankAccounts.put(accNumber, new BankAccount(accNumber));
                System.out.println(bankAccounts);
            }else{
                BankAccount account = bankAccounts.get(accNumber);
                System.out.println(accNumber);
                System.out.println(bankAccounts);
                System.out.println(account.getAccountNumber());
                switch (serviceNum){
                    case 2 :
                        System.out.println("얼마를 입금하시겠어요?");
                        money = Integer.parseInt(sc.nextLine());
                        account.deposit(money);
                        break;
                    case 3 :
                        System.out.println("얼마를 출금하시겠어요?");
                        money = Integer.parseInt(sc.nextLine());
                        account.withdraw(money);
                        break;
                    case 4 :
                        System.out.println("누구에게 입금하시나요? (계좌번호 입력)");
                        String targetNumber = sc.nextLine();
                        BankAccount targetAccount = bankAccounts.get(targetNumber);
                        System.out.println("얼마를 보내시나요?");

                        money = Integer.parseInt(sc.nextLine());
                        account.trnsfer(money,targetAccount);
                        break;
                    case 5 :
                        System.exit(0);
                        break;
                    default:
                        System.out.println("잘못된 숫자값 입니다.");
                        break;
                }
            }
        }
    }
}

class BankAccount{
    String accountNumber;
    int balance;

    BankAccount(String accountNumber){
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    public int getBalance() {
        return balance;
    }

    void deposit(int balnum){
        this.balance += balnum;
        System.out.println(balnum+"원 입금되었습니다. 현재 잔액 : "+this.balance);
    }

    void withdraw(int balnum){
        int diff = this.balance - balnum;
        if(diff < 0){
            System.out.println("잔액이 부족합니다.");
        }else{
            this.balance = diff;
            System.out.println(balnum+"원 출금되었습니다. 현재 잔액 : "+this.balance);
        }
    }

    void trnsfer(int money, BankAccount bankAccount){
        this.balance -= money;
        bankAccount.deposit(money);
    }
}
