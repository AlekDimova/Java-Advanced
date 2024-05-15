package functionalProgramming.exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindSmallestElement_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        //lastIndexOf -> returns the last index at which we encountered the given element
        //indexOf -> returns the first index at which we encounter the given element

        //solution 1:
        /*Consumer<List<Integer>> printLastIndexOfMinElement = list -> {
            int minElement = Collections.min(list);
            System.out.println(list.lastIndexOf(minElement));
        };
        printLastIndexOfMinElement.accept(numbers);*/

        //solution 2:
        Function<List<Integer>, Integer> getLastIndexOfMinElement = list -> list.lastIndexOf(Collections.min(list));
        int lastIndex = getLastIndexOfMinElement.apply(numbers);
        System.out.println(lastIndex);

    }
}
