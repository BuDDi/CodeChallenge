package check;

import java.util.List;
import java.util.stream.Collectors;

public class AnagramCheckList implements AnagramCheck {

    @Override
    public boolean isAnagram(String textA, String textB) {
        // step 1: remove all white spaces and compare the length of both texts
        textA = textA.replaceAll("\\s+", "");
        textB = textB.replaceAll("\\s+", "");

        if (textA.length() != textB.length()) {
            return false;
        }

        textA = textA.toLowerCase();
        textB = textB.toLowerCase();
        // step 2: check if the strings are not the exact same
        if (textA.equals(textB)) {
            return false;
        }

        List<Character> a = convertToList(textA);
        List<Character> b = convertToList(textB);

        return a.containsAll(b);
    }

    private List<Character> convertToList(String input) {
        List<Character> chars = input.chars().mapToObj(e -> (char) e)
                .collect(Collectors.toList());
        return chars;
    }

}
