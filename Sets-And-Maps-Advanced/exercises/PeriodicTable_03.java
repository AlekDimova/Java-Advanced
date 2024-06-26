package setsAndMapsAdvanced.exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> uniqueElements = new TreeSet<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int row = 1; row <= n; row++) {
            String []chemicalElements = scanner.nextLine().split("\\s+"); // "Mo O Ce".split("\\s+") -> ["Mo", "O", "Ce"]
            //solution 1:
            /*for (String el : chemicalElements) {
                uniqueElements.add(el);
            }*/

            //solution 2:
            //Collections.addAll(Arrays.asList(chemicalElements), uniqueElements);

            //solution 3:
            uniqueElements.addAll(Arrays.asList(chemicalElements));
        }

        uniqueElements.forEach(el -> System.out.print(el + " "));
    }
}
