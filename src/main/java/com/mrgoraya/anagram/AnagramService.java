package main.java.com.mrgoraya.anagram;

import java.util.*;

public class AnagramService {
    public final Map<String, Set<String>> anagramMap = new HashMap<>();

    public void precomputeAnagrams(String inputStr) {
        String sortedStr = cleanAndSortInputString(inputStr);
        anagramMap.computeIfAbsent(sortedStr, k -> new HashSet<>()).add(inputStr);
    }

    public boolean areAnagrams(String firstString, String secondString) {
        return cleanAndSortInputString(firstString).equals(cleanAndSortInputString(secondString));
    }

    public List<String> searchForAnagrams(String searchTextInput) {
        String sortedSearchTextInput = cleanAndSortInputString(searchTextInput);

        Set<String> anagrams = anagramMap.getOrDefault(sortedSearchTextInput, new HashSet<>());
        anagrams.remove(searchTextInput);

        List<String> sortedAnagrams = new ArrayList<>(anagrams);
        Collections.sort(sortedAnagrams);
        return sortedAnagrams;
    }

    private String cleanAndSortInputString(String inputString) {
        String cleanedInput = inputString.replaceAll("[^a-zA-Z]", "").toLowerCase();
        char[] charArray = cleanedInput.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
