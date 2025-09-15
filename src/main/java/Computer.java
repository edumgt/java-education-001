public class Computer {

    int gas1 = 0;
    int gas2 = 0;
    int gas3 = 0;
    int gas4 = 0;
    int gas5 = 0;

    public int getGas1() {
        return gas1;
    }

    public void setGas1(int gas1) {
        this.gas1 = gas1;
    }

    public int getGas2() {
        return gas2;
    }

    public void setGas2(int gas2) {
        this.gas2 = gas2;
    }

    public int getGas3() {
        return gas3;
    }

    public void setGas3(int gas3) {
        this.gas3 = gas3;
    }

    public int getGas4() {
        return gas4;
    }

    public void setGas4(int gas4) {
        this.gas4 = gas4;
    }

    public int getGas5() {
        return gas5;
    }

    public void setGas5(int gas5) {
        this.gas5 = gas5;
    }

    public int sum1(int[] values) {

        System.out.println(this.getGas1());

        int tmpSum = 0;
        tmpSum = this.getGas1();

        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        return sum + tmpSum;

    }

    public int sum2(int... values) {
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        return sum;
    }
}
