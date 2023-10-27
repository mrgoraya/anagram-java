package main.java.com.mrgoraya.anagram;

import java.util.Collections;
import java.util.List;

public class ConsoleOutput {
    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printAnagrams(String input, List<String> anagrams) {
        Collections.sort(anagrams);
        System.out.println("Anagrams of '" + input + "': " + anagrams);
    }
}

