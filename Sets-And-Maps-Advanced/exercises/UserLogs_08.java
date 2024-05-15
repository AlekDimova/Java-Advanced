package setsAndMapsAdvanced.exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        TreeMap<String, LinkedHashMap<String, Integer>> data = new TreeMap<>(); //username -> map with all ip(ip code-> count numbers)

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            //input = "IP={IP.Address} message={A&sample&message} user={username}"
            //input.split() -> ["IP={IP.Address}", "message={A&sample&message}", "user={username}"]
            //input.split()[0] -> "IP={IP.Address}".split("=") -> ["IP", "{ip addres}"]
            //input.split()[1] -> "message={A&sample&message}".split("=") -> ["message", "{message}"]
            //input.split()[2] -> "user={username}".split("=") -> ["user", "{username}"]
            String ip = input.split("\\s+")[0].split("=")[1];
            String username = input.split("\\s+")[2].split("=")[1];

            if (!data.containsKey(username)) {
                data.put(username, new LinkedHashMap<>());
            }


            Map<String, Integer> currentIps = data.get(username);
            if (!currentIps.containsKey(ip)) {
                currentIps.put(ip, 1);
            } else {
                currentIps.put(ip, currentIps.get(ip) + 1);
            }
            input = scanner.nextLine();
        }

        for (String username : data.keySet()) {
            System.out.println(username + ": ");

            Map<String, Integer> currentIps = data.get(username);

            int countIps = currentIps.size();
            //currentIps: ip (key) -> count(value)
            for (String ip : currentIps.keySet()) {
                if (countIps == 1) {
                    System.out.println(ip + " => " + currentIps.get(ip) + ".");
                } else {
                    System.out.print(ip + " => " + currentIps.get(ip) + ", ");
                }
                countIps--;
            }
        }
    }
}
