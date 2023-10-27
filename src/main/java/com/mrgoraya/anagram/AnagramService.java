package main.java.com.mrgoraya.anagram;

import java.util.*;

import java.util.*;

public class AnagramService {
    public final Map<String, Set<String>> anagramMap = new HashMap<>();

    public void precomputeAnagrams(String inputStr) {
        String sortedStr = cleanAndSortInputString(inputStr);
        anagramMap.computeIfAbsent(sortedStr, k -> new HashSet<>()).add(inputStr);
    }

    public boolean areAnagrams(String str1, String str2) {
        return cleanAndSortInputString(str1).equals(cleanAndSortInputString(str2));
    }

    public List<String> searchForAnagrams(String searchTextInput) {
        String sortedSearchTextInput = cleanAndSortInputString(searchTextInput);
        Set<String> anagrams = anagramMap.getOrDefault(sortedSearchTextInput, new HashSet<>());
        anagrams.remove(searchTextInput);
        return sortAndConvertToArrayList(anagrams);
    }

    private String cleanAndSortInputString(String inputString) {
        String cleanedInput = inputString.replaceAll("[^a-zA-Z]", "").toLowerCase();
        char[] charArray = cleanedInput.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    private List<String> sortAndConvertToArrayList(Iterable<String> collection) {
        List<String> list = new ArrayList<>();
        collection.forEach(list::add);
        Collections.sort(list);
        return list;
    }
}
