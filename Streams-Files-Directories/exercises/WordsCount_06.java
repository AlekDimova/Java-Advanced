package streamsFilesDirectories.exercises;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordsCount_06 {
    public static void main(String[] args) throws IOException {

        String pathWords = "C:\\Users\\I353529\\Documents\\SoftUni\\Projects\\JavaAdvanced_Jan_2023\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\words.txt";
        List<String> allLinesWithWords = Files.readAllLines(Path.of(pathWords));

        Map<String, Integer> countWords = new HashMap<>();

        for (String line : allLinesWithWords){
            //line = "of which The".split(" ") -> ["of", "which", "The"]
            String [] wordsOnCurrentRow = line.split("\\s+");
            Arrays.stream(wordsOnCurrentRow).forEach(word -> {
                countWords.put(word, 0);
            });
        }

        String pathText = "C:\\Users\\I353529\\Documents\\SoftUni\\Projects\\JavaAdvanced_Jan_2023\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\text.txt";
        List<String> allLinesWithText = Files.readAllLines(Path.of(pathText));
        for (String line : allLinesWithText) {
            line = line.replaceAll("[\\.\\,\\?\\!\\:]", "");
            String [] words = line.split("\\s+");
            for (String word : words) {
                if (countWords.containsKey(word)) {
                    countWords.put(word, countWords.get(word) + 1);
                }
            }
        }


        PrintWriter writer = new PrintWriter("result.txt");
        countWords.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> writer.println(entry.getKey() + " - " + entry.getValue()));
        writer.close();

    }
}
