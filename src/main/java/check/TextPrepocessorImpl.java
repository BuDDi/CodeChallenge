package check;

public class TextPrepocessorImpl implements TextPreprocessor {

    @Override
    public String preprocess(String text) {
        return text.toLowerCase().replaceAll("\\s+", "");
    }

}
