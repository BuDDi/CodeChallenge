import check.AnagramCheckCompose;
import check.AnagramCheckSimple;

public class Main {

    public static void main(String[] args) {
        AnagramCollector collector = new AnagramCollector(new AnagramCheckCompose(true, new AnagramCheckSimple()));
        new Program(collector, collector).run();
    }
}