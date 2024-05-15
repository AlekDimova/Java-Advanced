package functionalProgramming.exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsHonor_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine(); //"Peter George Alex"
        String[] names = input.split("\\s+"); //["Peter", "George", "Alex"]

        Consumer<String> printName = name -> System.out.println("Sir " + name);
        Arrays.stream(names).forEach(printName);

        /*for (String name : names) {
            printName.accept(name);
        }*/
    }
}
