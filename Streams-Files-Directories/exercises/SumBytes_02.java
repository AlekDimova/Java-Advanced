package streamsFilesDirectories.exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SumBytes_02 {
    public static void main(String[] args) throws IOException {
        String pathToFile = "C:\\Users\\I353529\\Documents\\SoftUni\\Projects\\JavaAdvanced_Jan_2023\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        long sum = 0;

        //solution 1:
        /*List<String> allLines = Files.readAllLines(Path.of(pathToFile));

        for (String line : allLines) {
            for (char symbol : line.toCharArray()) {
                sum += symbol;
            }
        }
        System.out.println(sum);*/

        //solution 2:
        //byte -> -127 until 128
        //sbyte -> 0 until 256
        byte [] allBytes = Files.readAllBytes(Path.of(pathToFile));
        for (byte ascii : allBytes) {
            if (ascii != 13 && ascii != 10) {
                sum += ascii;
            }
        }
        System.out.println(sum);
    }
}
