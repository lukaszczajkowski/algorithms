package others;

public class Pattern {

    public static void printPattern(int n) {
        String[] patterns = new String[n];

        for (int i = 0; i < n; i++) {
            String pattern = "";
            int j = 0;
            while (j < i) {
                pattern += " ";
                j++;
            }
            while (j < n) {
                pattern += "*";
                j++;
            }
            patterns[i] = pattern;
        }

        for (int i = 0; i < patterns.length; i++) {
            System.out.println(patterns[i]);
        }

        for (int i = patterns.length - 1; i >= 0; i--) {
            System.out.println(patterns[i]);
        }
    }
}
