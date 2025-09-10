public class MatchesExample {
    public static void main(String[] args) {
        String str1 = "Hello123";
        String str2 = "12345";
        String str3 = "abc";

        // 영문자 + 숫자 조합인지 확인 (전체 검사)
        System.out.println(str1.matches("[A-Za-z0-9]+")); // true
        System.out.println(str2.matches("[A-Za-z0-9]+")); // true
        System.out.println(str3.matches("[0-9]+"));       // false

        // 이메일 형식 확인 예시
        String email = "test@example.com";
        boolean isEmail = email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        System.out.println("이메일 형식인가요? " + isEmail); // true
    }
}
