package check;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class AnagramCheckMultiSet implements AnagramCheck {

    @Override
    public boolean isAnagram(String textA, String textB) {
        if (textA.length() != textB.length()) {
            return false;
        }
        Multiset<Character> multiset1 = HashMultiset.create();
        Multiset<Character> multiset2 = HashMultiset.create();
        for (int i = 0; i < textA.length(); i++) {
            multiset1.add(textA.charAt(i));
            multiset2.add(textB.charAt(i));
        }
        return multiset1.equals(multiset2);
    }

}
