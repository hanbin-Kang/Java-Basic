// 클래스 생성
class Card {
    // 인스턴스 변수 : 개인
    String kind;
    int number;
    // 클래스 변수 : 공용
    // (static을 붙이면 클래스 변수가 됨)
    static int width = 100;
    static int height = 250;
}

public class ClassBasic1 {
    public static void main(String[] args) {
        // 클래스 변수여서(static) 객체화를 하지 않아도 사용 가능하다
        System.out.println("Card.width = " + Card.width);
        System.out.println("Card.height = " + Card.height);

        // 객체화
        Card c1 = new Card();
        // ====================================
        Card c2 = new Card();

        // 객체화를 하였으니 인스턴스 변수를 변경할 수 있다
        c1.kind = "Heart";
        c1.number = 7;
        // ====================================
        c2.kind = "Spade";
        c2.number = 4;

        // width, height는 static 변수이므로 Card 클래스에 속하며 모든 객체가 공유한다.
        // 따라서 객체를 생성하지 않아도 Card.width로 접근할 수 있다.
        // c1.width로도 접근할 수 있지만, 클래스 변수이므로 Card.width로 접근하는 것이 권장된다.
        // System.out.println("c1은 " + c1.kind + ", " + c1.number + "이며, 크기는 (" + c1.width + ", " + c1.height + ")");
        // System.out.println("c2는 " + c2.kind + ", " + c2.number + "이며, 크기는 (" + c2.width + ", " + c2.height + ")");

        System.out.println("c1의 width와 height를 각각 50, 80으로 변경합니다");
        // c1.width = 50;
        // c1.height = 80;

        // c1과 c2의 클래스 변수가 동일하여 c1만 바꿔도 c2까지 바뀜
        // System.out.println("c1은 " + c1.kind + ", " + c1.number + "이며, 크기는 (" + c1.width + ", " + c1.height + ")");
        // System.out.println("c2는 " + c2.kind + ", " + c2.number + "이며, 크기는 (" + c2.width + ", " + c2.height + ")");
    }
}
