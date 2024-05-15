package stacksAndQueues.exercises;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //"5 2 13"

        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();

        //scanner.nextLine() -> "5 2 13".split(" ") -> ["5", "2", "13"]

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        //ADD (push)
        for (int count = 1; count <= n; count++) {
            stack.push(scanner.nextInt());
        }

        //DELETE (pop)
        for (int count = 1; count <= s; count++) {
            stack.pop();
        }


        if (stack.contains(x)) {
            System.out.println("true");
        } else {
            if (stack.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(Collections.min(stack));
            }
        }
    }
}
