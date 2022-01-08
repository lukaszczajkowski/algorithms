package lab04;

import org.junit.Test;

import static org.junit.Assert.*;

public class Zad44Test {

    @Test
    public void shouldConvertDates() {
        System.out.println(Zad44.przelicz(1258, 170, true));
        System.out.println(Zad44.przelicz(1258, 170, false));
    }
}