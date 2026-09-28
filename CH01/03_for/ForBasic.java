public class ForBasic {
    public static void main(String[] args) {

        // 1, 2, 3이 반복되는 for문
        // for (int i = 0; i <= 10; i++) {
        //     System.out.println(i % 3 + 1);
        // }

        // 별찍기 (5 x 5)
        // for (int i = 1; i <= 5; i++) {
        //     for (int j = 1; j <= 5; j++) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        // 조건 별찍기 (같은 행, 같은 열만)
        for (int i = 1; i <= 5; i++) { // 행

            for (int j = 1; j <= 5; j++) { // 열

                if (i == j) { // 행과 열이 같을 때
                    // printf() : 형식을 지정해서 출력, 줄바꿈 X
                    System.out.printf("[%d, %d]", i, j);

                } else { // 행과 열이 다를 때
                    // print() : 출력만, 줄바꿈 X
                    // 큰따옴표를 사용하는 이유: 공백 5칸을 하나의 문자열로 표현
                    System.out.print("     ");
                }
            }

            // println() : 출력 후 줄바꿈
            System.out.println();
        }
    }
}

// System.out.print("*");       // 출력만, 줄바꿈 X
// System.out.println("*");     // 출력 후 줄바꿈
// System.out.printf("[%d]", i); // 형식을 지정해서 출력, 줄바꿈 X