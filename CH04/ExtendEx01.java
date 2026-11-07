package CH04;

class Parent {
    int age = 40;
}

class Child extends Parent {
    int age = 14;

    // 현재 나이 출력
    void ChildAge() {
        System.out.println("자식의 나이: " + age);
    }
    
    // 상속받은 부모의 나이를 출력 
    void ParentAge() {
        System.out.println("부모의 나이: " + super.age);
    }

    // this를 사용하여 자식의 나이 변경
    void ChildChangeAge(int age) {
        this.age = age;
    }

    // super을 사용하여 상위 클래스인 부모 클래스의 나이를 변경
    void ParentChangeAge(int age) {
        super.age = age;
    }
}

public class ExtendEx01 {
    public static void main(String[] args) {
        // 자식 클래스는 부모 클래스에 상속받고 있으니 자식 클래스만 객체화 하여도 부모의 나이를 알 수 있음.
        Child c1 = new Child();
        
        c1.ChildAge();
        c1.ParentAge();

        System.out.println("나이 변경");
        c1.ParentChangeAge(50);
        c1.ChildChangeAge(24);

        c1.ChildAge();
        c1.ParentAge();
    }
}
