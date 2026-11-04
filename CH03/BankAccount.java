class Bank {
    // 클래스 변수
    static String bankName = "K-BANK";
    static int accountCount = 0;

    // 인스턴스 변수
    String owner;
    int balance;

    // 기본생성자
    Bank() {
        this("이름 없음", 0);
    }

    // 매개변수가 있는 생성자
    Bank(String owner, int balance) {
        this.owner = owner;
        this.balance = balance;
        accountCount++;
    }

    // amount만큼 잔액 증가
    void deposit(int amount) {
        balance += amount;
    }

    // amount만큼 잔액 빼기
    void withdraw(int amount) {
        if (balance >= amount) balance -= amount;
        else System.out.println("잔액이 부족합니다");
    }

    // 계좌 정보 출력
    void printAccount() {
        System.out.println("은행 이름: " + Bank.bankName);
        System.out.println("소유자: " + this.owner);
        System.out.println("잔액: " + this.balance);
    }

    // 전체 계좌 개수를 출력
    static void printAccountCount() {
        System.out.println("생성된 계좌의 수: " + Bank.accountCount);
    }
}

public class BankAccount {
    public static void main(String[] args) {
        Bank a1 = new Bank();
        Bank a2 = new Bank("한빈", 10000);
        Bank a3 = new Bank("타로", 20000);

        // a2에 5000원 입금하기
        a2.deposit(5000);
        // a3에서 3000원 출금
        a3.withdraw(3000);
        // 모든 계좌 정보 출력
        a1.printAccount();
        a2.printAccount();
        a3.printAccount();
        // 전체 계좌 개수 출력
        Bank.printAccountCount();
    }
}