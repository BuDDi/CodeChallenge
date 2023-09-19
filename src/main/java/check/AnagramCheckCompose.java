package check;

public class AnagramCheckCompose implements AnagramCheck {

    private boolean printTime;

    private AnagramCheck[] checkers;

    public AnagramCheckCompose(boolean printTime, AnagramCheck... checkers) {
        if (checkers == null) {
            throw new IllegalArgumentException("Argument checkers cannot be null!");
        }
        this.printTime = printTime;
        this.checkers = checkers;
    }

    @Override
    public boolean isAnagram(String textA, String textB) {
        boolean result = false;
        for (AnagramCheck anagramCheck : checkers) {
            long time = System.currentTimeMillis();
            // it is expected here that all checkers do a proper job so that result is
            // always overwritten
            result = anagramCheck.isAnagram(textA, textB);
            if (printTime) {
                long elapsed = System.currentTimeMillis() - time;
                System.out
                        .println("Elapsed time for " + anagramCheck.getClass().getSimpleName() + ": " + elapsed + "ms");
            }
        }
        return result;
    }

}
