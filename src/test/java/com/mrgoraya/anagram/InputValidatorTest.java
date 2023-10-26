package test.java.com.mrgoraya.anagram;

import main.java.com.mrgoraya.anagram.InputValidator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InputValidatorTest {
    private InputValidator inputValidator;

    @Before
    public void setUp() {
        inputValidator = new InputValidator();
    }
    @Test
    public void testCleanAndSortString() {
        assertEquals("eilnst", inputValidator.cleanAndSortInputString("Silent"));
        assertEquals("aeinooprst", inputValidator.cleanAndSortInputString("Operations!!!"));
    }

}
