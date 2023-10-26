package main.java.com.mrgoraya.anagram;

import java.util.Arrays;

public class InputValidator {
    public String cleanAndSortInputString(String inputString) {
        String cleanedInput = inputString.replaceAll("[^a-zA-Z]", "").toLowerCase();

        if (cleanedInput.isEmpty()) {
            throw new IllegalArgumentException("Invalid input. Please enter a valid string.");
        }

        char[] charArray = cleanedInput.toCharArray();
        Arrays.sort(charArray);

        return new String(charArray);
    }
}
