# Java 객체지향 프로그래밍 정리

## 1. 클래스 간의 관계

클래스 간의 관계는 크게 두 가지로 나뉜다.

1. 상속 (Inheritance)
2. 포함 (Composition)

### 1-1. 상속 (Inheritance)

기존 클래스를 확장(재사용)하여 새로운 클래스를 작성하는 것

- `extends` 키워드 사용
- Java는 단일 상속만 허용한다.
- 자손 클래스는 조상 클래스의 모든 멤버를 상속받는다. (생성자와 초기화 블럭은 제외)
- 자손 클래스의 멤버 개수는 조상 클래스보다 항상 같거나 많다.

```java
class Parent {}

class Child extends Parent {}
```

`Child` 클래스가 `Parent` 클래스를 상속받는다는 의미이다.

```java
class Parent {
    int age;
}

class Child extends Parent {
    void play() {
        System.out.println("놀이");
    }
}
```

- Parent의 멤버: `age`
- Child의 멤버: `age`, `play()`
- Child는 Parent의 멤버를 상속받아 사용한다.

**상속 관계의 특징**

- 부모 클래스의 변경은 자식 클래스에 영향을 줄 수 있다.
- 자식 클래스의 변경은 부모 클래스에 영향을 주지 않는다.
- 부모 클래스의 멤버가 추가되면 자식 클래스도 해당 멤버를 상속받는다.

### 1-2. 포함 (Composition)

클래스 내부에 다른 클래스의 참조형 변수를 선언하여 사용하는 것

**[1] 포함 관계가 아닌 경우**

```java
class Circle {
    int x;  // 원점의 x좌표
    int y;  // 원점의 y좌표
    int r;  // 반지름
}
```

**[2] 포함 관계인 경우**

```java
class Point {
    int x;
    int y;
}

class Circle {
    Point c = new Point();
    int r;
}
```

- `Circle` 클래스가 `Point` 객체를 참조한다.
- `Point` 객체를 통해 x, y 좌표를 관리한다.
- 관련 있는 데이터를 별도의 클래스로 분리하여 재사용할 수 있다.

### 1-3. 상속과 포함 관계 비교

| 구분 | 상속 (Inheritance) | 포함 (Composition) |
|---|---|---|
| 관계 | ~는 ~이다 (is-a) | ~는 ~을 가지고 있다 (has-a) |
| 코드 | `extends` | 참조형 변수 선언 |
| 예시 | `CaptionTv`는 `TV`다 | `Circle`은 `Point`를 가진다 |

**구분하는 방법**

- A는 B다 → 상속 (is-a)
- A는 B를 가지고 있다 → 포함 (has-a)

Java는 단일 상속만 가능하므로 여러 클래스의 기능이 필요한 경우 상속과 포함을 함께 사용하거나 포함 관계로 구성할 수 있다.

---

## 2. 참조형 반환 타입

메서드는 하나의 값만 반환할 수 있지만, 객체를 이용하면 여러 값을 하나로 묶어서 반환할 수 있다.

- 여러 값을 하나의 객체로 구성한다.
- 객체의 주소를 반환한다.
- 반환받은 참조형 변수로 객체의 멤버에 접근할 수 있다.

---

## 3. 오버라이딩 (Overriding)

조상 클래스로부터 상속받은 메서드를 자손 클래스에서 재정의하는 것

```java
class Point {
    int x;
    int y;

    String getLocation() {
        return "x: " + x + ", y: " + y;
    }
}

class Point3D extends Point {
    int z;

    @Override
    String getLocation() {
        return super.getLocation() + ", z: " + z;
    }
}
```

- 부모 클래스의 `getLocation()`을 자식 클래스에서 재정의한다.
- `@Override`는 오버라이딩을 명시하는 어노테이션이다.
- `super.getLocation()`을 사용하면 부모 클래스의 메서드를 호출할 수 있다.

### 오버라이딩 조건 3가지

1. 메서드의 선언부가 일치해야 한다. (메서드 이름, 매개변수, 반환 타입)
2. 접근 제어자는 조상 클래스의 메서드보다 좁은 범위로 변경할 수 없다.
3. 조상 클래스의 메서드보다 많은 예외를 선언할 수 없다.

---

## 4. super 참조변수

`super`는 자손 클래스에서 조상 클래스의 멤버를 구별할 때 사용하는 참조변수이다.

```java
class Parent {
    int x = 10;
}

class Child extends Parent {
    int x = 20;

    void method() {
        System.out.println("x = " + x);
        System.out.println("this.x = " + this.x);
        System.out.println("super.x = " + super.x);
    }
}

class SuperEx {
    public static void main(String[] args) {
        Child c = new Child();
        c.method();
    }
}
```

**실행 결과**

```text
x = 20
this.x = 20
super.x = 10
```

- `x` : 현재 클래스에서 가까운 변수
- `this.x` : 자손 클래스의 인스턴스 변수
- `super.x` : 조상 클래스의 인스턴스 변수

---

## 5. 생성자와 super()

