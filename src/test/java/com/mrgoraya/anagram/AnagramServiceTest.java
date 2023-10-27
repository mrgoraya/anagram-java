package test.java.com.mrgoraya.anagram;

import main.java.com.mrgoraya.anagram.AnagramService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class AnagramServiceTest {
    private AnagramService anagramService;

    @BeforeEach
    public void setup() {
        anagramService = new AnagramService();
    }

    @Test
    public void testPrecomputeAnagrams() {
        anagramService.precomputeAnagrams("listen");
        Set<String> anagrams = anagramService.anagramMap.get("eilnst");
        assertTrue(anagrams.contains("listen"));
    }

    @Test
    public void testAreAnagrams() {
        assertTrue(anagramService.areAnagrams("listen", "silent"));
    }

    @Test
    public void testAreNotAnagrams() {
        assertFalse(anagramService.areAnagrams("hello", "world"));
    }

    @Test
    public void testSearchForAnagrams() {
        anagramService.precomputeAnagrams("listen");
        anagramService.precomputeAnagrams("hello");
        List<String> anagrams = anagramService.searchForAnagrams("enlist");
        assertEquals(1, anagrams.size());
        assertTrue(anagrams.contains("listen"));
    }

    @Test
    public void testSearchForNonExistentAnagrams() {
        List<String> anagrams = anagramService.searchForAnagrams("random");
        assertEquals(0, anagrams.size());
    }
}