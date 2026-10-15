public class StringBasic1 {
    // args.length로 전달받은 매개변수의 개수를 출력한다 (터미널에서)
    public static void main(String[] args) {
        System.out.println("매개변수의 개수: " + args.length);
        
        for (int i=0; i<args.length; i++) {
            System.out.println("args[" + i + "] = \"" + args[i] + "\"");
        }
    }
}
