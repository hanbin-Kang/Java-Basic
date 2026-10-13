import java.util.Arrays;

public class ArrayBasic3 {
    public static void main(String[] args) {
        int[] score = {50, 60, 70, 80};
        int[] newScore = new int[score.length * 2];
        // 배열 확인
        System.out.println(Arrays.toString(score)); // [50, 60, 70, 80]
        System.out.println(Arrays.toString(newScore)); // [0, 0, 0, 0, 0, 0, 0, 0]

        // 배열 복사
        // (1) 명령어 사용
        System.arraycopy(score, 0, newScore, 0, score.length);

        // (2) 반복문 사용
        // for (int i=0; i<score.length; i++) {
        //     newScore[i] = score[i];
        // } 

        // 배열의 참조주소값을 변경
        score = newScore;

        // 변경 확인
        System.out.println(Arrays.toString(score)); // [50, 60, 70, 80, 0, 0, 0, 0] 원래 배열과의 연결이 끊김
        System.out.println(Arrays.toString(newScore)); // [50, 60, 70, 80, 0, 0, 0, 0]
    }
}
