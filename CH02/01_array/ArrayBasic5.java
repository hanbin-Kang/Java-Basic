public class ArrayBasic5 {
    // 최댓값과 최솟값
    public static void main(String[] args) {
        int[] score = {79, 88, 91, 33, 100, 55, 95};
        int maxScore = Integer.MIN_VALUE;
        int minScore = Integer.MAX_VALUE;

        for (int i=0; i<score.length; i++) {
            if (score[i] > maxScore) maxScore = score[i];
            if (score[i] < minScore) minScore = score[i];
        }
        System.out.println("최댓값: " + maxScore);
        System.out.println("최솟값: " + minScore);
    }
}
