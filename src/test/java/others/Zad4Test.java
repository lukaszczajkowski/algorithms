package others;

import org.junit.Test;

import static org.junit.Assert.*;
import static others.Zad4.convertBase10ToBase8;

public class Zad4Test {

    @Test
    public void shouldConvertBase10ToBase8() {
        convertBase10ToBase8(1032);
        convertBase10ToBase8(12);
    }
}