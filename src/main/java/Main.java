import check.AnagramCheckCompose;
import check.AnagramCheckList;
import check.AnagramCheckMultiSet;
import check.AnagramCheckSimple;
import check.TextPrepocessorImpl;
import check.TextPreprocessor;

public class Main {

    public static void main(String[] args) {
        TextPreprocessor preprocessor = new TextPrepocessorImpl();
        AnagramCollector collector = new AnagramCollector(
                new AnagramCheckCompose(true, new AnagramCheckSimple(preprocessor),
                        new AnagramCheckList(preprocessor), new AnagramCheckMultiSet(preprocessor)));
        new Program(collector, collector).run();
    }
}