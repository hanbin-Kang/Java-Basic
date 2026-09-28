# FLOW-CONTROL

조건문과 반복문을 통해 프로그램의 **실행 흐름(flow)을 제어하는 방법**을 학습한다.

---

## 1. 제어문

제어문(Control Flow)은 프로그램의 **실행 흐름(flow)을 바꾸는 문장**이다.

크게 조건문과 반복문으로 나뉜다.

- 조건문: 조건에 따라 실행하거나 건너뛴다.
- 반복문: 특정 조건이 만족되는 동안 같은 작업을 반복한다.

### 조건문

- `if`
- `if-else`
- `if-else if`
- `switch`

### 반복문

- `for`
- `while`
- `do-while`

---

# 2. if문

조건에 따라 특정 코드를 실행하는 조건문이다.

```java
if (조건식) {
    // 조건식이 true일 때 실행
}
```

조건식이 `true`이면 중괄호 `{}` 안의 문장을 실행하고, `false`이면 실행하지 않는다.

```java
if (score >= 60) {
    System.out.println("합격");
}
```

---

## 3. 문자열 비교

Java에서 문자열의 내용을 비교할 때는 `==` 대신 `equals()`를 사용한다.

### equals()

```java
str.equals("yes")
```

문자열 `str`의 내용이 `"yes"`와 같으면 `true`를 반환한다.

대소문자를 구분한다.

```java
"yes".equals("yes")   // true
"Yes".equals("yes")   // false
```

### equalsIgnoreCase()

```java
str.equalsIgnoreCase("yes")
```

문자열의 내용이 `"yes"`와 같은지 비교하지만 **대소문자를 구분하지 않는다.**

```java
"yes".equalsIgnoreCase("YES")   // true
"Yes".equalsIgnoreCase("yes")   // true
```

Python에서는 문자열 비교에 `==`을 사용하지만, Java에서는 문자열의 내용을 비교할 때 `equals()`를 사용한다.

---

# 4. 중첩 if문

`if`문 안에 또 다른 `if`문을 작성할 수 있다.

여러 번 중첩하는 것도 가능하다.

```java
if (조건식1) {

    if (조건식2) {
        // 조건식1과 조건식2가 모두 true
    } else {
        // 조건식1은 true, 조건식2는 false
    }

} else {
    // 조건식1이 false
}
```

즉, 바깥쪽 조건을 먼저 확인한 후 안쪽 조건을 확인한다.

---

# 5. switch문

여러 경우를 처리할 때 사용하는 조건문이다.

```java
switch (조건식) {
    case 값1:
        // 실행할 문장
        break;

    case 값2:
        // 실행할 문장
        break;

    default:
        // 일치하는 case가 없을 때 실행
}
```

### 실행 과정

1. `switch`의 조건식을 계산한다.
2. 조건식의 결과와 일치하는 `case`로 이동한다.
3. 해당 `case`부터 문장을 실행한다.
4. `break`를 만나거나 `switch`문의 끝에 도달하면 빠져나온다.

`case`를 순서대로 처음부터 검사해서 실행하는 것이 아니라 **조건식의 결과와 일치하는 case로 이동한다.**

---

## 6. switch문의 break

`break`가 있으면 해당 `case`의 실행이 끝난 후 `switch`문을 빠져나간다.

```java
int level = 2;

switch (level) {
    case 3:
        grantDelete();
        break;

    case 2:
        grantWrite();
        break;

    case 1:
        grantRead();
        break;
}
```

하지만 `break`가 없으면 다음 `case`까지 계속 실행된다.

```java
int level = 2;

switch (level) {
    case 3:
        grantDelete();

    case 2:
        grantWrite();

    case 1:
        grantRead();
}
```

`level`이 `2`이면 다음과 같이 실행된다.

```text
grantWrite()
grantRead()
```

즉, `break`가 없으면 **fall-through**가 발생한다.

---

# 7. if문과 switch문

같은 조건을 `if`와 `switch`로 표현할 수 있다.

### if문

```java
if (month == 3 || month == 4 || month == 5) {
    System.out.println("봄");
}
```

### switch문

```java
switch (month) {
    case 3:
    case 4:
    case 5:
        System.out.println("봄");
        break;
}
```

둘 다 여러 조건을 처리할 수 있지만, 여러 값에 따라 분기할 때는 `switch`문이 더 적합할 수 있다.

---

# 8. switch문의 제약 조건

### 조건식

`switch`문의 조건식에는 다음과 같은 값이 사용될 수 있다.

- 정수형 타입 (`long` 제외)
- 문자열
- 참조형

