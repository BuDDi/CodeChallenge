import check.AnagramCheckCompose;
import check.AnagramCheckList;
import check.AnagramCheckMultiSet;
import check.AnagramCheckSimple;

public class Main {

    public static void main(String[] args) {
        AnagramCollector collector = new AnagramCollector(new AnagramCheckCompose(true, new AnagramCheckSimple(),
                new AnagramCheckList(), new AnagramCheckMultiSet()));
        new Program(collector, collector).run();
    }
}