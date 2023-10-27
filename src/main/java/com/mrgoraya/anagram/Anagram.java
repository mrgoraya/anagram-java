package main.java.com.mrgoraya.anagram;

import java.util.*;

public class Anagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AnagramService anagramService = new AnagramService();
        ConsoleOutput consoleOutput = new ConsoleOutput();
        InputValidator inputValidator = new InputValidator();

        while (true) {
            String inputStr1 = getUserInput(scanner, inputValidator, "Enter the string: ");
            String inputStr2 = getUserInput(scanner, inputValidator, "Enter the next string: ");

            if (anagramService.areAnagrams(inputStr1, inputStr2)) {
                consoleOutput.printMessage("These strings are anagrams!");
                anagramService.precomputeAnagrams(inputStr1);
                anagramService.precomputeAnagrams(inputStr2);
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
            System.out.print("Do you want to check more anagrams? (yes/no): ");
            String choice = scanner.nextLine().toLowerCase();
            if ("yes".equals(choice)) {
                return true;
            } else if ("no".equals(choice)) {
                String searchTextInput = getUserInput(scanner, inputValidator, "Enter a text to find its anagrams: ");
                List<String> anagrams = anagramService.searchForAnagrams(searchTextInput);
                consoleOutput.printAnagrams(searchTextInput, anagrams);
                consoleOutput.printMessage("Goodbye!");
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }
    }
}
