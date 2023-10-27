package main.java.com.mrgoraya.anagram;

import java.util.*;

public class Anagram {
    private static final String YES = "yes";
    private static final String NO = "no";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AnagramService anagramService = new AnagramService();
        ConsoleOutput consoleOutput = new ConsoleOutput();
        InputValidator inputValidator = new InputValidator();

        while (true) {
            // Get user input for the first and second strings
            String firstInputString = getUserInput(scanner, inputValidator, "Enter the string: ");
            String secondInputString = getUserInput(scanner, inputValidator, "Enter the next string: ");

            if (anagramService.areAnagrams(firstInputString, secondInputString)) {
                consoleOutput.printMessage("These strings are anagrams!");

                // Precompute anagrams for the first and second strings
                anagramService.precomputeAnagrams(firstInputString);
                anagramService.precomputeAnagrams(secondInputString);
            } else {
                consoleOutput.printMessage("These strings are not anagrams!");
            }

            if (!checkMoreAnagrams(scanner, consoleOutput, inputValidator, anagramService)) {
                scanner.close();
                return;
            }
        }
    }

    private static String getUserInput(Scanner scanner, InputValidator inputValidator, String prompt) {
        while (true) {
            System.out.print(prompt);
            String inputStr = scanner.nextLine();
            try {
                // Validate user input
                inputValidator.validateInput(inputStr);
                return inputStr;
            } catch (IllegalArgumentException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

    private static boolean checkMoreAnagrams(
            Scanner scanner,
            ConsoleOutput consoleOutput,
            InputValidator inputValidator,
            AnagramService anagramService
    ) {
        while (true) {
            System.out.print("Do you want to check more anagrams? (" + YES + "/" + NO + "): ");
            String choice = scanner.nextLine().toLowerCase();
            if (YES.equals(choice)) {
                return true;
            } else if (NO.equals(choice)) {
                String searchTextInput = getUserInput(scanner, inputValidator, "Enter a text to find its anagrams: ");

                // Search for anagrams and display results
                List<String> anagrams = anagramService.searchForAnagrams(searchTextInput);
                consoleOutput.printAnagrams(searchTextInput, anagrams);
                consoleOutput.printMessage("Goodbye!");
                return false;
            } else {
                System.out.print("Do you want to check more anagrams? (" + YES + "/" + NO + "): ");
            }
        }
    }
}
