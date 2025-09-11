public class Example2 {
    public static void main(String[] args) {
        int res1 = 30000;
        int res2 = 30000;
        int res3 = (int) (res1 * res2);

        /* String class 를 이용해서, %명 부분에 res1 반영하고, 원 천단위 쉼표 900,000,000 원 표기 */
        System.out.println("마라톤 참가자 %명이 %원씩 내서 총 " + res3 +"원 을 냈습니다.");

    }
}
