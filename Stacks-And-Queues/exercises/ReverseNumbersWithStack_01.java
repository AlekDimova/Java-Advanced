package stacksAndQueues.exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWithStack_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine(); //"1 2 3 4 5"
        String[] inputNumbers = input.split("\\s+"); //["1", "2", "3", "4", "5"]

        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String number : inputNumbers) {
            stack.push(number);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
