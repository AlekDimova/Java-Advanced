package setsAndMapsAdvanced.exercises;

import java.util.*;

public class HandsOfCards_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();


        Map<String, Set<String>> players = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {

            String playerName = input.split(":\\s+")[0]; //"Peter"
            String cards = input.split(":\\s+")[1]; //"2C, 4H, 9H, AS, QS"
            String [] cardsArr = cards.split(", "); //["2C", "4H", "9H", "AS", QS]

            Set<String> cardsSet = new HashSet<>(); //cards of the player
            cardsSet.addAll(Arrays.asList(cardsArr));

            if (!players.containsKey(playerName)) {
                players.put(playerName, cardsSet);
            } else {
                Set<String> currentCards = players.get(playerName);
                currentCards.addAll(cardsSet);
                players.put(playerName, currentCards);
            }
            input = scanner.nextLine();
        }

        players.entrySet().forEach(entry -> {
            String name = entry.getKey();
            Set<String> cards = entry.getValue();
            int points = getCardsPoints(cards);
            System.out.printf("%s: %d%n", name, points);
        });
    }

    private static int getCardsPoints(Set<String> cards) {
        Map<Character, Integer> symbolsValues = getSymbolsValues();
        int sumPoints = 0;
        for (String card : cards) {

            int points = 0;
            if (card.startsWith("10")) {
                char type = card.charAt(2);
                points = 10 * symbolsValues.get(type);
            } else {
                char power = card.charAt(0); //4
                char type = card.charAt(1); //H
                points = symbolsValues.get(power) * symbolsValues.get(type);
            }

            sumPoints += points;
        }
        return sumPoints;
    }

    private static Map<Character, Integer> getSymbolsValues() {
        Map<Character, Integer> characterValues = new HashMap<>();
        characterValues.put('2', 2);
        characterValues.put('3', 3);
        characterValues.put('4', 4);
        characterValues.put('5', 5);
        characterValues.put('6', 6);
        characterValues.put('7', 7);
        characterValues.put('8', 8);
        characterValues.put('9', 9);
        characterValues.put('J', 11);
        characterValues.put('Q', 12);
        characterValues.put('K', 13);
        characterValues.put('A', 14);
        characterValues.put('S', 4);
        characterValues.put('H', 3);
        characterValues.put('D', 2);
        characterValues.put('C', 1);
        return characterValues;
    }
}