### case

`case`에는 다음과 같은 값을 사용할 수 있다.

- 정수 값
- 문자열 리터럴
- 참조형

또한 같은 `switch`문 안에서 **중복된 case 값은 사용할 수 없다.**

---

# 9. 난수 얻기

Java에서는 `Math.random()`을 사용하여 난수를 얻을 수 있다.

```java
Math.random()
```

기본 범위는 다음과 같다.

```text
0.0 <= Math.random() < 1.0
```

즉, `0.0` 이상 `1.0` 미만의 실수를 반환한다.

---

## 10. 1 ~ 3의 정수 난수

```java
(int)(Math.random() * 3) + 1
```

### 1단계

```text
0.0 <= Math.random() < 1.0
```

### 2단계

양변에 `3`을 곱한다.

```text
0.0 <= Math.random() * 3 < 3.0
```

### 3단계

`int`로 형변환한다.

```text
0 <= (int)(Math.random() * 3) < 3
```

결과:

```text
0, 1, 2
```

### 4단계

양변에 `1`을 더한다.

```text
1 <= (int)(Math.random() * 3) + 1 < 4
```

최종 결과:

```text
1, 2, 3
```

---

## 11. -5 ~ 5의 정수 난수

총 11개의 숫자가 필요하다.

먼저 `11`을 곱한다.

```text
0.0 <= Math.random() * 11 < 11.0
```

`int`로 변환한다.

```text
0 <= (int)(Math.random() * 11) < 11
```

여기에 `-5`를 더한다.

```text
-5 <= (int)(Math.random() * 11) - 5 < 6
```

결과:

```text
-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5
```

따라서 코드로 작성하면:

```java
(int)(Math.random() * 11) - 5
```

---

# 12. switch식

기존 `switch문`과 달리 `switch식`은 **결과값을 반환할 수 있다.**

```java
char grade = switch (score / 10) {
    case 9, 10 -> 'A';
    case 7, 8 -> 'B';
    default -> 'C';
};
```

### 여러 case를 하나로 묶기

콤마(`,`)를 사용하여 여러 case를 하나로 묶을 수 있다.

```java
case 9, 10 -> 'A';
```

### break가 필요하지 않음

화살표(`->`)를 사용하는 switch식에서는 기존 switch문처럼 `break`를 작성하지 않아도 다음 case로 넘어가지 않는다.

### 반드시 결과를 반환해야 함

switch식의 결과를 변수에 저장하는 경우 모든 경우에 값을 반환할 수 있어야 한다.

```java
char grade = switch (score / 10) {
    case 9, 10 -> 'A';
    case 8, 7 -> 'B';
    default -> 'C';
};
```

switch식이 끝난 후에는 **세미콜론(`;`)**을 작성해야 한다.

---

# 13. if문과 switch식의 차이

`if`문은 조건을 작성하는 과정에서 특정 경우를 빠뜨릴 수 있다.

반면 `switch식`은 결과값을 반환해야 하기 때문에 모든 경우가 처리되지 않으면 오류가 발생한다.

따라서 여러 경우를 빠짐없이 처리해야 하는 상황에서는 switch식이 유용할 수 있다.

---

# 14. 반복문

반복문은 특정 조건이 만족되는 동안 코드를 반복해서 실행한다.

Java의 대표적인 반복문은 다음과 같다.

- `for`
- `while`
- `do-while`

---

# 15. for문

반복 횟수를 알고 있을 때 주로 사용한다.

```java
for (초기화; 조건식; 증감식) {
    // 반복할 문장
}
```

실행 순서는 다음과 같다.

```text
초기화
↓
조건식 확인
↓
실행
↓
증감식
↓
조건식 확인
↓
실행
...
```

### 예제

```java
for (int i = 1; i <= 5; i++) {
    System.out.println("I can do it");
}
```

`i`는 다음과 같이 변한다.

```text
1 → 2 → 3 → 4 → 5
```

따라서 총 5번 반복된다.

---

# 16. for문의 조건식 주의

조건식을 잘못 작성하면 반복 횟수가 예상과 달라질 수 있다.

```java
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}
```

위 코드는 `1`부터 `5`까지 총 5번 반복한다.

```text
1
2
3
4
5
```

---

# 17. 1, 2, 3을 반복하는 for문

`나머지 연산자(%)`를 이용하면 `1, 2, 3`을 반복해서 출력할 수 있다.

```java
for (int i = 1; i <= 10; i++) {
    System.out.println(i % 3 + 1);
}
```

