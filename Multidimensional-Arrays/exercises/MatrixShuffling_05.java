package multidimensionalArrays.exercises;

import java.util.Scanner;

public class MatrixShuffling_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dimensionsInput = scanner.nextLine(); //"3 4".split(" ") -> ["3", "4"]
        int rows = Integer.parseInt(dimensionsInput.split("\\s+")[0]);
        int cols = Integer.parseInt(dimensionsInput.split("\\s+")[1]);

        String [][] matrix = new String[rows][cols];

        fillMatrix(matrix, scanner);

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            if (validateCommand(command, rows, cols)) {
                String [] commandParts = command.split("\\s+");

                int row1 = Integer.parseInt(commandParts[1]); //row, from which we can take the first element
                int col1 = Integer.parseInt(commandParts[2]); //column, from which we can take the first element

                int row2 = Integer.parseInt(commandParts[3]);  //row, from which we can take the second element
                int col2 = Integer.parseInt(commandParts[4]);  //row, from which we can take the second element

                String firstElement = matrix[row1][col1];
                String secondElement = matrix[row2][col2];

                matrix[row1][col1] = secondElement;
                matrix[row2][col2] = firstElement;

                printMatrix(matrix);

            }
            //invalid
            else {
                System.out.println("Invalid input!");
            }
            command = scanner.nextLine();
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length ; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }

    private static boolean validateCommand (String command, int rows, int cols) {
        String [] commandParts = command.split("\\s+");
        //"swap 1 3 4 6".split(" ") -> ["swap", "1", "3", "4", "6"]
        if (commandParts.length != 5) {
            return false;
        }

        //2. swap
        if (!commandParts[0].equals("swap")) {
            return false;
        }

        //3. to check if the command has the given rows and col in the matrix
        int row1 = Integer.parseInt(commandParts[1]); // >= 0 && < number of rows
        int col1 = Integer.parseInt(commandParts[2]); // >= 0 && < number of col
        int row2 = Integer.parseInt(commandParts[3]); // >= 0 && < number of rows
        int col2 = Integer.parseInt(commandParts[4]); // >= 0 && < number of col

        if (row1 < 0 || row1 >= rows || row2 < 0 || row2 >= rows || col1 < 0 || col1 >= cols || col2 < 0 || col2 >= cols) {
            return false;
        }

        //if the command is valid regarding all parameters
        return true;
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
