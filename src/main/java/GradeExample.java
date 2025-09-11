import java.util.Scanner;

public class GradeExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner 객체 생성

        System.out.print("점수를 입력하세요: ");
        int score = sc.nextInt(); // 정수 입력 받기

        if (score >= 90) {
            System.out.println("등급은 A");
        } else if ( score >= 80 ){
            System.out.println("등급은 B");
        } else if ( score >= 70 ){
            System.out.println("등급은 C");
        } else {
            System.out.println("등급은 D");
        }

        sc.close(); // Scanner 닫기 (권장)
    }
}
