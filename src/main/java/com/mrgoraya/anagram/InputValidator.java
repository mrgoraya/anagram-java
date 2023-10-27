package main.java.com.mrgoraya.anagram;

public class InputValidator {
    public void validateInput(String inputString) {
        String cleanedInput = inputString.replaceAll("[^a-zA-Z]", "");

        if (cleanedInput.isEmpty()) {
            throw new IllegalArgumentException("Invalid input. Please enter a valid string.");
        }
    }
}
