# Java 배열(Array)

## 1. 배열이란?

- 같은 타입의 여러 값을 하나의 변수로 묶어서 관리하는 자료구조
- 배열을 사용하면 여러 변수에 각각 이름을 붙이지 않고, 인덱스로 값을 구분할 수 있음
- 배열은 생성된 후 **길이를 변경할 수 없음**

```java
// 배열을 사용하지 않는 경우
int score1, score2, score3, score4, score5;

// 배열을 사용하는 경우
int[] score = new int[5];
```

### 배열의 구조

```text
score (참조 변수)
  |
  v
[ 0 | 0 | 0 | 0 | 0 ]
  0   1   2   3   4
```

- `score`: 배열의 참조값을 저장하는 변수
- `score[0]`: 인덱스가 0인 첫 번째 요소
- 인덱스는 `0`부터 시작하며, 마지막 인덱스는 `배열의 길이 - 1`

## 2. 배열의 선언과 생성

### (1) 배열 선언

```java
int[] score;
```

- `int` 타입의 배열을 다루기 위한 참조 변수 `score`를 선언
- 이 단계에서는 배열의 저장 공간이 생성되지 않음

### (2) 배열 생성

```java
score = new int[5];
```

- `int` 값 5개를 저장할 수 있는 배열 생성
- `new`: 실제 배열 객체를 생성
- `int` 배열의 요소는 별도로 초기화하지 않으면 기본값 `0`으로 초기화됨

### 선언과 생성을 한 번에 하기

```java
int[] score = new int[5];
```

## 3. 배열의 길이

배열의 길이는 `length`로 확인할 수 있음.

```java
int[] score = new int[5];

System.out.println(score.length); // 5
```

- 배열의 길이는 생성할 때 결정됨
- 인덱스 범위는 `0`부터 `length - 1`
- 길이가 5라면 인덱스는 `0~4`

## 4. 배열의 초기화

배열을 생성하면서 원하는 값을 저장하는 것

### (1) `new`를 사용하는 초기화

```java
int[] score = new int[] {50, 60, 70, 80, 90};
```

- `new int[]`: 배열 생성
- `{50, 60, 70, 80, 90}`: 초기화할 값
- 초기화 값의 개수에 따라 배열 길이가 결정됨

### (2) `new`를 생략하는 초기화

```java
int[] score = {50, 60, 70, 80, 90};
```

- 선언과 동시에 초기화할 때는 `new int[]`를 생략할 수 있음

## 5. 배열의 출력

### (1) `for`문으로 출력

```java
int[] score = {50, 60, 70, 80, 90, 100};

for (int i = 0; i < score.length; i++) {
    System.out.println(score[i]);
}
```

- `i`: 배열의 인덱스
- `score[i]`: 해당 인덱스에 저장된 값
- `score.length`를 사용하면 배열 길이가 바뀌어도 반복 조건을 수정할 필요가 없음

### (2) `Arrays.toString()`으로 출력

```java
import java.util.Arrays;

int[] score = {50, 60, 70, 80, 90, 100};

System.out.println(Arrays.toString(score));
```

출력 결과:

```text
[50, 60, 70, 80, 90, 100]
```

- 배열 전체를 읽기 쉬운 문자열 형태로 출력
- `Arrays` 클래스를 사용하려면 `import java.util.Arrays;`가 필요함

## 6. 배열의 복사

배열은 생성 후 길이를 변경할 수 없음. 더 많은 값을 저장하려면 더 큰 배열을 생성한 후 기존 값을 복사해야 함.

### (1) `for`문으로 복사

```java
int[] arr = {1, 2, 3, 4, 5};

// 기존 배열보다 길이가 2배 큰 배열 생성
int[] tmp = new int[arr.length * 2];

// 기존 배열의 값을 새 배열에 복사
for (int i = 0; i < arr.length; i++) {
    tmp[i] = arr[i];
}

// arr이 새 배열을 참조하도록 변경
arr = tmp;
```

### 배열 복사의 과정

1. 기존 배열보다 큰 `tmp` 배열을 생성
2. `for`문으로 기존 배열의 값을 `tmp`에 복사
3. `arr = tmp`로 참조 변수가 새 배열을 가리키도록 변경

```text
복사 전

arr ──> [1 | 2 | 3 | 4 | 5]

복사 후

tmp ──> [1 | 2 | 3 | 4 | 5 | 0 | 0 | 0 | 0 | 0]
  ^
  |
arr
```

- `arr = tmp`는 배열의 값을 복사하는 코드가 아니라, 참조 변수 `arr`이 `tmp`와 같은 배열을 가리키도록 변경하는 코드
- 기존 배열을 가리키는 다른 참조가 없다면, 기존 배열은 더 이상 `arr`을 통해 접근할 수 없음

