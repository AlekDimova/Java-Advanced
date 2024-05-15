package functionalProgramming.exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomMinFunction_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        //solution 1:
        //System.out.println(Collections.min(numbers));

        //solution 2:
        /*Consumer<List<Integer>> printMinNumber = list -> System.out.println(Collections.min(list));
        printMinNumber.accept(numbers);*/

        //solution 3:
        Function<List<Integer>, Integer> getMinNumber = list -> Collections.min(list);
        int minElement = getMinNumber.apply(numbers);
        System.out.println(minElement);
    }
}
