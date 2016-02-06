import java.io.File;
import java.io.IOException;

import java.io.FileReader;
import java.io.BufferedReader;

/**
 * TextGenerator.java.
 * Creates an order K Markov model of the supplied
 * source text, and then outputs M characters generated
 * according to the model.
 *
 * @author     Xing Wang (xzw0005@auburn.edu)
 * @author     Dean Hendrix (dh@auburn.edu)
 * @version    2015-11-16
 * @version	   2015-11-29
 *
 */
public class TextGenerator {
	
	/** Drives execution. */
	
	public static void main(String[] args) {

		// Error checking:
		if (args.length != 3) {
			System.out.println("Invalid number of command lind arguments!");
			return;
		}

		int K, length;
		try {
			K = Integer.parseInt(args[0]);
			if (K < 0) {
				System.out.println("Invalid K: must be nonnegative!");
				return;
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid K: must be integer!");
			return;
		}
		try {
			length = Integer.parseInt(args[1]);
			if (length < 0) {
				System.out.println("Invalid length: must be nonnegative!");
				return;
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid length: must be integer!");
			return;
		}

		StringBuilder sourceText = new StringBuilder();
		try {
			File text = new File(args[2]);
			BufferedReader br = new BufferedReader(new FileReader(text));
			String line;
			while ((line = br.readLine()) != null) 
				sourceText.append(line.trim() + " ");
		} catch (IOException e) {
			System.out.println("Invalid sourceText: file not in the path!");
			return;
		}
		int M = sourceText.length();
		if (M <= K) {
			System.out.println("Invalid arguments: the source file cannot contain less than K characters!");
			return;
		}

		// text generation logic goes here
		MarkovModel lm = new MarkovModel(K, sourceText.toString());
		String init = lm.randomKgram();
		StringBuilder ret = new StringBuilder(init);
		while (ret.length() < length) {
			int index = ret.length() - K;
			String prefix = ret.substring(index);
			ret.append(lm.nextChar(prefix));
		}

		System.out.println(ret.toString());
   }
}
