public class ArrayBasic2 {
    public static void main(String[] args) {
        int[] score = new int[5]; // 길이가 5인 int배열

        // 각 인덱스 * 100의 값을 배열에 넣기
        for (int i = 0; i < score.length; i++) {
            score[i] = i * 100;
            System.out.println(score[i]);
        }
    }
}
