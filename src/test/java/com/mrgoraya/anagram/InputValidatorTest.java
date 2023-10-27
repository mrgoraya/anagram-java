package test.java.com.mrgoraya.anagram;

import main.java.com.mrgoraya.anagram.InputValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputValidatorTest {
    private InputValidator inputValidator;

    @BeforeEach
    public void setup() {
        inputValidator = new InputValidator();
    }

    @Test
    public void testValidInput() {
        String validInput = "abcdef";
        // No exception should be thrown.
        inputValidator.validateInput(validInput);
    }

    @Test
    public void testValidInputWithSpecialCharacters() {
        String validInput = "abcdef!!123";
        // No exception should be thrown.
        inputValidator.validateInput(validInput);
    }

    @Test
    public void testInvalidInputWithDigits() {
        // Invalid input contains digits.
        String invalidInput = "123";
        // Expect an IllegalArgumentException to be thrown.
        assertThrows(IllegalArgumentException.class, () -> inputValidator.validateInput(invalidInput));
    }


    @Test
    public void testEmptyInput() {
        // Empty input is invalid.
        String emptyInput = "";
        // Expect an IllegalArgumentException to be thrown.
        assertThrows(IllegalArgumentException.class, () -> inputValidator.validateInput(emptyInput));
    }
}