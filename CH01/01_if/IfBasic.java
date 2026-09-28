public class IfBasic{
    public static void main(String[] args) {
        int score = 95;
        String grade = "";
        String opt = "";
        if (score >= 90) { // 점수가 90점 이상이면
            grade = "A";  // grade = "A"
            if (score >= 98) { // 점수가 98점 이상일 때
                opt = "+";    // opt = "+"
            } else if (score <= 94){         // 94점 이하일 때
                opt = "-";  // opt = "-"
            }
        }
        System.out.println(score + ":" + grade + opt);
    }
}