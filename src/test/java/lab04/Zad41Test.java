package lab04;

import org.junit.Test;

import static org.junit.Assert.*;

public class Zad41Test {

    @Test
    public void shouldCalculateFactorialRecursive() {
        System.out.println(Zad41.factorialRecursive(3));
    }

    @Test
    public void shouldCalculateFactorialIterative() {
        System.out.println(Zad41.factorialIterative(3));
    }

    @Test
    public void shouldCaltulateSymbolNewtona() {
        System.out.println(Zad41.symbolNewtona(10, 3));
    }

    @Test
    public void shouldPrintPascalTriangle() {
        Zad41.pascalTriangle(4);
    }
}