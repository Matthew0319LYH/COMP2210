import java.util.List;
import java.util.Set;
import java.util.SortedSet;

import java.util.TreeSet;
import java.util.Scanner;
import java.io.*;


public class Test {
    TreeSet<String> lexicon;

    public void loadLexicon(String fileName) throws IllegalArgumentException {
        TreeSet<String> lexicon = new TreeSet<String>();
        if (fileName == null)
            throw new IllegalArgumentException();
        try {
            file = new File(fileName);
            Scanner scanner = new Scanner(file);
            String line;
            while (file.hasNextLine()) {
                line = file.nextLine();
                lexicon.add(line);
            }
        } catch (FileNotFoundException e) {
              throw new IllegalArgumentException();
        }
    }

    public boolean isValidWord(String wordToCheck) throws IllegalArgumentException {
        if (wordToCheck == null || lexicon == null)
            throw new IllegalArgumentException();

        return lexicon.contains(wordToCheck);
    }

    public static void main(String args[]) {
        loadLexicon("");
        for (String s : lexicon) {
          System.out.println(s);
        }
    }

}
