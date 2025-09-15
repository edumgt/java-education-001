class Car {
    String color;
    int year;

    // 1️⃣ 기본 생성자
    Car() {

        // System.out.println("기본 생성자 실행");
        this("검정", 2020); // 👉 다른 생성자 호출
        String aaa = "";

    }

    // 2️⃣ 색상만 지정하는 생성자
    Car(String color) {
        this(color, 2020); // 👉 다른 생성자 호출
        System.out.println("색상 지정 생성자 실행");
    }

    // 3️⃣ 색상 + 연식 지정하는 생성자
    Car(String color, int year) {
        this.color = color;
        this.year = year;
        System.out.println("전체 지정 생성자 실행");
    }

    // 🚗 정보 출력 메소드
    void showInfo() {
        System.out.println("자동차 색상: " + color + ", 연식: " + year);
    }
}

// javac -encoding UTF-8 CarExample.java
public class ThisConstructorExample {
    public static void main(String[] args) {
        Car car1 = new Car(); // 기본 생성자 호출
        car1.showInfo();

        Car car2 = new Car("빨강"); // 색상 지정 생성자 호출
        car2.showInfo();

        Car car3 = new Car("노랑", 2022); // 전체 지정 생성자 호출
        car3.showInfo();
    }
}
