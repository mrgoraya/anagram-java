package main.java.com.mrgoraya.anagram;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConsoleOutput {
    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printAnagrams(String input, List<String> anagrams) {
        Collections.sort(anagrams);
        System.out.println("Anagrams of '" + input + "': " + anagrams);
    }

    public List<String> sortAndConvertToArrayList(Iterable<String> collection) {
        List<String> list = new ArrayList<>();
        collection.forEach(list::add);
        Collections.sort(list);
        return list;
    }
}

