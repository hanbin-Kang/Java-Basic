public class ConvenienceStore {
    public static void main(String[] args) {
        // 상품 종류
        int menu = 3; 
        // 수량
        int quantity = 2;
        // 멤버십 등급
        String grade = "A";

        // 물건별 가격
        int price = switch(menu) {
            case 1 -> 2000;
            case 2 -> 1500;
            case 3 -> 5000;
            case 4 -> 1200;
            default -> 0;
        };
        // 할인
        int discount = switch(grade) {
            case "S" -> 10;
            case "A" -> 5;
            default -> 0;
        };
        // 총금액
        int totalPrice = price * quantity;
        int discountPrice = totalPrice * discount / 100;

        totalPrice -= discountPrice;

        // 추가 조건 : 도시락을 2개 이상 구매하면 1000원 추가 할인
        if (menu == 3 && quantity >= 2) {
            totalPrice -= 1000;
        } 
        // 출력
        System.out.println("총 가격: " + totalPrice + "원");
        
    }
}
