package check;

import java.util.List;
import java.util.stream.Collectors;

public class AnagramCheckList extends AbstractAnagramCheck {

    public AnagramCheckList(TextPreprocessor preprocessor) {
        super(preprocessor);
    }

    @Override
    protected boolean isAnagramImpl(String textA, String textB) {
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