### (2) `System.arraycopy()`로 복사

```java
System.arraycopy(num, 0, newNum, 0, num.length);
```

| 인자 | 의미 |
|---|---|
| `num` | 원본 배열 |
| `0` | 원본 배열에서 복사를 시작할 인덱스 |
| `newNum` | 값을 복사할 대상 배열 |
| `0` | 대상 배열에서 붙여 넣기를 시작할 인덱스 |
| `num.length` | 복사할 요소의 개수 |

## 7. String 배열

`String` 타입의 값을 여러 개 저장하는 배열

```java
String[] name = new String[3];

name[0] = "Kim";
name[1] = "Park";
name[2] = "Yi";
```

### String 배열의 구조

```text
name
  |
  v
[ 참조값 | 참조값 | 참조값 ]
    |        |        |
   "Kim"   "Park"    "Yi"
```

- `String`은 참조형 타입이므로 배열의 각 요소에는 문자열 객체를 참조하는 값이 저장됨
- `String[]` 배열의 각 요소는 문자열 객체 자체가 아니라 문자열을 참조함

## 8. String 클래스의 주요 메서드

`String`은 문자열을 다루기 위한 클래스이며, 다양한 메서드를 제공함.

### (1) `charAt()`

특정 인덱스의 문자 하나를 반환

```java
String str = "ABCDE";
char ch = str.charAt(3);

System.out.println(ch); // D
```

- 인덱스 3은 네 번째 문자 `D`

### (2) `substring()`

지정한 범위의 문자열을 반환

```java
String str = "012345";
String tmp = str.substring(1, 4);

System.out.println(tmp); // 123
```

- 시작 인덱스 `1`은 포함
- 끝 인덱스 `4`는 제외
- 즉, `1 <= 인덱스 < 4`

### (3) String과 char 배열의 변환

**char 배열 → String**

```java
char[] chArr = {'A', 'B', 'C'};
String str = new String(chArr);
```

**String → char 배열**

```java
String str = "ABC";
char[] tmp = str.toCharArray();
```

- `new String(chArr)`: 문자 배열을 문자열로 변환
- `toCharArray()`: 문자열의 문자들을 `char` 배열로 변환

## 9. 다차원 배열

배열 안에 또 다른 배열을 저장하는 구조

### (1) 2차원 배열의 선언과 생성

```java
int[][] score = new int[4][3];
```

- 4개의 행과 각 행마다 3개의 열을 가진 2차원 배열
- 전체 요소의 개수는 `4 × 3 = 12`
- 행 인덱스 범위: `0~3`
- 열 인덱스 범위: `0~2`

### (2) 2차원 배열의 초기화

```java
int[][] score = {
    {100, 100, 100},
    {20, 20, 20},
    {30, 30, 30}
};
```

### (3) 중첩 `for`문으로 접근

```java
for (int i = 0; i < score.length; i++) {
    for (int j = 0; j < score[i].length; j++) {
        score[i][j] = 10;
    }
}
```

- `score.length`: 행의 개수
- `score[i].length`: `i`번째 행의 열 개수
- `score[i][j]`: `i`번째 행, `j`번째 열의 요소
- 위 코드는 모든 요소를 `10`으로 변경함

## 10. 가변 배열

2차원 배열에서 각 행의 길이를 다르게 설정할 수 있는 배열

```java
int[][] score = new int[5][];

score[0] = new int[4];
score[1] = new int[3];
score[2] = new int[2];
score[3] = new int[2];
score[4] = new int[3];
```

### 구조

```text
score
  |
  +-- score[0] --> [0 | 0 | 0 | 0]
  +-- score[1] --> [0 | 0 | 0]
  +-- score[2] --> [0 | 0]
  +-- score[3] --> [0 | 0]
  +-- score[4] --> [0 | 0 | 0]
```

- `new int[5][]`: 행 5개를 만들고 각 행의 배열은 나중에 생성
- 각 행을 `new int[n]`으로 생성하여 길이를 다르게 설정
- 각 행의 길이가 달라도 `score[i].length`로 해당 행의 길이를 확인할 수 있음

---

## 핵심 요약

- **배열**: 같은 타입의 여러 값을 하나로 묶어 관리
- **인덱스**: `0`부터 시작하며 마지막 인덱스는 `length - 1`
- **`length`**: 배열의 길이
- **`Arrays.toString()`**: 배열을 읽기 쉬운 형태로 출력
- **배열 복사**: 더 큰 배열을 만들고 값을 복사한 뒤 참조 변수를 새 배열에 연결
- **String 배열**: 문자열을 참조하는 값들을 저장
- **2차원 배열**: 행과 열로 구성된 배열
- **가변 배열**: 각 행의 길이가 서로 다른 2차원 배열