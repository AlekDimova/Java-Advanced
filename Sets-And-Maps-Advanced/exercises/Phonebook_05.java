package setsAndMapsAdvanced.exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //person name-> phone number
        Map<String, String> phonebook = new HashMap<>();
        String data = scanner.nextLine();

        //1. fill the phonebook
        while (!data.equals("search")) {
            //data = "John-0888080808".split("-") -> ["John", "0888080808"]
            String name = data.split("-")[0];
            String phoneNumber = data.split("-")[1];
            phonebook.put(name, phoneNumber);
            data = scanner.nextLine();
        }

        //2. search in phonebook
        String name = scanner.nextLine();
        while (!name.equals("stop")) {
            if (phonebook.containsKey(name)) {
                System.out.println(name + " -> " + phonebook.get(name));
            } else {
                System.out.printf("Contact %s does not exist.%n", name);
            }

            name = scanner.nextLine();
        }

    }
}
