package main.java.com.mrgoraya.anagram;

import java.util.*;

public class AnagramService {
    public Map<String, Set<String>> anagramMap = new HashMap<>();
    ConsoleOutput consoleOutput = new ConsoleOutput();

    public void precomputeAnagrams(String sortedStr, String inputStr) {
        anagramMap.computeIfAbsent(sortedStr, k -> new HashSet<>()).add(inputStr);
    }

    public boolean areAnagrams(String str1, String str2) {
        return str1.equals(str2);
    }

    public List<String> searchForAnagrams(String sortedSearchTextInput, String searchTextInput) {
        Set<String> anagrams = anagramMap.getOrDefault(sortedSearchTextInput, new HashSet<>());
        anagrams.remove(searchTextInput);
        return consoleOutput.sortAndConvertToArrayList(anagrams);
    }
}

