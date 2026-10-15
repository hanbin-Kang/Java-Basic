import java.util.Arrays;

public class ArrayBasic6 {
    // 섞기
    public static void main(String[] args) {
        int[] numArr = new int[10];

        // 배열을 0 ~ 9의 숫자로 초기화
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = i;
        }
        System.out.println(Arrays.toString(numArr));
        System.out.println();

        for (int i = 0; i < 100; i++) {
            int n = (int)(Math.random() * 10); // 난수 10개 (0 ~ 9)
            int tmp = numArr[0]; // tmp값은 0, numArr[n]이 tmp값 (랜덤)
            numArr[0] = numArr[n]; // numArr의 0번째는 원래 0인데 랜덤의 n값으로 변경
            numArr[n] = tmp; // tmp의 값은 numArr[n]
            // 이 과정을 100번 반복
        }

        System.out.println(Arrays.toString(numArr));
    }
}
