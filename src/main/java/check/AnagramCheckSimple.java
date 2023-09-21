package check;

public class AnagramCheckSimple extends AbstractAnagramCheck {

    public AnagramCheckSimple(TextPreprocessor preprocessor) {
        super(preprocessor);
    }

    @Override
    public boolean isAnagramImpl(String textA, String textB) {
        StringBuilder textBSb = new StringBuilder(textB);
        // check every character in textA to be contained also in textB
        for (int i = 0; i < textA.length(); i++) {
            char a = textA.charAt(i);
            int foundAt = -1;
            // scan for the same letter in textB
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
