public class CompareTypes {
    public static void main(String[] args) {
        // 기본 타입
        int a = 10;
        int b = 10;
        System.out.println(a);   // true (값 자체 비교)
        System.out.println(a == b);   // true (값 자체 비교)

        // 참조 타입
        Integer x = new Integer(10);
        Integer y = new Integer(10);
        System.out.println(x == y);   // false (참조 주소 비교)
        System.out.println(x.equals(y)); // true (값 비교)
        
        // String 예제
        String s1 = "hello";
        String s2 = new String("hello");
        System.out.println(s1 == s2);  
        System.out.println(s1.length());    
        System.out.println(s1.equals(s2)); // true (값은 동일)
    }
}
