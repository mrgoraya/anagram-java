package test.java.com.mrgoraya.anagram;

import main.java.com.mrgoraya.anagram.AnagramService;
import main.java.com.mrgoraya.anagram.InputValidator;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class AnagramServiceTest {
    private AnagramService anagramService;
    private InputValidator inputValidator;

    @Before
    public void setUp() {
        anagramService = new AnagramService();
        inputValidator = new InputValidator();
    }

    @Test
    public void testPrecomputeAnagrams() {
        String testSortString = "eilnst";

        anagramService.precomputeAnagrams(testSortString, "Listen");
        anagramService.precomputeAnagrams(testSortString, "silent!");
        anagramService.precomputeAnagrams(testSortString, "Enlist!");

        Set<String> expectedAnagrams = new HashSet<>();
        expectedAnagrams.add("Listen");
        expectedAnagrams.add("silent!");
        expectedAnagrams.add("Enlist!");

        assertEquals(expectedAnagrams, anagramService.anagramMap.get("eilnst"));
    }

    @Test
    public void testAreAnagrams() {
        String testSortedStr1 = inputValidator.cleanAndSortInputString("listen");
        String testSortedStr2 = inputValidator.cleanAndSortInputString("Silent!!");

        assertTrue(anagramService.areAnagrams(testSortedStr1, testSortedStr2));
    }

    @Test
    public void testAreNotAnagrams() {
        String testSortedStr1 = inputValidator.cleanAndSortInputString("listen");
        String testSortedStr2 = inputValidator.cleanAndSortInputString("Apple");

        assertFalse(anagramService.areAnagrams(testSortedStr1, testSortedStr2));
    }

    @Test
    public void testSearchForAnagrams() {
        String testSortString = "eilnst";

        anagramService.precomputeAnagrams(testSortString, "listen");
        anagramService.precomputeAnagrams(testSortString, "silent");
        anagramService.precomputeAnagrams(testSortString, "enlist");

        List<String> anagrams = anagramService.searchForAnagrams(testSortString,"listen");
        List<String> expectedAnagrams = List.of("enlist", "silent");

        assertEquals(expectedAnagrams, anagrams);
    }

    @Test
    public void testSearchForAnagramsEmpty() {
        String testSortString = "eilnst";

        anagramService.precomputeAnagrams(testSortString, "listen");
        anagramService.precomputeAnagrams(testSortString, "silent");

        List<String> anagrams = anagramService.searchForAnagrams("aelpp","apple");

        assertTrue(anagrams.isEmpty());
    }
}
