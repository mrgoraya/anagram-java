package main.java.com.mrgoraya.anagram;

import java.util.List;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AnagramService anagramService = new AnagramService();
        ConsoleOutput consoleOutput = new ConsoleOutput();
        InputValidator inputValidator = new InputValidator();

        while (true) {
            System.out.print("Enter the string: ");
            String inputStr1 = scanner.nextLine();
            String sortedInputStr1 = inputValidator.cleanAndSortInputString(inputStr1);

            System.out.print("Enter the next string: ");
            String inputStr2 = scanner.nextLine();
            String sortedInputStr2 = inputValidator.cleanAndSortInputString(inputStr2);

            if (anagramService.areAnagrams(sortedInputStr1, sortedInputStr2)) {
                consoleOutput.printMessage("These strings are anagrams!");
                anagramService.precomputeAnagrams(sortedInputStr1, inputStr1);
                anagramService.precomputeAnagrams(sortedInputStr2, inputStr2);
            } else {
                consoleOutput.printMessage("These strings are not anagrams!");
            }

            while (true) {
                System.out.print("Do you want to check more anagrams? (yes/no): ");
                String choice = scanner.nextLine().toLowerCase();
                try {
                    if ("yes".equals(choice)) {
                        break;
                    } else if ("no".equals(choice)) {
                        System.out.print("Enter a text to find its anagrams: ");
                        String searchTextInput = scanner.nextLine();
                        String sortedSearchTextInput = inputValidator.cleanAndSortInputString(searchTextInput);

                        List<String> anagrams = anagramService.searchForAnagrams(sortedSearchTextInput, searchTextInput);
                        consoleOutput.printAnagrams(searchTextInput, anagrams);
                        consoleOutput.printMessage("Goodbye!");
                        scanner.close();
                        return;
                    } else {
                        throw new IllegalArgumentException("Invalid input. Please enter 'yes' or 'no'.");
                    }
                } catch (IllegalArgumentException e) {
                    consoleOutput.printErrorMessage("An error occurred: " + e.getMessage());
                }
            }
        }
    }
}
