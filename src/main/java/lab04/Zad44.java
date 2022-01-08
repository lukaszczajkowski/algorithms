package lab04;

public class Zad44 {

    // wg mnie z zadania wynika ze powinnismy zawsze podstawic wskG i wskM
    // pobierz tylko input od uzytkownika i skorzystaj z tej funkcji to przeliczenia
    public static int przelicz(int wskG, int wskM, boolean MtoG) {
        if (MtoG) {
            wskM = wskG - 621 + ((wskG - 621)/32);
            return wskM;
        } else {
            wskG = wskM - (wskM/32) + 621;
            return wskG;
        }
    }
}
