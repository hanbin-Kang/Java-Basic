public class IfBasic{
    public static void main(String[] args) {
        int score = 94;
        String grade = "";
        String opt = "";
        if (score >= 90) { // 점수가 90점 이상이면
            grade = "A";  // grade = "A"
            if (score >= 98) { // 점수가 95점 이상일 때
                opt = "+";    // opt = "+"
            } else if (score <= 94){         // 95점 미만일 때
                opt = "-";  // opt = "-"
            }
        }
        System.out.println(score + ":" + grade + opt);
    }
}