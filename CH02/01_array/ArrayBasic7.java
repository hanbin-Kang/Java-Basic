import java.util.Arrays;

public class ArrayBasic7 {
    // 임의의 값으로 배열 채우기
    public static void main(String[] args) {
        int[] code = {-4, -1, 3, 6, 11}; // 불연속적인 값으로 구성된 배열
        int[] arr = new int[10]; // 10칸을 가진 arr배열 생성

        for (int i =0; i<arr.length; i++) {
            int tmp = (int)(Math.random() * code.length); 
            // tmp = 0.0 이상 1.0 미만의 랜덤인 수에서 code.length 를 곱하고 int로 바꿔(소수점을 다 버리고) tmp로 저장한다
            arr[i] = code[tmp]; // arr배열의 0번째부터 arr.length까지 칸에 code배열의 tmp번째 값을 넣는다
        }   
        // 출력 
        System.out.println(Arrays.toString(arr));
    }
}
