package check;

public class AnagramCheckSimple implements AnagramCheck {

    @Override
    public boolean isAnagram(String textA, String textB) {
        // compare textA with textB
        // textA must contain the same letters as textB but in different positions

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

        StringBuilder textBSb = new StringBuilder(textB);
        // step 3: check every character in textA to be contained also in textB
        for (int i = 0; i < textA.length(); i++) {
            char a = textA.charAt(i);
            int foundAt = -1;
            for (int j = 0; j < textBSb.length(); j++) {
                char b = textBSb.charAt(j);
                if (a == b) {
                    foundAt = j;
                    // found the current character of textA in textB so stop searching
                    break;
                }
            }
            // if the current character in textA could not be found in textB it is not an
            // anagram
            if (foundAt == -1) {
                return false;
            }
            // the current character in textA has been found so delete it from textB
            textBSb.deleteCharAt(foundAt);
        }
        // found every character of textA in textB
        return true;
    }
}
