package streamsFilesDirectories.exercises;

import java.io.*;

public class AllCapitals_03 {
    public static void main(String[] args) throws IOException {

        String pathToFile = "C:\\Users\\I353529\\Documents\\SoftUni\\Projects\\JavaAdvanced_Jan_2023\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        //solution 1:
        /*List<String> allLines = Files.readAllLines(Path.of(pathToFile));
        for (String line : allLines) {
            writer.write(line.toUpperCase());
            writer.newLine();
        }
        writer.close();*/

        //solution 2:
        BufferedReader reader = new BufferedReader(new FileReader(pathToFile));
        String line = reader.readLine();
        while (line != null) {
            writer.write(line.toUpperCase());
            writer.newLine();

            line = reader.readLine();
        }

        writer.close();

    }
}
