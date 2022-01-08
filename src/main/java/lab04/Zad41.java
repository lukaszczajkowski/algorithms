package lab04;

public class Zad41 {

    /* Silnia n! rekurencyjnie
     * Zasada dzialania na przykladzie liczby 3
     * factorialRecursive(3) = 3 * factorialRecursive(2) => (2 poniewaz 3 - 1 = 2)
     * factorialRecursive(2) = 2 * factorialRecursive(1)
     * factorialRecursive(1) = 1 -> base case zdefiniowany przez nas w kodzie, bez tego bedzie stack overflow
     * Mamy teraz pierwsza wiadoma wartosc factorialRecursive(1) = 1 wiec "zwijamy" call stack (stos wywolan) w ten sposob:
     * factorialRecursive(2) = 2 * factorialRecursive(1) = 2 * 1 = 2;
     * factorialRecursive(3) = 3 * factorialRecursive(2) = 3 * 2 = 6.
     * czyli 3! = 6 - koniec!
     */
    public static int factorialRecursive(int n) {
        //tu zabezpieczamy przed zlym inputem uzytkownika - wartosc nie moze byc mniejsza od 1!
        if (n < 1) {
            //System.out.println("Value n cannot be lower than 1!");
            return 1;
        }
        // base case: jezeli wywolujemy funkcje z argumentem 1 to chcemy zwrocic 1
        // bez dalszego pomniejszania argumentu o 1
        if (n == 1) {
            return 1;
        }

        return n * factorialRecursive(n - 1);
    }

    public static int factorialIterative(int n) {
        //tu zabezpieczamy przed zlym inputem uzytkownika - wartosc nie moze byc mniejsza od 1!
        if (n <= 1) {
            return 1;
        }

        int factorial = 1;

        for (int i = 1; i <= n; i++) {
            //innymi slowy: factorial = factorial * i
            factorial *= i;
        }

        return factorial;
    }

    public static int symbolNewtona(int n, int k) {
        // tu zabezpieczamy przed zlym inputem uzytkownika - mamy ograniczenie 0 <= k <= n
        if (k == 0 || n < k) {
            return 1;
        }
        return factorialRecursive(n) / (factorialRecursive(k) * factorialRecursive(n - k));
    }

    // Tu wykorzystamy funkcje symbolNewtona() ktora obliczy nam wartosc w danymi miejscu
    public static void pascalTriangle(int rows) {
        if (rows < 1) {
            System.out.println("Rows cannot be less than 1");
            System.out.println(1);
            return;
        }

        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= rows - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(" " + symbolNewtona(i, j));
            }
            System.out.println();
        }
    }
}
