package functionalProgramming.exercises;

import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine(); //"Peter George Alex"
        String[] names = input.split("\\s+"); //["Peter", "George", "Alex"]

        //solution 1: without functional programming
        /*for (String name : names) {
            System.out.println(name);
        }*/

        //solution 2:
        /*Consumer<String> printName = name -> System.out.println(name);

        for (String name : names) {
            printName.accept(name);
        }*/

        //solution 3:
        Consumer<String[]> printArray = array -> {
            for (String name : array) {
                System.out.println(name);
            }
        };
        printArray.accept(names);

    }
}
