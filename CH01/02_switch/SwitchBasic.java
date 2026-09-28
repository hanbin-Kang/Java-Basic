public class SwitchBasic {
    public static void main(String[] args) {
        int score = 92;
        String grade = "";
        switch (score / 10) {
            case 10 : case 9:
                grade = "A";
                break;
            case 8 :
                grade = "B";
                break;
            case 7 :
                grade = "C";
                break;      
            default:
                grade = "F";     
        } // end of switch
        System.out.println(grade);
    }    
}