생성자의 첫 번째 문장에는 `this()` 또는 `super()`를 호출해야 한다.

- `this()` : 같은 클래스의 다른 생성자 호출
- `super()` : 조상 클래스의 생성자 호출
- 둘 다 작성하지 않으면 컴파일러가 자동으로 `super()`를 삽입한다.

### 생성자 조건

1. 생성자의 이름은 클래스 이름과 일치해야 한다.
2. 반환 타입을 작성하지 않는다. (`void`도 사용하지 않는다.)
3. `this()`를 사용하여 같은 클래스의 다른 생성자를 호출할 수 있다.
4. `this()` 또는 `super()`는 생성자의 첫 번째 문장에 위치해야 한다.
5. 둘 다 작성하지 않으면 컴파일러가 자동으로 `super()`를 삽입한다.
6. 단, 부모 클래스에 매개변수가 없는 생성자가 존재해야 한다.

---

## 6. 패키지 (Package)

패키지는 서로 관련된 클래스 파일들을 하나로 묶어 관리하는 폴더이다.

- 클래스는 파일 단위로 작성한다.
- 패키지는 관련 있는 클래스들을 묶어 관리한다.
- 여러 패키지를 하나로 묶어 관리하는 단위는 모듈(Module)이다.

---

## 7. 제어자 (Modifier)

제어자는 클래스와 클래스의 멤버에 부가적인 의미를 부여한다.

**접근 제어자**
- `public`
- `protected`
- `(default)`
- `private`

**그 외의 제어자**
- `static`
- `final`
- `abstract`

### 7-1. static

의미: 클래스의, 공통적인

적용 대상:
- 멤버 변수
- 메서드
- 초기화 블럭

```java
class StaticTest {

    // 클래스 변수
    static int width = 200;
    static int height = 120;

    // 클래스 초기화 블럭
    static {
    }

    // 클래스 메서드
    static int max(int a, int b) {
        return a > b ? a : b;
    }
}
```

**핵심**
- 객체를 생성하지 않아도 클래스 이름으로 접근할 수 있다.
- 모든 객체가 공유하는 클래스 변수이다.
- 클래스 메서드에서는 인스턴스 멤버에 직접 접근할 수 없다.

### 7-2. final

의미: 마지막의, 변경될 수 없는

적용 대상:
- 클래스
- 변수
- 메서드

```java
// 상속할 수 없는 클래스
final class FinalTest {

    // 값을 변경할 수 없는 멤버 변수
    final int MAX_SIZE = 10;

    // 오버라이딩할 수 없는 메서드
    final int getMaxSize() {

        // 값을 변경할 수 없는 지역 변수
        final int LV = MAX_SIZE;

        return LV;
    }
}
```

**final의 특징**

| 적용 대상 | 의미 |
|---|---|
| 클래스 | 상속할 수 없음 |
| 메서드 | 오버라이딩할 수 없음 |
| 변수 | 값을 변경할 수 없음 |

### 생성자로 상수 초기화

객체마다 다른 상수값을 가지도록 하려면 인스턴스 변수에 `final`을 붙이고 생성자에서 초기화할 수 있다.

```java
class Card {
    final int NUMBER;
    final String KIND;

    static int width = 100;
    static int height = 250;

    Card(String kind, int num) {
        KIND = kind;
        NUMBER = num;
    }
}

public static void main(String[] args) {
    Card c = new Card("HEART", 10);

    System.out.println(c.KIND);
    System.out.println(c.NUMBER);
}
```

- `KIND`, `NUMBER`는 final 인스턴스 변수이다.
- 생성자를 통해 초기화할 수 있다.
- 초기화 이후에는 값을 변경할 수 없다.
- 객체마다 서로 다른 상수값을 가질 수 있다.

### 7-3. abstract

의미: 추상의, 미완성의

적용 대상:
- 클래스
- 메서드

```java
// 추상 클래스
abstract class AbstractTest {

    // 추상 메서드
    abstract void move();
}
```

**특징**
- 추상 메서드는 구현부가 없는 메서드이다.
- 추상 메서드가 하나라도 있으면 클래스도 추상 클래스로 선언해야 한다.
- 추상 클래스는 직접 객체를 생성할 수 없다.
- 자손 클래스에서 추상 메서드를 구현해야 한다.

---

## 8. 접근 제어자 (Access Modifier)

접근 제어자는 클래스, 멤버 변수, 메서드, 생성자에 사용하며 외부에서 접근할 수 있는 범위를 제한한다.

### 8-1. 접근 제어자의 종류

| 접근 제어자 | 같은 클래스 | 같은 패키지 | 다른 패키지의 자손 클래스 | 전체 |
|:---:|:---:|:---:|:---:|:---:|
| `public` | O | O | O | O |
| `protected` | O | O | O | X |
| `(default)` | O | O | X | X |
| `private` | O | X | X | X |

### 8-2. 접근 범위 정리

