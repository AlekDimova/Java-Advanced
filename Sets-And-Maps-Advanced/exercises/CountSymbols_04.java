package setsAndMapsAdvanced.exercises;

import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        TreeMap<Character, Integer> symbolsCount = new TreeMap<>();


        for (int index = 0; index < text.length(); index++) {
            char currentSymbol = text.charAt(index);
            if (symbolsCount.containsKey(currentSymbol)) {
                int currentCount = symbolsCount.get(currentSymbol);
                symbolsCount.put(currentSymbol, currentCount + 1);
            }
            else {
                symbolsCount.put(currentSymbol, 1);
            }
        }

        symbolsCount.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " time/s"));
    }
}
