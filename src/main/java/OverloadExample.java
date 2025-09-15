class Calculator {
    int add(int a, int b) {
        return a + b;
    }
    double add(double a, double b) {
        return a + b;
    }
    int add(int a, int b, int c) {
        return a + b + c;
    }
}

public class OverloadExample {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.add(3, 5));        // int 버전
        System.out.println(calc.add(3.2, 5.1));    // double 버전
        System.out.println(calc.add(1, 2, 3));     // 3개 버전
    }
}
