public class MathRandom2 {
    public static void main(String[] args) {
        int num = (int) (Math.random() * 6) + 1; // 1~6 난수 발생

        System.out.println("랜덤 원본 값: " + (Math.random() * 6));
        System.out.println("정수 변환 값: " + num);

        switch (num) {
            case 1:
                System.out.println("1번 입니다.");
                break;
            case 2:
                System.out.println("2번 입니다.");
                break;
            case 3:
                System.out.println("3번 입니다.");
                break;
            case 4:
                System.out.println("4번 입니다.");
                break;
            case 5:
                System.out.println("5번 입니다.");
                break;
            case 6:
                System.out.println("6번 입니다.");
                break;
            default:
                System.out.println("예상치 못한 값: " + num);
                break;
        }
    }
}
