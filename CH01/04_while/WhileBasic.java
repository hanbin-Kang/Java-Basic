public class WhileBasic {
    public static void main(String[] args) {
        int sum = 0;
        int i = 0;

        while (true) {
            if (sum > 100) { // sum이 100보다 클때 정지 (반복문 탈출)
                break;
            }
            i ++;
            sum += i;
        }
        System.out.println("i = " + i);
        System.out.println("sum = " + sum);
    }    
}
