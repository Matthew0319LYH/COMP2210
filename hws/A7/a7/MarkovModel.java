import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.io.IOException;
import java.util.Random;

import java.util.ArrayList;
/**
 * MarkovModel.java
 * Creates an order K Markov model of the supplied source text.
 * The value of K determines the size of the "kgrams" used
 * to generate the model. A kgram is a sequence of k consecutive
 * characters in the source text.
 *
 * @author     Xing Wang (xzw0005@auburn.edu)
 * @author     Dean Hendrix (dh@auburn.edu)
 * @version    2015-11-16
 * @version	   2015-11-29
 *
 */
public class MarkovModel {

  private int K;
  private StringBuilder text;
  private HashMap<String, ArrayList<Character>> kgramsMap;

    /**
     * Construct the order K model of the file sourceText.
     */
    public MarkovModel(int K, File sourceText) {
        this.K = K;
        this.text = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(sourceText));
            String line;
            while ((line = br.readLine()) != null) {
              if (line.trim().length() != 0)
                text.append(line.trim() + " ");
            }
        } catch (IOException e) {}
        int M = text.length();
        if (M <= K) {
            System.out.println("Invalid sourceText: file not in the path!");
            return;
        }

        this.kgramsMap = new HashMap<String, ArrayList<Character>>(M);
        for (int i = 0; i < M - K; i++) {
            String kgram = text.substring(i, i + K);
            char c = text.charAt(i + K);
            ArrayList<Character> nextChars;
            if (kgramsMap.containsKey(kgram)) 
                nextChars = kgramsMap.get(kgram);
            else  
                nextChars = new ArrayList<Character>();
            nextChars.add(c);
            kgramsMap.put(kgram, nextChars);
        }
   }


    /**
     * Construct the order K model of the string sourceText.
     */
    public MarkovModel(int K, String sourceText) {
        this.K = K;
        this.text = new StringBuilder(sourceText);
        int M = text.length();
        if (M <= K) {
            System.out.println("Invalid sourceText: file not in the path!");
            return;
        }
        this.kgramsMap = new HashMap<String, ArrayList<Character>>(M);
        for (int i = 0; i < M - K; i++) {
            String kgram = text.substring(i, i + K);
            char c = text.charAt(i + K);
            ArrayList<Character> nextChars;
            if (kgramsMap.containsKey(kgram))
                nextChars = kgramsMap.get(kgram);
            else
                nextChars = new ArrayList<Character>();
            nextChars.add(c);
            kgramsMap.put(kgram, nextChars);
        }
    }


    /** Return the first kgram found in the source text. */
    public String firstKgram() {
        return text.substring(0, K);
    }


    /** Return a random kgram from the source text. */
    public String randomKgram() {
        Random rnd = new Random();
        int index = rnd.nextInt(text.length() - K);
        return text.substring(index, index + K);
    }


    /**
     * Return a single character that follows the given
     * kgram in the source text. Select this character
     * according to the probability distribution of all
     * characters the follow the given kgram in the
     * source text.
     */
    public char nextChar(String kgram) {
        while (!kgramsMap.containsKey(kgram)) {
            kgram = randomKgram();
        }
        ArrayList<Character> nextChars = kgramsMap.get(kgram);
        int size = nextChars.size();
        Random rnd = new Random();
        int index = rnd.nextInt(size);
        return nextChars.get(index);
    }

}
