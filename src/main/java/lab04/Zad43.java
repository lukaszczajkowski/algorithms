package lab04;

import java.util.Random;

public class Zad43 {

    public int game() {
        int amount = 100;

        for (int i = 0; i < 10; i++) {
            System.out.println("Round " + (i + 1) + ", fight!");
            amount = playRound(amount);

            // nie ma tego w tresci zadania ale zakladamy tutaj ze jak gracz dojdzie to kwoty mniejszej niz 20 zl gra sie przerywa
            // bo nie ma z czego przegrac - trzeba dopytac prowadzacego czy zakladamy taki wariant czy tez balans na koniec
            // moze byc ujemny -> w tym drugim przypadku po prostu usuwamy ten warunek
            if (amount < 20) {
                return amount;
            }
        }

        return amount;
    }

    private int playRound(int amount) {
        int firstRoll = rollDice();

        System.out.println("First roll = " + firstRoll);

        boolean isFirstRollWinning = firstRoll == 7 || firstRoll == 11;
        boolean isFirstRollLosing = firstRoll == 2 || firstRoll == 3 || firstRoll == 12;
        int amountLost = 20;
        int amountWon = 30;

        if (isFirstRollLosing) {
            amount -= amountLost;
            System.out.println("Player lost! Current balance = " + amount);
            return amount;
        }

        if (isFirstRollWinning) {
            amount += amountWon;
            System.out.println("Player won! Current balance = " + amount);
            return amount;
        }

        while (true) {
            int currentPoints = rollDice();

            System.out.println("Rolled points = " + currentPoints);

            if (currentPoints == 7) {
                amount -= amountLost;
                System.out.println("Player lost! Current balance = " + amount);
                return amount;
            }

            if (currentPoints == firstRoll) {
                amount += amountWon;
                System.out.println("Player won! Current balance = " + amount);
                return amount;
            }
        }
    }

    private static int rollDice() {
        Random random = new Random();
        return random.nextInt(12) + 1;
    }
}
