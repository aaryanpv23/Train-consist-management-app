import java.util.*;

public class TrainApp3 {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Step 1: Initialize ArrayList
        ArrayList<String> bogies = new ArrayList<>();

        // Step 2: Add Passenger Bogies
        bogies.add("Sleeper");
        bogies.add("AC Chair");
        bogies.add("First Class");

        System.out.println("\nBogies after insertion:");
        System.out.println(bogies);

        // Step 3: Remove a bogie (AC Chair)
        bogies.remove("AC Chair");

        System.out.println("\nAfter removing 'AC Chair':");
        System.out.println(bogies);

        // Step 4: Check existence
        if (bogies.contains("Sleeper")) {
            System.out.println("\n'Sleeper' bogie exists in the train.");
        } else {
            System.out.println("\n'Sleeper' bogie not found.");
        }

        // Final State
        System.out.println("\nFinal Train Consist:");
        System.out.println(bogies);

        System.out.println("\nProgram continues...");
    }
}