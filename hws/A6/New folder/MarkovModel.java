import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import java.util.ArrayList;

public class MarkovModel {
	
	private int K;
	private StringBuilder text;
	private HashMap<String, ArrayList<Character>> kgramsMap;
	
	public MarkovModel(int K, File sourceText) {
		this.K = K;
		this.text = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new FileReader(sourceText));
			//int value;
			//while ((value = br.read()) != -1) {
			//	char c = (char)value;
			//	text.append(c);
			//}
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
			//throw new IllegalArgumentException();
		}
		//firstKgram = text.substring(0, K);
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
	
	
	public MarkovModel(int K, String sourceText) {
		this.K = K;
		this.text = new StringBuilder(sourceText);
		int M = text.length();
		if (M <= K) {
			System.out.println("Invalid sourceText: file not in the path!");
			return;
			//throw new IllegalArgumentException();
		}
		//firstKgram = text.substring(0, K);
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
	
	public String firstKgram() {
		return text.substring(0, K);
	}
	
	public String randomKgram() {
		//int K = firstKgram.length();
		Random rnd = new Random();
		int index = rnd.nextInt(text.length() - K);
		return text.substring(index, index + K);
	}
	
	public char nextChar(String kgram) {
		//return '\u0000';
		//while (kgram == null || kgramsMap.get(kgram) == null){
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
