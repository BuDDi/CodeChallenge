package check;

public abstract class AbstractAnagramCheck implements AnagramCheck {

    private TextPreprocessor preprocessor;

    public AbstractAnagramCheck(TextPreprocessor preprocessor) {
        if (preprocessor == null) {
            throw new IllegalArgumentException("Argument preprocessor cannot be null!");
        }
        this.preprocessor = preprocessor;
    }

    @Override
    public final boolean isAnagram(String textA, String textB) {
        textA = preprocessor.preprocess(textA);
        textB = preprocessor.preprocess(textB);

        if (textA.length() != textB.length()) {
            return false;
        }
        return isAnagramImpl(textA, textB);
    }

    protected abstract boolean isAnagramImpl(String textA, String textB);
}
