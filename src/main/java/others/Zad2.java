package others;

public class Zad2 {

    public static void calculateFormula(int n, float x) {
        if (n < 1) {
            System.out.println("n has to be >= 1");
            return;
        }
        double result = 0;

        for (int i = 1; i <= n; i++) {
            float factorial = factorial(i);
            result += Math.pow(x, i) /factorial;
        }

        System.out.println("result = " + result);
    }

    private static float factorial(int i) {
        if (i == 1) {
            return 1;
        }

        return i * factorial(i - 1);
    }
}
