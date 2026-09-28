import java.util.Scanner;

public class DoWhileBasic {
    public static void main(String[] args) {
        int input = 0;
        int answer = 0;

        // answer에 랜덤한 수를 넣음
        answer = (int)(Math.random() * 100) + 1; // 1 ~ 100사이의 랜덤한 수
        Scanner scanner = new Scanner(System.in); // python의 input과 같은 역할

        // 몇번만에 맞췄는지 count
        int count = 0;

        do {
            count ++;
            System.out.println("1과 100사이의 정수를 입력하세요.>");
            input = scanner.nextInt();

            if (input > answer) {
                System.out.println(input + "보다 더 작은 수를 입력하세요");
            } else if (input < answer) {
                System.out.println(input + "보다 더 큰 수를 입력하세요");
            }
        } while (input != answer); // input과 answer의 값이 다르면 계속 반복문, 같으면 반복문 종료
        
        System.out.println(input + "은 정답입니다"); // 값이 같을 때 출력하는 문장
        System.out.println("시도 횟수: " + count);
        scanner.close(); // 닫기
    }
}