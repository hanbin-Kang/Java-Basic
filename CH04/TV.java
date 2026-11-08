package CH04;

class TVcondition {
    boolean power; // TV 전원 on/off
    int channel;  // 채널

    // TV 전원을 키는 메서드
    void power() {
        power = !power;
    }
    // 채널을 올리는 메서드
    void channelUp() {
        ++channel;
    }
    // 채널을 내리는 메서드
    void channelDown() {
        --channel;
    }
}

class CaptionTv extends TVcondition {
    boolean caption; // 자막 on/off

    void displayCaption (String text) {
        // 자막이 true일 때 그 자막을 출력
        if (caption) {
            System.out.println(text);
        }
    }
}

class TV {
    public static void main(String[] args) {
        CaptionTv tv1 = new CaptionTv();

        tv1.caption = true;
        tv1.displayCaption("안녕");

        tv1.channelUp();
        System.out.println(tv1.channel + "번 채널");
    }    
}
