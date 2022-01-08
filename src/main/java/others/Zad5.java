package others;

public class Zad5 {

    /*
     * Rozwiazanie moze nie za bardzo eleganckie ale powinno starczyc.
     * Jezeli dobrze rozumiem to sprawdzamy czy a^2 + b^2 = c2.
     * Polecam dopytac prowadzacego czy kolejnosc ma znaczenie, jezeli tak to powinno to byc jeszcze prostsze
     */
    public static int pythagoreanTriple(int a, int b, int c) {

        /*
         * Istnieje taka mozliwosc ze liczby 3, 4, 5 ktore sa pitagorejskie zostana podane w innej kolejnosci, np
         * 5, 4, 3, wiec musimy znalezc najwieksza i "umiescic" ja po prawej stronie rownania czyli c^2
         * Uzyj tutaj funkcji z C++ ktora znajduje najwieksza wartosc z 3 liczb lub tak jak w Java - najwieksza wartosc z
         * liczby a i najwiekszej wartosci z b i c.
         */
        int max = Math.max(a, Math.max(b, c));
        boolean isTrue;

        if (max == a) {
            isTrue = isPythagorean(a, b, c);
        } else if (max == b) {
            isTrue = isPythagorean(b, a, c);
        } else {
            isTrue = isPythagorean(c, a, b);
        }

        return isTrue ? 1 : 0;
    }

    /*
     * Ta funkcja pomocniczna wykonuje cala robote - bierze maksymalna z trzech liczb i umiesza ja po prawej stronie
     * rowniania, kolejnosc pozostalych dwoch nie ma znaczenia - musimy tylko sprawdzic czy jak zsumujemy ich 2 potegi
     * to wyjdzie 2 potega z maksa.
     */
    private static boolean isPythagorean(int max, int second, int third) {
        return (Math.pow(second, 2) + Math.pow(third, 2)) == Math.pow(max, 2);
    }
}