1. `public` : 모든 곳에서 접근 가능
2. `protected` : 같은 패키지 및 다른 패키지의 자손 클래스에서 접근 가능
3. `(default)` : 같은 패키지 내에서만 접근 가능
4. `private` : 같은 클래스 내에서만 접근 가능

**핵심 정리**

- 접근 범위: `public` > `protected` > `(default)` > `private`
- 접근 제어자를 생략하면 `(default)`가 적용된다.
- 최상위 클래스에는 `public` 또는 `(default)`만 사용할 수 있다.

---

## 9. 접근 제어자를 이용한 캡슐화

캡슐화는 외부로부터 데이터를 보호하고, 내부적으로만 사용하는 내용을 감추는 것이다.

**접근 제어자를 사용하는 이유**

1. 외부로부터 데이터를 보호하기 위해서
2. 외부에 불필요한 내부 구현을 감추기 위해서

예시: 재고 수량이 음수가 되는 것을 방지

### Getter와 Setter

인스턴스 변수는 `private`으로 선언하고, 외부에서는 메서드를 통해 접근하도록 구성할 수 있다.

- Getter: 값을 가져오는 역할
- Setter: 값을 변경하는 역할

Getter와 Setter는 별도의 예약어가 아니라 메서드의 역할을 나타내는 명칭이다.

```java
public class Time {

    // 외부에서 직접 접근할 수 없는 인스턴스 변수
    private int hour;
    private int minute;
    private int second;

    // Getter
    public int getHour() {
        return hour;
    }

    // Setter
    public void setHour(int hour) {

        // 0~23 범위만 허용
        if (hour < 0 || hour > 23) {
            return;
        }

        this.hour = hour;
    }
}
```

**사용 방법**

```java
public static void main(String[] args) {

    Time t = new Time();

    t.setHour(12);

    // 1시간 후로 변경
    t.setHour(t.getHour() + 1);

    System.out.println(t.getHour());
}
```

**실행 결과**

```text
13
```

**코드 동작 과정**

1. `getHour()` : 현재 hour 값을 가져온다.
2. `+ 1` : 가져온 값에 1을 더한다.
3. `setHour()` : 계산한 값을 객체에 저장한다.

**핵심**

- `t.hour = 12;`는 private이므로 외부에서 직접 접근할 수 없다.
- `t.setHour(12);`는 public 메서드를 통해 값을 변경한다.
- Getter와 Setter가 인스턴스 변수를 감싸고 있으므로 외부 객체는 메서드를 거쳐 변수에 접근한다.

---

## 10. 생성자의 접근 제한자 - Singleton 패턴

`private` 생성자는 외부에서 직접 객체를 생성하지 못하도록 제한한다.

이를 이용하여 하나의 객체만 생성하고 여러 곳에서 동일한 객체를 공유하는 Singleton 패턴을 구현할 수 있다.

### 10-1. Singleton 코드

```java
class Singleton {

    // 클래스 내부에서 객체 하나 생성
    private static Singleton s = new Singleton();

    // 외부에서 객체 생성 불가
    private Singleton() {
    }

    // 이미 생성된 객체 반환
    public static Singleton getInstance() {
        return s;
    }
}
```

### 10-2. 각 코드의 역할

**1. private Singleton()**

- 외부에서 생성자를 호출하여 객체를 생성하는 것을 방지한다.
- 같은 클래스 내부에서는 생성자 호출이 가능하다.

**2. private static Singleton s**

- 클래스 내부에서 Singleton 객체를 하나 생성한다.
- `static`이므로 객체 생성 없이 클래스에 소속되어 존재한다.
- `private`이므로 외부에서 직접 접근할 수 없다.

**3. public static Singleton getInstance()**

- 이미 생성된 객체를 반환한다.
- `static`이므로 객체를 생성하지 않고도 호출할 수 있다.
- `return s`는 새로운 객체를 만드는 것이 아니라 기존 객체의 참조값을 반환한다.

### 10-3. 사용 방법

```java
Singleton s1 = Singleton.getInstance();
Singleton s2 = Singleton.getInstance();
```

- `s1`, `s2`는 동일한 객체의 주소를 저장하는 참조변수이다.
- 새로운 객체를 생성하는 것이 아니라 기존 객체를 반환받는다.
- `new Singleton()`은 생성자가 private이므로 외부에서 사용할 수 없다.

```java
System.out.println(s1 == s2);
```

**실행 결과**

```text
true
```

### 10-4. 핵심 정리

| 코드 | 역할 |
|---|---|
| `private Singleton()` | 외부의 객체 생성 차단 |
| `private static Singleton s` | 객체 하나를 미리 생성 |
| `public static getInstance()` | 기존 객체 반환 |

**핵심 개념**

- 객체를 여러 개 만들지 못하도록 제한한다.
- 클래스 내부에서 객체를 미리 하나 생성한다.
- 외부에서는 `getInstance()`를 통해 객체를 가져온다.
- `s1`, `s2`는 동일한 객체를 참조한다.

**사용 방법**

```java
Singleton s1 = Singleton.getInstance();
```

