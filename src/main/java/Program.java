import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import check.AnagramCheck;
import creator.AnagramCreator;

public class Program implements Runnable {

    private AnagramCheck check;

    private AnagramCreator creator;

    public Program(AnagramCheck check, AnagramCreator creator) {
        if (check == null) {
            throw new IllegalArgumentException("Argument 'check' cannot be null!");
        }
        if (creator == null) {
            throw new IllegalArgumentException("Argument 'creator' cannot be null!");
        }
        this.check = check;
        this.creator = creator;
    }

    @Override
    public void run() {
        Scanner in = new Scanner(System.in);

        boolean interactive = false;
        while (true) {
            System.out.println("Run in interactive mode? (y or N)");
            String text = in.nextLine().trim();
            if (text.isEmpty()) {
                // apply default if no input is given
                break;
            }
            text = text.toLowerCase();
            if ("y".equals(text)) {
                interactive = true;
                break;
            } else if (!"n".equals(text)) {
                // if it is something else than 'n' print an error message and ask again
                System.out.println("Only 'y' or 'n' are possible values.");
            } else {
                break;
            }
        }

        List<String> texts = new ArrayList<>();

        while (true) {
            System.out.println("Enter a text:");
            String text = in.nextLine().trim();
            // if there is an empty line stop reading from console
            if (text.isEmpty()) {
                break;
            }
            texts.add(text);
        }
        if (texts.size() <= 1) {
            System.out.println("Need at least two texts to compare.");
        }

        // compare all given texts
        for (int i = 0; i < texts.size(); i++) {
            String textA = texts.get(i);
            for (int j = i + 1; j < texts.size(); j++) {
                String textB = texts.get(j);

                // perform check and track elapsed time
                boolean isAnagram = check.isAnagram(textA, textB);
                if (isAnagram) {
                    System.out.println("Whoop whoop, we got an anagram here.");
                } else {
                    System.out.println("Come on don't waste my time.");
                }
            }
        }

        // the interactive mode reads again the user input otherwise all anagrams will
        // be printed
        if (interactive) {
            while (true) {
                System.out.println("Enter a text:");
                String text = in.nextLine().trim();
                // if there is an empty line stop reading from console
                if (text.isEmpty()) {
                    break;
                }
                text = text.toLowerCase();
                List<String> angrams = creator.getAnagrams(text);
                if (angrams == null) {
                    System.out.println("No anagrams found for \"" + text + "\"!");
                } else {
                    System.out.println("Anagrams of \"" + text + "\":" + creator.getAnagrams(text));
                }
            }
        } else {
            for (String text : texts) {
                System.out.println("Anagrams of \"" + text + "\":" + creator.getAnagrams(text));
            }
        }
    }

}
