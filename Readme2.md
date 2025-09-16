## JVM(Java Virtual Machine)의 메모리 영역은 크게 실행 시 프로그램을 관리하기 위한 공간으로 나뉩니다. 주요 영역을 정리하면 다음과 같습니다:

1. 메서드 영역(Method Area, 클래스 영역)

모든 스레드가 공유.

클래스 관련 메타데이터 저장:

클래스 이름, 메서드 이름, 변수 이름

static 변수

상수(Constant Pool)

Java 8 이후 메타스페이스(Metaspace) 로 대체됨 (네이티브 메모리 사용).

2. 힙 영역(Heap Area)

모든 스레드가 공유.

new 키워드로 생성되는 객체와 배열 저장.

GC(Garbage Collector)의 관리 대상.

크게 두 영역으로 분류:

Young Generation (Eden, Survivor 0, Survivor 1)

Old Generation (Tenured)

3. 스택 영역(Stack Area)

스레드마다 별도로 생성.

메서드 호출 시 프레임 생성:

지역 변수

매개변수

리턴 값

메서드 호출이 끝나면 프레임 제거 → 자동 메모리 관리.

4. PC 레지스터(Program Counter Register)

스레드마다 존재.

현재 실행 중인 JVM 명령어 주소를 저장.

스레드 컨텍스트 스위칭 시 정확히 이어서 실행할 수 있게 함.

5. 네이티브 메서드 스택(Native Method Stack)

자바가 아닌 C/C++ 기반 네이티브 메서드 실행 시 사용.

JNI(Java Native Interface) 호출 시 활용.

📌 정리 그림 (구조적):
![alt text](image-11.png)
┌───────────────────────────────────────────────┐
│                JVM 메모리 구조                 │
├───────────────────────────────────────────────┤
│ Method Area (클래스 정보, static, 상수)        │
│ Heap Area   (객체, 배열 - GC 관리)             │
├───────────────────────────────────────────────┤
│ Stack (스레드별, 지역변수/매개변수/리턴)       │
│ PC Register (스레드별, 실행 위치)              │
│ Native Method Stack (네이티브 코드 실행용)     │
└───────────────────────────────────────────────┘


현재 코드에서는 import com.example.*; 과 import com.hyundai.namyang.*; 을 둘 다 선언해 두셨습니다. 그런데 Car car = new Car(); 처럼 특정하지 않고 클래스 이름만 쓸 경우 자바(Java)의 클래스 탐색 우선순위는 다음과 같습니다:

🔎 자바에서 클래스 탐색 우선순위

같은 패키지(package)

CarExam.java 가 com.example 안에 있기 때문에, 먼저 com.example.Car 을 찾습니다.

명시적 import

같은 이름의 클래스가 현재 패키지에 없으면, import 된 패키지 안에서 찾습니다.

예: com.hyundai.namyang.Car

java.lang 패키지 (자동 import)

String, Integer, Math 같은 클래스는 java.lang 에 있으므로 따로 import 안 해도 인식됩니다.

FQCN (Fully Qualified Class Name) 지정

만약 서로 다른 패키지에 같은 이름의 클래스가 있다면, 충돌이 발생합니다.

이때는 반드시 풀네임으로 명시해야 합니다.

com.example.Car car1 = new com.example.Car();
com.hyundai.namyang.Car car2 = new com.hyundai.namyang.Car();

⚠️ 충돌 상황

현재 구조를 보면:

com.example.Car

com.hyundai.namyang.Car

두 개가 같은 프로젝트에 존재합니다. 따라서 import com.example.*; 와 import com.hyundai.namyang.*; 을 동시에 하면 어떤 Car 클래스를 써야 할지 모호해집니다.
→ 그래서 Car car = new Car(); 은 컴파일 에러가 나요.

✅ 해결 방법

한 쪽만 import

import com.example.Car;
// import com.hyundai.namyang.Car;  // 제거


두 개 다 써야 한다면 FQCN 사용

com.example.Car car1 = new com.example.Car();
com.hyundai.namyang.Car car2 = new com.hyundai.namyang.Car();


👉 정리:
Car car = new Car(); 는 현재 패키지 → import된 패키지 → java.lang 순서로 탐색합니다. 그런데 두 패키지 모두에 Car 가 있으면 반드시 풀네임(FQCN)을 써야 충돌을 피할 수 있습니다.