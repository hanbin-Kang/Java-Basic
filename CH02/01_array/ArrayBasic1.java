// score라는 참조 변수가 배열 객체의 주소 0x100을 가리킨다고 가정한다.
// 인덱스 번호는 0부터 score.length - 1까지이며,
// 이 인덱스를 이용해 배열 내 해당 위치의 값을 가져올 수 있다.

public class ArrayBasic1 {
    public static void main(String[] args) {
        int[] score = new int[5];
        // 배열 안에 들어 있는 값들을 for문으로 확인할 때
        for (int i=0; i<score.length; i++) {
            System.out.println(score[i]);
        }
    }
}