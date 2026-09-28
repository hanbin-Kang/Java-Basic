public class Movie {
    public static void main(String[] args) {

        int age;
        int price;
        String day;
        int time;

        // 기본 요금
        // 일반: 12,000원
        // 청소년(13~18세): 9,000원
        // 어린이(12세 이하): 6,000원

        if (age > 18) {
            price = 12000;
        } else if (age > 12) {
            price = 9000;
        } else {
            price = 6000;
        }

        // 65세 이상 할인
        if (age >= 65) {
            price -= 3000;
        }

        // 월~목 할인
        if (day.equals("월") ||
            day.equals("화") ||
            day.equals("수") ||
            day.equals("목")) {

            price -= 2000;
        }

        // 18시 이후 할인
        if (time >= 18) {

            // 청소년은 월~목 할인과 중복 적용 불가
            if (age < 13 || age > 18) {
                price -= 1000;
            }
        }

        System.out.println("최종 요금: " + price + "원");
    }
}


        // 기본 요금
        if (age > 18) {
            price = 12000;
        } else if (age > 12) {
            price = 9000;
        } else {
            price = 6000;
        }

        // 65세 이상
        if (age >= 65) {
            price -= 3000;
        }

        // 월~목
        if (day.equals("월") ||
            day.equals("화") ||
            day.equals("수") ||
            day.equals("목")) {

            price -= 2000;
        }

        // 18시 이후
        if (time >= 18) {

            // 청소년이 아닌 경우만 시간 할인
            if (age < 13 || age > 18) {
                price -= 1000;
            }
        }