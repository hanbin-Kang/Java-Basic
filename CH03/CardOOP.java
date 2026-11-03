/*
 * [문제] 클래스 변수, 인스턴스 변수, 생성자와 this()
 *
 * 1. 클래스 변수
 *    - width: 카드 너비, 초기값 100
 *    - height: 카드 높이, 초기값 250
 *    - 모든 카드 객체가 공유하도록 선언한다.
 *
 * 2. 인스턴스 변수
 *    - kind: 카드 종류
 *    - number: 카드 번호
 *    - 각 객체마다 독립적으로 관리한다.
 *
 * 3. 생성자
 *    - 기본 생성자는 kind를 "SPADE", number를 1로 초기화한다.
 *    - 매개변수가 있는 생성자는 전달받은 값으로 초기화한다.
 *    - 기본 생성자에서 this()를 사용해 다른 생성자를 호출한다.
 *
 * 4. 인스턴스 메서드
 *    - printCard(): 카드 종류, 번호, 크기를 출력한다.
 *
 * 5. 클래스 메서드
 *    - changeSize(int width, int height): 카드 크기를 변경한다.
 *    - 클래스 이름으로 호출할 수 있도록 선언한다.
 *
 * 6. main 메서드
 *    - 기본 생성자로 카드 객체 c를 생성한다.
 *    - "HEART", 7을 전달하여 카드 객체 c2를 생성한다.
 *    - c2의 카드 정보를 출력한다.
 *    - 카드 크기를 150x300으로 변경한다.
 *    - c와 c2의 카드 정보를 출력한다.
 */

class CardKind {

    // 클래스 변수
    static int width = 100;
    static int height = 250;

    // 인스턴스 변수
    String kind;
    int number;

    // 기본 생성자
    CardKind() {
        this("SPADE", 1);
    }

    // 매개변수가 있는 생성자
    CardKind(String kind, int number) {
        this.kind = kind;
        this.number = number;
    }

    // 카드 정보 출력
    void printCard() {
        System.out.println("카드 종류: " + kind);
        System.out.println("카드 번호: " + number);
        System.out.println("카드 크기: " + width + "x" + height);
    }

    // 카드 크기 변경
    static void changeSize(int width, int height) {
        CardKind.width = width;
        CardKind.height = height;
    }
}

public class CardOOP {

    public static void main(String[] args) {

        // 카드 객체 생성
        CardKind c = new CardKind();
        CardKind c2 = new CardKind("HEART", 7);

        // 변경 전 카드 정보 출력
        c2.printCard();

        // 카드 크기 변경
        CardKind.changeSize(150, 300);
        System.out.println("카드 크기 변경");

        // 변경 후 카드 정보 출력
        c.printCard();
        c2.printCard();
    }
}