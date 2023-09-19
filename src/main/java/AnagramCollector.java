import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import check.AnagramCheck;
import creator.AnagramCreator;

public class AnagramCollector implements AnagramCheck, AnagramCreator {

    private AnagramCheck check;

    private HashMap<String, List<String>> anagramMap;

    public AnagramCollector(AnagramCheck check) {
        if (check == null) {
            throw new IllegalArgumentException("Argument check cannot be null!");
        }
        this.check = check;
        this.anagramMap = new HashMap<>();
    }

    @Override
    public boolean isAnagram(String textA, String textB) {
        textA = textA.trim().toLowerCase();
        textB = textB.trim().toLowerCase();
        List<String> anagramsA = anagramMap.get(textA);
        if (anagramsA == null) {
            anagramsA = new ArrayList<>();
            anagramMap.put(textA, anagramsA);
        }
        List<String> anagramsB = anagramMap.get(textB);
        if (anagramsB == null) {
            anagramsB = new ArrayList<>();
            anagramMap.put(textB, anagramsB);
        }
        boolean isAnagram = check.isAnagram(textA, textB);
        if (isAnagram) {
            anagramsA.add(textB);
            anagramsB.add(textA);
        }
        return isAnagram;
    }

    @Override
    public List<String> getAnagrams(String input) {
        input = input.trim().toLowerCase();
        return anagramMap.get(input);
    }

}
