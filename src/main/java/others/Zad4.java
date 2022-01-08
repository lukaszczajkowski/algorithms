package others;

public class Zad4 {

    // Ta funkcja tylko przyjmuje liczbe i wypisuje wynik dzialania innej funkcji - helper()
    // w ktorej dokonywane sa obliczenia
    public static void convertBase10ToBase8(int n) {
        System.out.println(helper(n));
    }

    /*
     * Funkcja przyjmuje liczbe calkowita (int) i zwraca String z tej liczby z formacie base8.
     * Dzieje sie to przez dzielenie przez 8 jak na przykladzie ponizej gdzie chcemy zwrocic base 8 z 1032:
     * 1032 / 8 = 129 reszta 0
     * 129 / 8 = 16 reszta 1
     * 16 / 8 = 2 reszta 0
     * 2 / 8 = 0 reszta 2
     *
     * Rekursja zwraca wartosci od dolu, wiec pierwsza operacja jaka zostanie wykonana to:
     * 2 / 8 = 0 reszta 2;
     * Tu rowniez uderzamy w base case, gdzie quotient (czesc calkowita) czyli 0 i zwracamy reszte (remainder) czyli 2.
     * Potem rekursja bierze cokolwiek zwrocilismy z base case i kieruje sie ku gorze - w chwili base case mamy 2 i potem:
     * 16 / 8 = 2 reszta 0 -> zalaczamy reszte czyli 0 do aktualnego rozwiazania czyli 2 co daje 20
     * 129 / 8 = 16 reszta 1 -> zalaczamy reszte czyli 1 do aktualnego rozwiazania czyli 20 co daje 201
     * 1032 / 8 = 129 reszta 0 -> zalaczamy reszte czyli 0 do aktualnego rozwiazania czyli 201 co daje 2010
     * W poprzedniej linijce wrocilismy do oryginalnego wywolania funkcji wiec program skonczyl dzialanie!
     *
     * Dobre objasnienie rekurencji jest tu:
     * https://www.youtube.com/watch?v=BNeOE1qMyRA
     * Chodzi o to jak funkcje sa po kolei wywolywane w pamieci - rekurencja to taki urzad w ktorym zeby dostac decyzje
     * z okienka 1 musisz isc do okienka 2 i dopiero po decyzji z okienka 2 dostajesz decyzje z okienka 1. Na poczatku wiec
     * dostajesz decyzje z okienka 2 ktora uzywasz w okienku 1 i tam dostajesz ostateczna decyzje :)
     */
    private static String helper(int n) {
        // czesc calkowita z dzielenia
        int quotient = n / 8;
        // reszta z dzielenia
        int remainder = n % 8;

        // base case (zachodzi tylko raz, na samym koncu dzielenia przez 8):
        // jezeli czesc calkowita == 0 => zwracamy reszte
        if (quotient == 0) {
            // tu zastosuj bibioteke/funkcje ktora przeksztalca int w string w C++
            return Integer.toString(remainder);
        }

        // jezeli powyzszy warunek nie zostanie spelniony, rekursywnie wywolujemy funkcje
        // jako argument podajac czesc calkowita z dzielenia i dolaczamy reszte do "aktualnej" wersji rozwiazania
        return helper(quotient) + remainder;
    }
}
