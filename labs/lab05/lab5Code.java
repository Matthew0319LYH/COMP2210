import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.Vector;

public class IteratorExample {
	
	public static <T> String toString(Collection<T> coll) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Iterator<T> itr = coll.iterator();
		while (itr.hasNext()) {
			sb.append(itr.next());
			sb.append(", ");
		}
		sb.delete(sb.length() - 2, sb.length());
		sb.append("]");
		return sb.toString();
	}
	
}



public class TimingCode {
	
	private static final double SECONDS = 1_000_000_000d;
	private static final int NUM_RUNS = 10;
	
	public static void main(String[] args) {
		long start;
		long elapsedTime;
		double avgTime = 0d;
		for (int i = 0; i < NUM_RUNS; i++) {
			start = System.nanoTime();
			foo;
			elapsedTime = System.nanoTime() - start;
			avgTime = avgTime + elapsedTime;
		}
		avgTime = avgTime / NUM_RUNS;
		avgTime = avgTime / SECONDS;
		System.out.printf("%s%4.3f%s\n", "Method foo's running time: ", avgTime, " seconds");
	}
	
	private static void foo() {
      for (int i = 0; i < 100_000; i++) {
         String s1 = "War";
         String s2 = "Eagle";
         String s3 = s1 + s2;
         s1 = null;
         s2 = null;
         s3 = null;
      }
   }
	
}


public class EarlyExit {
	
	private static final int N = 1000000;
	private static final double SECONDS = 1000000000;
	private static final int NUM_RUNS = 10;
	
	public static void main(String[] args) {
		long start;
		long elapsedTime;
		double avgTimeA = 0d;
		double avgTimeB = 0d;
		Integer target = 42;
		
		for (int i = 0; i < NUM_RUNS; i++) {
			List<Integer> list = getRandomListWithSeed(N, 42);
			
			start = System.nanoTime();
			EarlyExit.searchA(list, target);
			elapsedTime = System.nanoTime() - start;
			avgTimeA += elapsedTime;
			
			start = System.nanoTime();
			EarlyExit.searchB(list, target);
			elapsedTime = System.nanoTime() - start;
			avgTimeB += elapsedTime;
		}
	
	  avgTimeA = (avgTimeA / NUM_RUNS) / SECONDS;
      avgTimeB = (avgTimeB / NUM_RUNS) / SECONDS;
   
      System.out.printf("%s%4.3f%s\n","Without early exit: ", avgTimeA, " seconds");
      System.out.printf("%s%4.3f%s\n","With early exit:    ", avgTimeB, " seconds");
	}

	public static <T> boolean searchA(List<T> list, T target) {
		boolean found = false;
		for (T element : list) {
			if (element.equals(target))
				found = true;
		}
		return found;
	}
	
	public static <T> boolean searchB(List<T> list, T target) {
		boolean found = false;
		for (T element : list) {
			if (element.equals(target))
				return true;
		}
		return false;
	}
	
	
	private static List<Integer> getRandomListWithSeed(int N, int seed) {
		Random rng = new Random();
		List<Integer> list = new LinkedList<Integer>;
		for (int i = 0; i < N; i++) 
			list.add(i, new Integer(rng.nextInt()));
		int index = rng.nextInt(N - 1) + 1;
		list.set(index, seed);
		return list;
	}
	
}




public class TimeComplexity {
	
	private static final double SECONDS = 1000000000d;
	private static final int NUM_RUNS = 10;
	
	public static void main(String[] args) {
		long start;
		long elapsedTime;
		double avgTime = 0;
		int N = 8;
		System.out.printf("%4s%8s\n", "N", "Time");
		
		for (int i = 0; i < NUM_RUNS; i++) {
			start = System.nanoTime();
			methodToTime(N);
			elapsedTime = System.nanoTime() - start;
			System.out.printf("%4d %8.3f\n", N, (elapsedTime / SECONDS));
			N *= 2;
		}	
	}
	
	private static void methodToTime(int N) {
		
	}
	
}

