public class ForPattern01 { // 1 12 123 1234 12345 출력
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) { // 행
            for (int j = 1; j <= 5; j++) { // 열
                if (j <= i) { // 조건문 : 열이 행보다 작거나 클때 1열 -> 1행까지, 2열 -> 1, 2행 ... 5열 -> 1, 2, 3, 4, 5행
                    System.out.print(j);
                }
            }
            System.out.println();
        }
    }
}