`i % 3`의 결과가 반복된다.

```text
1 % 3 → 1
2 % 3 → 2
3 % 3 → 0
4 % 3 → 1
5 % 3 → 2
...
```

여기에 `1`을 더하면:

```text
2
3
1
2
3
1
2
3
1
2
```

---

# 18. print / println / printf

### print

줄바꿈을 하지 않는다.

```java
System.out.print("Hello");
System.out.print("Java");
```

출력:

```text
HelloJava
```

### println

출력 후 줄을 바꾼다.

```java
System.out.println("Hello");
System.out.println("Java");
```

출력:

```text
Hello
Java
```

### printf

형식을 지정하여 출력할 때 사용한다.

```java
System.out.printf("이름: %s, 나이: %d", name, age);
```

Python의 f-string과 비슷하게 형식을 지정하여 값을 출력할 수 있다.

---

# 19. 향상된 for문

배열이나 컬렉션의 요소를 하나씩 꺼낼 때 사용하는 반복문이다.

```java
for (타입 변수명 : 배열 또는 컬렉션) {
    // 반복할 문장
}
```

예제:

```java
int[] arr = {10, 20, 30, 40};

for (int tmp : arr) {
    System.out.println(tmp);
}
```

배열의 요소가 하나씩 `tmp`에 저장되어 출력된다.

```text
10
20
30
40
```

---

# 20. while문

반복 횟수를 미리 알기 어려울 때 주로 사용한다.

```java
while (조건식) {
    // 반복할 문장
}
```

조건식이 `true`인 동안 계속 반복한다.

```java
int i = 1;

while (i <= 5) {
    System.out.println(i);
    i++;
}
```

출력:

```text
1
2
3
4
5
```

---

# 21. do-while문

`do-while`문은 **do 블록을 먼저 실행한 후 조건식을 검사한다.**

```java
do {
    // 먼저 실행
} while (조건식);
```

따라서 조건이 처음부터 `false`여도 `do` 안의 코드는 **최소 한 번 실행된다.**

```java
do {
    System.out.println("실행");
} while (false);
```

출력:

```text
실행
```

입력을 받은 후 조건을 검사하는 상황 등에서 사용할 수 있다.

> `do-while`문의 마지막에는 세미콜론(`;`)을 작성해야 한다.

---

# 22. 무한 반복문

조건이 항상 `true`이면 반복문은 종료되지 않고 계속 실행된다.

### for문

`for`문의 조건식을 생략할 수 있다.

```java
for (;;) {
    System.out.println("무한 반복");
}
```

### while문

```java
while (true) {
    System.out.println("무한 반복");
}
```

무한 반복을 종료하려면 일반적으로 `break` 등을 사용한다.

---

# 23. continue문

`continue`는 현재 반복을 중단하고 **다음 반복으로 건너뛴다.**

예를 들어 3의 배수를 건너뛸 수 있다.

```java
for (int i = 0; i <= 10; i++) {

    if (i % 3 == 0) {
        continue;
    }

    System.out.println(i);
}
```

`i`가 3의 배수이면 `continue`가 실행되어 `System.out.println(i)`를 실행하지 않고 다음 반복으로 넘어간다.

출력:

```text
1
2
4
5
7
8
10
```

즉,

```text
조건 만족
↓
continue
↓
현재 반복 건너뜀
↓
다음 반복
```

---

# 핵심 정리

| 구분 | 특징 |
|---|---|
| `if` | 조건에 따라 실행 여부를 결정 |
| `switch` | 여러 경우를 처리하기 좋음 |
| `switch식` | `switch`의 결과값을 반환 |
| `for` | 반복 횟수를 알 때 주로 사용 |
| `while` | 반복 횟수를 모를 때 주로 사용 |
| `do-while` | 코드를 먼저 실행한 후 조건 검사 |
| `break` | 반복문 또는 switch문을 즉시 종료 |
| `continue` | 현재 반복을 건너뛰고 다음 반복 실행 |
| `Math.random()` | `0.0 이상 1.0 미만`의 실수 난수 생성 |
| `equals()` | 문자열의 내용을 비교 |
| `equalsIgnoreCase()` | 대소문자를 무시하고 문자열 비교 |

---

# 핵심 흐름

```text
FLOW-CONTROL
│
├── 조건문
│   ├── if
│   ├── 중첩 if
│   ├── switch
│   └── switch식
│
├── 난수
│   └── Math.random()
│
└── 반복문
    ├── for
    ├── 향상된 for
    ├── while
    ├── do-while
    ├── 무한 반복
    └── continue
```
```