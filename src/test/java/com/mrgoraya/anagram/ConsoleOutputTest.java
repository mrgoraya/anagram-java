package test.java.com.mrgoraya.anagram;

import main.java.com.mrgoraya.anagram.ConsoleOutput;
import main.java.com.mrgoraya.anagram.InputValidator;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ConsoleOutputTest {

    private ConsoleOutput consoleOutput;

    @Before
    public void setUp() {
        consoleOutput = new ConsoleOutput();
    }
    @Test
    public void testSortAndConvertToArrayList() {
        List<String> inputList = List.of("enlist", "silent", "listen");
        List<String> sortedList = consoleOutput.sortAndConvertToArrayList(inputList);
        List<String> expectedList = List.of("enlist", "listen", "silent");

        assertEquals(expectedList, sortedList);
    }
}
