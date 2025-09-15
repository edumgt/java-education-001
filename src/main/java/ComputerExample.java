public class ComputerExample {
 public static void main(String[] args) {
    Computer myCom = new Computer();

    int[] values = {1,2,3};
    int rs1 = myCom.sum1(values);
    System.out.println( rs1 );

    int result2 = myCom.sum1(new int[] {1,2,3,4,5});
    System.out.println(result2);

    int result3 = myCom.sum2(1,2,3);
    System.out.println(result3);

    int result4 = myCom.sum2(1,2,3,4,5);
    System.out.println(result4);
 }   
}
