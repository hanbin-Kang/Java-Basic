import java.util.Arrays;

public class ArrayBasic8 {
    // 버블정렬
    public static void main(String[] args) {
        int[] numArr = new int[5]; // numArr은 5칸짜리 배열이다
        for (int k=0; k<numArr.length; k++) { 
            // 각 배열의 칸에 0 ~ 9까지의 랜덤 수를 넣는다
            numArr[k] = (int) (Math.random() * 10);
        }
        System.out.println(Arrays.toString(numArr));

        for (int i=0;i<numArr.length-1; i++) { // numArr.length-1번 반복 (4번 반복)
            for (int j=0; j<numArr.length-1-i; j++) { // j<numArr.length-1-i번 반복 (4, 3, 2, 1번씩 반복) 
                if (numArr[j] > numArr[j+1]) { // 현재값이 다음 값보다 크다면
                    int tmp = numArr[j]; // tmp라는 변수는 현재값
                    numArr[j] = numArr[j+1]; // 현재값을 다음값으로 
                    numArr[j+1] = tmp; // numArr[j+1]는 현재값으로 변경
                }
            }
        }
        System.out.println(Arrays.toString(numArr));
    }
}
