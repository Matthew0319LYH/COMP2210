import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextGenerator {

	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("Invalid number of command line arguments!");
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
				System.out.println("Invalid M: must be nonnegative!");				
				return;
			}						
		} catch (NumberFormatException e) {
			System.out.println("Invalid M: must be integer!");
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
		if (M <= K){
			System.out.println("Invalid arguments: the source file cannot contain less than K characters!");
			return;
		} 
		
		/*int K = 3;
		int length = 20;
		
		//MarkovModel lm = new MarkovModel(K, sourceText.toString());
		
		StringBuilder sourceText = new StringBuilder();
		try {
			File file = new File("dickens.excerpt.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) 
				sourceText.append(line.trim() + " ");
		} catch (IOException e) {
			System.out.println("Invalid sourceText: file not in the path!");
			return;
		}
		int M = sourceText.length();
		if (M <= K){
			System.out.println("Invalid arguments: the source file cannot contain less than K characters!");
			return;
		} 		
		
		//System.out.println(sourceText.toString());
		
		System.out.println(lm.randomKgram()); */

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
