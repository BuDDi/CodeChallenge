package check;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class AnagramCheckMultiSet extends AbstractAnagramCheck {

    public AnagramCheckMultiSet(TextPreprocessor preprocessor) {
        super(preprocessor);
    }

    @Override
    protected boolean isAnagramImpl(String textA, String textB) {
        Multiset<Character> multiset1 = HashMultiset.create();
        Multiset<Character> multiset2 = HashMultiset.create();
        // a bit sneaky here to expect both texts to have the same length
        // but AbstractAnagramCheck does that check
        for (int i = 0; i < textA.length(); i++) {
            multiset1.add(textA.charAt(i));
            multiset2.add(textB.charAt(i));
        }
        // compare the two sets
        return multiset1.equals(multiset2);
    }

}
