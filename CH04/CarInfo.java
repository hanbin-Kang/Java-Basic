package CH04;

class Engine {
    int horsepower; // 마력 : 인스턴스 변수 
    // 생성자를 활용하여 마력 초기화
    Engine(int horsepower) {
        this.horsepower = horsepower;
    }
    void start() {
        System.out.println("엔진이 작동합니다.");
    }
}

class Vehicle {
    String brand; // 인스턴스 변수
    
    // 생성자를 활용하여 브랜드 초기화
    Vehicle(String brand) {
        this.brand = brand;
    }

    void move() {
        System.out.println("차량이 이동합니다.");
    }
}

class Car extends Vehicle {
    Engine engine;
    String model;
    static int carCount;

    Car(String brand, int horsepower, String model) {
        super(brand);
        // 아래 있는 코드를 원래는 engine을 객체화 한 다음 engine.horespower = horespower로 했는데 
        // 0으로 초기화 시키고 -> 입력한 값으로 초기화 즉 초기화 과정을 두번 했지만, 아래 코드로 바꾸면 초기화를 한번만 사용하여도 된다
        this.engine = new Engine(horsepower);
        this.model = model;
        carCount++;
    }

    void showInfo() {
        System.out.println("브랜드: " + brand);
        System.out.println("모델: " + model);
        System.out.println("마력: " + engine.horsepower);
    }
}


public class CarInfo {
    public static void main(String[] args) {
        Car c1 = new Car("Hyundai", 180, "Sonata");
        Car c2 = new Car("Toyota", 200, "Camry");

        c1.showInfo();
        System.out.println();
        c1.engine.start();
        c1.move();

        System.out.println();
        c2.showInfo();
        System.out.println();
        c2.engine.start();
        c2.move();        

        System.out.println();
        System.out.println("전체 자동차 생산 대수: " + Car.carCount);

    }
}
