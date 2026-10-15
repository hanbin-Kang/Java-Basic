import java.util.Arrays;

public class ArrayBasic9 {
    // 빈도수 구하기
    public static void main(String[] args) {
        int[] numArr = new int[10]; // 결과가 담긴 배열
        int[] counter = new int[10]; // 갯수가 담긴 배열

        for (int i=0; i<numArr.length; i++) {
            // 0 ~ 9까지의 난수를 numArr배열에 넣는다
            numArr[i] = (int)(Math.random() * 10);
            System.out.println(numArr[i]);
        }
        System.out.println();

        for (int i=0; i<numArr.length; i++) {
            counter[numArr[i]]++; 
            // numArr[i]에 저장된 숫자를 counter의 인덱스로 사용한다.
            // 해당 숫자가 나올 때마다 counter의 값을 1 증가시킨다.
            // int 배열은 생성될 때 모든 요소가 기본값 0으로 초기화된다.
        }

        for (int i=0; i<numArr.length; i++) {
            System.out.println(i + "의 개수: "+ counter[i]);
        }

        // 위의 코드를 활용하여 중복제거등이 가능하다

        // 중복 제거
        int[] numArr2 = {3, 10, 20, 3, 30, -1, 5, 3};
        int[] notSame = new int[10];

        notSame[0] = numArr2[0];
        int count = 1; // 현재 저장된 숫자의 개수

        for (int i = 1; i < numArr2.length; i++) {
            boolean isSame = false;
            // 실제로 저장된 숫자만 검사
            for (int j = 0; j < count; j++) {
                if (numArr2[i] == notSame[j]) {
                    isSame = true;
                    break;
                }
            }
            // 중복이 아니면 다음 빈칸에 저장
            if (!isSame) {
                notSame[count] = numArr2[i];
                count++;
            }
        }
        // 실제 저장된 숫자만 출력
        System.out.println(Arrays.toString(Arrays.copyOf(notSame, count)));
    }
}
