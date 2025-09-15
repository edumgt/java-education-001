public class Example8 {
    public static void main(String[] args) {
        double[] scores = { 83.5, 91.6, 75.7, 98.9 };
        double sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        System.out.println("sum: " + sum);
        int avg = (((int) sum) / 4);
        System.out.println("avg: " + avg);

        String[] names;
        names = new String[] { "aaa", "bbb", "ccc" };

        // System.out.println(names[0]);
        // System.out.println(names[1]);

    }
}
