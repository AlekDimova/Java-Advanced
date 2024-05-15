package setsAndMapsAdvanced.exercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine(); //"4 3"
        int sizeOfFirstSet = Integer.parseInt(input.split("\\s+")[0]); //nb of elements of the first set
        int sizeOfSecondSet = Integer.parseInt(input.split("\\s+")[1]); //nb of elements of the second set

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        //1. filling the 1st set
        for (int number = 1; number <= sizeOfFirstSet; number++) {
            int value = Integer.parseInt(scanner.nextLine());
            firstSet.add(value);
        }

        //2. filling the second set
        for (int number = 1; number <= sizeOfSecondSet; number++) {
            int value = Integer.parseInt(scanner.nextLine());
            secondSet.add(value);
        }



        //solution 1:
        /*Set<Integer> duplicateElements = new LinkedHashSet<>();
        for (int number : firstSet) {
            if (secondSet.contains(number)) {
                duplicateElements.add(number);
                //or
                System.out.print(number + " ");
            }
        }
        //duplicateElements -> all elements, which are in the both sets
        duplicateElements.forEach(el -> System.out.print(el + " "));*/

        //solution 2:
        firstSet.retainAll(secondSet);
        //retainAll -> delete all elements from the firstSet, which are not in the first one
        //set 1 => {3, 5}
        //set 2 => {3, 4, 5}
        //firstSet -> has only elements from the first set
        firstSet.forEach(number -> System.out.print(number + " "));
    }
}
